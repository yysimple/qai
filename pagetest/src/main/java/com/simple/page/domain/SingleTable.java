package com.simple.page.domain;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * (SingleTable)表实体类
 *
 * @author makejava
 * @since 2022-01-06 17:41:54
 */
@SuppressWarnings("serial")
public class SingleTable extends Model<SingleTable> {

    private Integer id;

    private String key1;

    private Integer key2;

    private String key3;

    private String keyPart1;

    private String keyPart2;

    private String keyPart3;

    private String commonField;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKey1() {
        return key1;
    }

    public void setKey1(String key1) {
        this.key1 = key1;
    }

    public Integer getKey2() {
        return key2;
    }

    public void setKey2(Integer key2) {
        this.key2 = key2;
    }

    public String getKey3() {
        return key3;
    }

    public void setKey3(String key3) {
        this.key3 = key3;
    }

    public String getKeyPart1() {
        return keyPart1;
    }

    public void setKeyPart1(String keyPart1) {
        this.keyPart1 = keyPart1;
    }

    public String getKeyPart2() {
        return keyPart2;
    }

    public void setKeyPart2(String keyPart2) {
        this.keyPart2 = keyPart2;
    }

    public String getKeyPart3() {
        return keyPart3;
    }

    public void setKeyPart3(String keyPart3) {
        this.keyPart3 = keyPart3;
    }

    public String getCommonField() {
        return commonField;
    }

    public void setCommonField(String commonField) {
        this.commonField = commonField;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}

