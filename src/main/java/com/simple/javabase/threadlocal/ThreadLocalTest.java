package com.simple.javabase.threadlocal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2022-01-17 12:06
 **/
public class ThreadLocalTest {
    private List<String> messages = new ArrayList<>();

    public static final ThreadLocal<ThreadLocalTest> holder = ThreadLocal.withInitial(ThreadLocalTest::new);

    public static void add(String message) {
        holder.get().messages.add(message);
    }

    public static List<String> clear() {
        List<String> messages = holder.get().messages;
        holder.remove();

        System.out.println("size: " + holder.get().messages.size());
        return messages;
    }

    public static void main(String[] args) {
        ThreadLocalTest.add("hahahaha");
        System.out.println(holder.get().messages);
        ThreadLocalTest.clear();
    }
}
