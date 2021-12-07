package com.simple.juc.mutitask.container;

import com.simple.juc.mutitask.blockqueue.priority.Student;
import org.junit.Test;

/**
 * 功能描述: '
 *
 * @author: WuChengXing
 * @create: 2021-12-07 14:43
 **/
public class ForTest {
    public static void main(String[] args) throws InterruptedException {
        int a = 0;
        int b = 0;
        for (int c = a, p = c; ; ) {
            System.out.println("c: " + c);
            System.out.println("p: " + p);
            a++;
            Thread.sleep(1000);
        }
    }

    @Test
    public void updateTest() {
        Student student = new Student("zs", 123);
        Student a, b;
        b = student;
        a = b;
        System.out.println("a:" + a);
        System.out.println("b:" + b);
        a.setName("jjjj");
        System.out.println("a:" + a);
        System.out.println("b:" + b);
        b.setName("xxxx");
        System.out.println("a:" + a);
        System.out.println("b:" + b);


    }
}
