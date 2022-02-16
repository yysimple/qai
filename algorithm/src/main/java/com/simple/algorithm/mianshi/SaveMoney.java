package com.simple.algorithm.mianshi;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2022-02-15 22:17
 **/
public class SaveMoney {
    public static void main(String[] args) {
        BaseAccount account = new BaseAccount();
        ExecutorService service = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 100; i++) {
            service.submit(new SaveMoneyThread(account, 1));
        }
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("最终账户余额：" + account.getBalance());
    }

}

class BaseAccount {
    private double balance; // 账户余额
    ReentrantLock accountLock = new ReentrantLock();

    /**
     * 存款
     *
     * @param money 存入金额
     */
    public void deposit(double money) {
        //todo 上锁
        accountLock.lock();
        try {
            double newBalance = balance + money;
            try {
                // 模拟存入的时间耗费
                TimeUnit.MICROSECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            balance = newBalance;
        } finally {
            accountLock.unlock();
        }
    }

    /**
     * 获得账户余额
     */
    public double getBalance() {
        return balance;
    }
}

class SaveMoneyThread implements Runnable {

    private BaseAccount account;
    private double money;

    public SaveMoneyThread(BaseAccount account, double money) {
        this.account = account;
        this.money = money;
    }

    @Override
    public void run() {
        account.deposit(money);
    }
}

