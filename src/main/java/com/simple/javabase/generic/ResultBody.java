package com.simple.javabase.generic;

import lombok.Data;

/**
 * @author WuChengXing
 * @date 2021/7/20
 */
@Data
public class ResultBody<D> {

    private Integer code;

    private String msg;

    private D data;

    public ResultBody() {
    }

    public ResultBody(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultBody(Integer code, String msg, D data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

}
