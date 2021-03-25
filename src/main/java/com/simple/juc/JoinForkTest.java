package com.simple.juc;

/**
 * 项目: mianshi-test
 * <p>
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-03-24 17:35
 **/
public class JoinForkTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {

                }
                System.out.println(11111);
            }
        });
        thread.start();
        // 加上join()后，会先执行thread线程，main线程后面执行
        // 在哪个（A）线程里面，其他线程（B）调用了join，那么A线程就会阻塞，先运行B
        thread.join();
        System.out.println(222222);
    }
}
