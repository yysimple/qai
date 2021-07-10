package com.simple.designpatterns.pattern23.behavioral.intermediary.two.impl;

import com.simple.designpatterns.pattern23.behavioral.intermediary.two.Renting;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 租客
 *
 * @author: WuChengXing
 * @create: 2021-07-11 01:15
 **/
public class Tenant {
    private String name;

    private Boolean renting;

    public Tenant(String name) {
        this.name = name;
    }

    public Tenant(String name, Boolean renting) {
        this.name = name;
        this.renting = renting;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getRenting() {
        return renting;
    }

    public void setRenting(Boolean renting) {
        this.renting = renting;
    }
}
