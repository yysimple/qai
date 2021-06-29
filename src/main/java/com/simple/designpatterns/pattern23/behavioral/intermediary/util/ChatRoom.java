package com.simple.designpatterns.pattern23.behavioral.intermediary.util;

import com.simple.designpatterns.pattern23.behavioral.intermediary.User;

import java.util.Date;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-06-29 10:24
 **/
public final class ChatRoom {
    public static void showMessage(User user, String message) {
        System.out.println(new Date().toString()
                + " [" + user.getName() + "] : " + message);
    }
}
