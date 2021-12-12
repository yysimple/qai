package com.simple.juc.mutitask.threadpool.my;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 功能描述: 自己实现线程池
 *
 * @author: WuChengXing
 * @create: 2021-12-12 18:06
 **/
public class MyThreadPoolExecutor implements ExecutorService {

    /**
     * The main pool control state, ctl, is an atomic integer packing
     * two conceptual fields
     * workerCount, indicating the effective number of threads
     * runState,    indicating whether running, shutting down etc
     * <p>
     * In order to pack them into one int, we limit workerCount to
     * (2^29)-1 (about 500 million) threads rather than (2^31)-1 (2
     * billion) otherwise representable. If this is ever an issue in
     * the future, the variable can be changed to be an AtomicLong,
     * and the shift/mask constants below adjusted. But until the need
     * arises, this code is a bit faster and simpler using an int.
     * <p>
     * The workerCount is the number of workers that have been
     * permitted to start and not permitted to stop.  The value may be
     * transiently different from the actual number of live threads,
     * for example when a ThreadFactory fails to create a thread when
     * asked, and when exiting threads are still performing
     * bookkeeping before terminating. The user-visible pool size is
     * reported as the current size of the workers set.
     * <p>
     * The runState provides the main lifecycle control, taking on values:
     * <p>
     * RUNNING:  Accept new tasks and process queued tasks
     * SHUTDOWN: Don't accept new tasks, but process queued tasks
     * STOP:     Don't accept new tasks, don't process queued tasks,
     * and interrupt in-progress tasks
     * TIDYING:  All tasks have terminated, workerCount is zero,
     * the thread transitioning to state TIDYING
     * will run the terminated() hook method
     * TERMINATED: terminated() has completed
     * <p>
     * The numerical order among these values matters, to allow
     * ordered comparisons. The runState monotonically increases over
     * time, but need not hit each state. The transitions are:
     * <p>
     * RUNNING -> SHUTDOWN
     * On invocation of shutdown(), perhaps implicitly in finalize()
     * (RUNNING or SHUTDOWN) -> STOP
     * On invocation of shutdownNow()
     * SHUTDOWN -> TIDYING
     * When both queue and pool are empty
     * STOP -> TIDYING
     * When pool is empty
     * TIDYING -> TERMINATED
     * When the terminated() hook method has completed
     * <p>
     * Threads waiting in awaitTermination() will return when the
     * state reaches TERMINATED.
     * <p>
     * Detecting the transition from SHUTDOWN to TIDYING is less
     * straightforward than you'd like because the queue may become
     * empty after non-empty and vice versa during SHUTDOWN state, but
     * we can only terminate if, after seeing that it is empty, we see
     * that workerCount is 0 (which sometimes entails a recheck -- see
     * below).
     */
    private final AtomicInteger ctl = new AtomicInteger(ctlOf(RUNNING, 0));

    public AtomicInteger getCtl() {
        return ctl;
    }

    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int CAPACITY = (1 << COUNT_BITS) - 1;

    // runState is stored in the high-order bits
    private static final int RUNNING = -1 << COUNT_BITS;
    private static final int SHUTDOWN = 0 << COUNT_BITS;
    private static final int STOP = 1 << COUNT_BITS;
    private static final int TIDYING = 2 << COUNT_BITS;
    private static final int TERMINATED = 3 << COUNT_BITS;

    // Packing and unpacking ctl
    private static int runStateOf(int c) {
        return c & ~CAPACITY;
    }

    private static int workerCountOf(int c) {
        return c & CAPACITY;
    }

    private static int ctlOf(int rs, int wc) {
        return rs | wc;
    }

    /*
     * Bit field accessors that don't require unpacking ctl.
     * These depend on the bit layout and on workerCount being never negative.
     */

    private static boolean runStateLessThan(int c, int s) {
        return c < s;
    }

    private static boolean runStateAtLeast(int c, int s) {
        return c >= s;
    }

    private static boolean isRunning(int c) {
        return c < SHUTDOWN;
    }

