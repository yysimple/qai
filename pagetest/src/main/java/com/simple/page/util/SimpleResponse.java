package com.simple.page.util;

import static java.lang.Boolean.FALSE;

/**
 * @author chengxing.wu@xiaobao100.com
 * @date 2021/6/23 16:07
 */
public class SimpleResponse<T> extends AirResponse<T> {
    public SimpleResponse(T data) {
        this.setData(data);
        this.errorCode = 0;
        this.errorMessage = "成功";
    }


    public SimpleResponse() {
        this.errorCode = 0;
        this.errorMessage = "成功";
    }

    public SimpleResponse(Integer code, String msg) {
        this.errorCode = code;
        this.errorMessage = msg;
    }

    public static <T> SimpleResponse<T> error(Integer code, String msg) {
        SimpleResponse<T> response = new SimpleResponse<T>();
        response.returnCode(code);
        response.returnMsg(msg);
        response.setStatus(FALSE);
        return response;
    }

    public SimpleResponse<T> returnCode(Integer returnCode) {
        this.errorCode = returnCode;
        return this;
    }

    public SimpleResponse<T> returnMsg(String returnMsg) {
        this.errorMessage = returnMsg;
        return this;
    }
}
