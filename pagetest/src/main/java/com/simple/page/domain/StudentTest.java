package com.simple.page.domain;

import com.simple.annotation.excel.Excel;
import lombok.Data;

import java.util.Date;

/**
 * @author WuChengXing
 * @date 2021/9/6
 */
@Data
public class StudentTest {
    @Excel(name = "id")
    private Integer id;
    @Excel(name = "name")
    private String name;
    @Excel(name = "age")
    private int age;
    @Excel(name = "birthday")
    private Date birthday;
    @Excel(name = "height")
    private float height;
    @Excel(name = "weight")
    private double weight;
    @Excel(name = "sex")
    private boolean sex;
    @Excel(name = "pictures01")
    private String pictures01;
    @Excel(name = "pictures02")
    private String pictures02;
}