    /**
     * Attempts to CAS-increment the workerCount field of ctl.
     */
    private boolean compareAndIncrementWorkerCount(int expect) {
        return ctl.compareAndSet(expect, expect + 1);
    }

    /**
     * Attempts to CAS-decrement the workerCount field of ctl.
     */
    private boolean compareAndDecrementWorkerCount(int expect) {
        return ctl.compareAndSet(expect, expect - 1);
    }

    /**
     * Decrements the workerCount field of ctl. This is called only on
     * abrupt termination of a thread (see processWorkerExit). Other
     * decrements are performed within getTask.
     */
    private void decrementWorkerCount() {
        do {
        } while (!compareAndDecrementWorkerCount(ctl.get()));
    }

    /**
     * 拿到对应的锁
     */
    private ReentrantLock lock = new ReentrantLock();

    /**
     * 定义核心参数
     */
    private volatile int corePoolSize;
    private volatile int maximumPoolSize;
    private volatile long keepAliveTime;
    private final BlockingQueue<Runnable> workQueue;
    protected final ThreadFactory threadFactory;
    private final MyRejectedExecutionHandler rejectedExecutionHandler;
    private final HashSet<Worker> workers;

    public HashSet<Worker> getWorkers() {
        return workers;
    }

    public Integer countWorkers;

    public MyThreadPoolExecutor(int corePoolSize,
                                int maximumPoolSize,
                                long keepAliveTime,
                                TimeUnit unit,
                                BlockingQueue<Runnable> workQueue,
                                ThreadFactory threadFactory,
                                MyRejectedExecutionHandler handler) {
        // 规定核心线程数最小为 1（因为如果允许核心线程数为 0 要处理一种特例）
        this.corePoolSize = corePoolSize > 0 ? corePoolSize : 1;
        // 规定最大线程数必须 >= 核心线程数
        this.maximumPoolSize = Math.max(maximumPoolSize, corePoolSize);
        // 线程最大空闲时间，不管怎么传参，统一转为 ns 单位，便于处理
        this.keepAliveTime = keepAliveTime <= 0 || unit == null
                ? TimeUnit.SECONDS.toNanos(60)
                : unit.toNanos(keepAliveTime);
        // 工作队列，设置一个默认的无界阻塞队列
        this.workQueue = workQueue == null ? new LinkedBlockingQueue<>() : workQueue;
        // 提供一个默认的线程工厂，自己手写
        this.threadFactory = threadFactory == null ? new MyDefaultThreadFactory() : threadFactory;
        // 提供一个默认的拒绝处理器，自己手写
        this.rejectedExecutionHandler = handler == null ? new DefaultRejectExecutionHandler() : handler;
        // new 一个容器出来保存工作线程
        // 要考虑并发安全，但这里不用线程安全容器，因为后面我们会加锁
        this.workers = new HashSet<>();
    }

    /**
     * 这个是只继承 Runnable，让其实现run方法：这里是用来表示线程池里面的 “工作线程”
     */
    static class Worker extends AbstractQueuedSynchronizer implements Runnable {

        /**
         * 用来判断
         */
        public volatile boolean idle = false;

        /**
         * 所属的线程池
         */
        private MyThreadPoolExecutor executor;

        /**
         * 拿到线程工作
         */
        private ThreadFactory factory;

        // 定义全局任务
        Runnable firstTask;

        /**
         * 这里原生-JDK还会通过线程池去初始化线程
         *
         * @param firstTask
         */
        public Worker(Runnable firstTask, MyThreadPoolExecutor executor) {
            this.firstTask = firstTask;
            this.executor = executor;
        }

        public Worker(MyThreadPoolExecutor executor, ThreadFactory factory, Runnable firstTask) {
            this.firstTask = firstTask;
            this.executor = executor;
            this.factory = factory;
        }

