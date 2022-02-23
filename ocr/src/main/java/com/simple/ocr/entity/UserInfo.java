package com.simple.ocr.entity;

import java.util.Date;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2022-02-23 14:49
 **/
public class UserInfo {
    private Long Id;

    private String username;

    private Integer age;

    private Date createTime;

    private Date updateTime;

    public UserInfo() {
    }

    public UserInfo(Long id, String name, Integer age, Date createTime) {
        Id = id;
        this.username = name;
        this.age = age;
        this.createTime = createTime;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return username;
    }

    public void setName(String name) {
        this.username = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
