package com.simple.juc.demo1;

/**
 * 项目: mianshi-test
 * <p>
 * 功能描述: 线程生命周期
 *
 * @author: WuChengXing
 * @create: 2021-03-25 09:01
 **/
public class ThreadLifeCycle {
    public static void main(String[] args) {
        /**
         * 线程的生命周期：
         *      1. 新建状态（New）：新建了一个线程对象
         *      2. 就绪状态（Runnable）：线程对象创建之后，其他线程调用该对象的start方法
         *  该状态的线程位于可运行线程池中，变成可运行，等待获取CPU的使用权
         *      3. 运行状态（Running）：就绪状态获取到了CPU的使用权，执行程序代码
         *      4. 阻塞状态（Blocked）：阻塞状态是因为线程某些原因放弃了CPU的使用权，暂时停止运行；线程只有进入
         *  就绪状态才有机会再次运行；
         *      5. 死亡状态（Dead）：线程执行完了或者因为异常退出了，该线程结束了生命周期；
         *
         * 阻塞状态的情况：
         *      1. 等待阻塞：运行的线程调用wait()方法，该线程会释放占用的所有的资源，JVM会把该线程放入到
         * 线程“等待池”中。进入这个状态后，是不能自动唤醒的，必须要其他线程调用notify或者notifyAll方法才能被唤醒，
         * wait是Object类的方法
         *      2. 同步阻塞：运行的线程在获取对象的同步锁时，该同步锁被别的线程占用，则JVM会把该线程放在
         * “线程池”里面
         *      3. 其他阻塞：运行的线程执行sleep或者join，或者发出io请求时，JVM会把该线程置为阻塞状态；
         *
         *
         *
         *
         */
    }
}