        @Override
        public void run() {
            try {
                Runnable task = firstTask;
                firstTask = null;
                while (task != null || (task = getTaskFromWorkQueue()) != null) {
                    // 1.执行任务前，把当前线程置为非空闲状态
                    // 其它线程如果想并发干点事情，比如 shutdown，看到这个状态，该怎么处理它就有数了。
                    idle = false;
                    //2.执行工作任务
                    try {
                        task.run();
                    } finally {
                        task = null;
                    }
                    //3.任务执行完成后，再把当前线程改回空闲状态
                    idle = true;
                }
            } finally {
                // 4.线程结束前的收尾工作
                // 4.1.清除当前工作线程
                executor.getWorkers().remove(this);
                // 4.2.工作线程数量 -1
                executor.decrementWorkerCount();
                // 4.3.尝试使线程池进入 terminated 状态
                // 因为 terminated 状态是线程池根据自身运行状况自动进入的，
                // 所以需要有一些地方来触发线程池检查自身运行状况，看是否需要进入 terminated 状态，
                // 这里是其中一个触发点
                executor.tryTerminate();
            }

        }

        /**
         * 这里是从队列里面拿线程
         * 里面涉及到的线程状态都是从JDK里面实现复制的，几乎是一样的；
         *
         * @return
         */
        private Runnable getTaskFromWorkQueue() {
            BlockingQueue<Runnable> workQueue = executor.getWorkQueue();
            //先把要用到的参数读出来
            int corePoolSize = executor.getCorePoolSize();
            int maxPoolSize = executor.getMaximumPoolSize();
            long keepAliveTime = executor.getKeepAliveTime();
            // 需要套一层死循环，不能因为在拿到任务之前被 interrupt 而 return null 出去
            for (; ; ) {
                int ctl = executor.getCtl().get();
                int state = MyThreadPoolExecutor.runStateOf(ctl);
                // 1.STOP 状态，直接 return null
                if (state == MyThreadPoolExecutor.STOP) {
                    return null;
                }
                // 2.SHUTDOWN 状态，需要做个判断，队列为空才能 return null
                // 同时，这里不需要担心，此时判断为空，后面又有任务加入队列，
                // 这种场景不存在，因为是 SHUTDOWN 状态，已经拒绝接受新任务了
                if (state == MyThreadPoolExecutor.SHUTDOWN && workQueue.isEmpty()) {
                    return null;
                }
                //3.能走到这里，肯定是 RUNNING 状态
                int workerCount = MyThreadPoolExecutor.workerCountOf(ctl);
                try {
                    Runnable runnable;
                    // 3.1.如果当前线程数量 > 核心线程数，等待 keepAliveTime，还没有任务，就 return null
                    // 让当前线程结束，使线程数逐渐缩减到核心线程数，所以调用 poll 方法
                    if (workerCount > corePoolSize) {
                        runnable = workQueue.poll(keepAliveTime, TimeUnit.NANOSECONDS);
                    }
                    // 3.2.如果当前工作线程数量 <= 核心线程数，这些线程要保持存活，所以调用 take 方法，一直阻塞即可
                    else {
                        runnable = workQueue.take();
                    }
                    return runnable;
                } catch (InterruptedException e) {
                    //任何原因导致的打断异常，全都吃掉，因为上面的代码已经对所有状态做了处理，
                    //所以不会有问题
                }
            }
        }
    }

    private void tryTerminate() {
    }

    @Override
    public void shutdown() {
    }

    @Override
    public List<Runnable> shutdownNow() {
        return null;
    }

    @Override
    public boolean isShutdown() {
        return false;
    }

    @Override
    public boolean isTerminated() {
        return false;
    }

    @Override
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public <T> Future<T> submit(Callable<T> task) {
        return null;
    }

    @Override
    public <T> Future<T> submit(Runnable task, T result) {
        return null;
    }

    @Override
    public Future<?> submit(Runnable task) {
        return null;
    }

    @Override
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException {
        return null;
    }

    @Override
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException {
        return null;
    }

    @Override
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException {
        return null;
    }

