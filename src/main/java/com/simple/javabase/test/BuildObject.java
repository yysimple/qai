package com.simple.javabase.test;

import com.simple.javabase.inherit.User;
import com.simple.javabase.inherit.impl.Staff;

/**
 * @author WuChengXing
 * @date 2021/7/27
 */
public class BuildObject {
    public static void main(String[] args) {
        User user1 = buildUser("zhangsan");
        user1.setAge(18);
        User user2 = buildUser("lisi");
        user2.setAge(19);

        System.out.println(user1);
        System.out.println(user2);
    }

    public static User buildUser(String name){
        User user = new User();
        user.setName(name);
        return user;
    }
}
