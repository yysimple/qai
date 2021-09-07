package com.simple.page.domain.easyexcel;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author WuChengXing
 * @date 2021/9/7
 */
@Data
public class DemoData {
    @ExcelProperty("字符串标题")
    private String string;
    @ExcelProperty("日期标题")
    private Date date;
    @ExcelProperty("数字标题")
    private Double doubleData;
    @ExcelProperty("图片路径1")
    private String imgUrl1;
    @ExcelProperty("图片路径2")
    private String imgUrl2;
    /**
     * 忽略这个字段
     */
    @ExcelIgnore
    private String ignore;
}