    @Override
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return null;
    }

    public int getCorePoolSize() {
        return corePoolSize;
    }

    public void setCorePoolSize(int corePoolSize) {
        this.corePoolSize = corePoolSize;
    }

    public int getMaximumPoolSize() {
        return maximumPoolSize;
    }

    public void setMaximumPoolSize(int maximumPoolSize) {
        this.maximumPoolSize = maximumPoolSize;
    }

    public long getKeepAliveTime() {
        return keepAliveTime;
    }

    public void setKeepAliveTime(long keepAliveTime) {
        this.keepAliveTime = keepAliveTime;
    }

    public BlockingQueue<Runnable> getWorkQueue() {
        return workQueue;
    }

    public ThreadFactory getThreadFactory() {
        return threadFactory;
    }

    public MyRejectedExecutionHandler getRejectedExecutionHandler() {
        return rejectedExecutionHandler;
    }

    public Integer getCountWorkers() {
        return countWorkers;
    }

    public void setCountWorkers(Integer countWorkers) {
        this.countWorkers = countWorkers;
    }

    @Override
    public void execute(Runnable command) {
        if (command == null) {
            throw new NullPointerException();
        }
        //有 cas 操作通常就得有自旋
        for (; ; ) {
            //*用一个 AtomicInteger 同时保存线程池状态和线程总数
            //这个实现参考 JDK，后面讲
            int c = ctl.get();
            // 1.如果已经 shutdown/stop/terminated，拒绝接受新任务
            if (runStateOf(c) >= SHUTDOWN) {
                rejectedExecutionHandler.rejectedExecution(command, this);
                return;
            }
            // 2.如果小于 corePoolSize，创建核心线程执行任务
            int workerCount = workerCountOf(c);
            if (workerCount < corePoolSize) {
                try {
                    //创建线程和 shutdown，shutdownNow 方法是互斥的
                    //所以这里加锁处理，不加锁也可以实现，但加锁实现比较容易
                    lock.lock();
                    //线程总数 +1
                    if (compareAndIncrementWorkerCount(c)) {
                        //new 线程同时 start
                        new Worker(this, threadFactory, command).run();
                        return;
                    }
                    //cas failed
                    continue;
                } finally {
                    lock.unlock();
                }
            }
            //3.如果大于 corePoolSize，队列未满，扔进队列
            if (workQueue.offer(command)) {
                return;
            }
            //4.队列已满，创建备用线程执行任务
            //因为距离上次读取线程数已经过去比较久了，
            //重新读取线程数，降低 cas 失败的概率
            c = ctl.get();
            workerCount = workerCountOf(c);
            if (workerCount < maximumPoolSize) {
                try {
                    lock.lock();
                    if (compareAndIncrementWorkerCount(c)) {
                        new Worker(this, threadFactory, command).run();
                        return;
                    }
                } finally {
                    lock.unlock();
                }
            }
            //5.备用线程已用完，拒绝任务
            rejectedExecutionHandler.rejectedExecution(command, this);
            return;
        }
    }

    /**
     * ================= 定义自己的拒绝策略 ===================
     * 这里可以看看 JDK线程池里面实现：
     * 1. ThreadPoolExecutor.AbortPolicy：默认拒绝处理策略，丢弃任务并抛出RejectedExecutionException异常。
     * 2. ThreadPoolExecutor.DiscardPolicy：丢弃新来的任务，但是不抛出异常。
     * 3. ThreadPoolExecutor.DiscardOldestPolicy：丢弃队列头部（最旧的）的任务，然后重新尝试执行程序（如果再次失败，重复此过程）。
     * 4. ThreadPoolExecutor.CallerRunsPolicy：由调用线程处理该任务。
     * <p>
     * 那我们这里就简单定义一个抛出异常的，当成默认的拒绝策略
     */
    static class DefaultRejectExecutionHandler implements MyRejectedExecutionHandler {

        public DefaultRejectExecutionHandler() {
        }

        @Override
        public void rejectedExecution(Runnable r, MyThreadPoolExecutor executor) {
            throw new RejectedExecutionException("不好意思，我不能帮你处理了，你要被我丢弃了");
        }
    }

}
