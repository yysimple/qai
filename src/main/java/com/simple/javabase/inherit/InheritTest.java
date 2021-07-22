package com.simple.javabase.inherit;

import com.simple.javabase.inherit.impl.Staff;

/**
 * @author WuChengXing
 * @date 2021/7/22
 */
public class InheritTest {
    public static void main(String[] args) {
        Staff staff = new Staff();
        staff.setName("儿子-张三");
        staff.setAge(18);
        staff.setStaffNo("zs0018");
        User user = (User) staff;
        System.out.println();
    }
}
