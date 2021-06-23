package com.simple.page.ibo;

import java.io.Serializable;

/**
 * @author chengxing.wu@xiaobao100.com
 * @date 2021/6/23 17:51
 */
public class BasePageIbo implements Serializable {

    private Integer pageIndex = 1;
    private Integer pageSize = 10;

    public BasePageIbo() {
    }

    public Integer getPageIndex() {
        return this.pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getOffset() {
        return (this.pageIndex - 1) * this.pageSize;
    }
}
