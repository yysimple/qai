package com.simple.javabase.inherit.impl;

import com.simple.javabase.inherit.User;
import lombok.Data;

/**
 * 功能描述: 员工
 *
 * @author: WuChengXing
 * @create: 2021-07-22 23:46
 **/
@Data
public class Staff extends User {

    private String staffNo;
}
