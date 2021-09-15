package com.simple.constant;

/**
 * @author WuChengXing
 * @date 2021/9/15
 */
public class FileConstants {
    /**
     * 响应类型
     */
    public static final String SHEET_CONTENT_TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    public static final String ZIP_CONTENT_TYPE = "application/x-download";

    /**
     * 字符编码
     */
    public static final String CHARSET_UTF8 = "UTF-8";

    public static final String HEADER_NAME = "Content-disposition";

    public static final String HEADER_VALUE = "attachment;filename*=utf-8''";

    public static final String EXCEL_FILE_SUFFIX = ".xlsx";

    public static final String ZIP_FILE_SUFFIX = ".zip";

    public static final String OSS_PREFIX = "//";
}
