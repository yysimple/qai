package com.simple.page.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author WuChengXing
 * @date 2021/9/6
 */
@Data
public class StudentTest {
    private Integer id;
    private String name;
    private int age;
    private Date birthday;
    private float height;
    private double weight;
    private boolean sex;
    private String pictures01;
    private String pictures02;
}
