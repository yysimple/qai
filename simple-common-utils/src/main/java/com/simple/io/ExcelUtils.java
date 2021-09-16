package com.simple.io;

import com.alibaba.excel.EasyExcel;
import com.simple.constant.FileConstants;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

/**
 * @author WuChengXing
 * @date 2021/9/15
 */
public class ExcelUtils {

    public static <T> void exportExcelToWeb(HttpServletResponse response, String sheetName, Class<T> clazz, List<T> data) {
        // 这里注意,请直接用浏览器或者用postman
        response.setContentType(FileConstants.SHEET_CONTENT_TYPE);
        response.setCharacterEncoding(FileConstants.CHARSET_UTF8);
        // 这里URLEncoder.encode可以防止中文乱码
        String fileName = null;
        try {
            fileName = URLEncoder.encode(sheetName, FileConstants.CHARSET_UTF8).replaceAll("\\+", "%20");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setHeader(FileConstants.HEADER_NAME, FileConstants.HEADER_VALUE + fileName + FileConstants.EXCEL_FILE_SUFFIX);
        try {
            EasyExcel.write(response.getOutputStream(), clazz).sheet(fileName).doWrite(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
