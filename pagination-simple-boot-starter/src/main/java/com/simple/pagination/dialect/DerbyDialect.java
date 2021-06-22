package com.simple.pagination.dialect;

import com.simple.pagination.util.PaginationParam;

/**
 * @author chengxing.wu@xiaobao100.com
 * @date 2021/6/21 18:03
 */
public class DerbyDialect extends AbstractDialect {
    @Override
    public String getPagingSql(String sql) {
        return sql + " OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
    }

    @Override
    public Object[] getPagingParams(PaginationParam param) {
        return new Object[]{
                param.getOffset(),
                param.getRows()};
    }
}
