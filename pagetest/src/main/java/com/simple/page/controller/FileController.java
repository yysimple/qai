package com.simple.page.controller;

import com.alibaba.fastjson.JSONArray;
import com.simple.io.poi.ExcelUtil;
import com.simple.page.domain.StudentTest;
import com.simple.page.util.ExcelUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.zip.ZipOutputStream;

/**
 * @author WuChengXing
 * @date 2021/9/6
 */
@RestController
@RequestMapping("/file")
public class FileController {

    @GetMapping("/down")
    public void exprotZip(HttpServletResponse response) throws IOException {
        ServletOutputStream sos = response.getOutputStream();
        ZipOutputStream zipOutputStream = new ZipOutputStream(sos);
        String zipname = "test.zip";
        String dir = "test01";
        response.reset();
        response.setContentType("application/x-download");
        response.setHeader("Content-Disposition", "attachment;filename=" + new String((zipname).getBytes(), StandardCharsets.UTF_8));
        int count = 10;
        JSONArray ja = new JSONArray();
        for (int i = 1; i < count; i++) {
            StudentTest s = new StudentTest();
            s.setId(i);
            s.setName("POI" + i);
            s.setAge(i);
            s.setBirthday(new Date());
            s.setHeight(i);
            s.setWeight(i);
            s.setSex(i / 2 == 0 ? false : true);
            s.setPictures01("pictures01");
            s.setPictures02("pictures02");
            ja.add(s);
        }
        Map<String, String> headMap = new LinkedHashMap<>();
        headMap.put("name", "姓名");
        headMap.put("age", "年龄");
        headMap.put("birthday", "生日");
        headMap.put("height", "身高");
        headMap.put("weight", "体重");
        headMap.put("sex", "性别");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        for (int i = 1; i < 6; i++) {
            StudentTest studentTest = (StudentTest) ja.get(i);
            ExcelUtils.exportExcelX("title" + i, headMap, ja, null, 0, baos);
            ExcelUtils.compressFileToZipStream(zipOutputStream, baos, dir + studentTest.getId() + "/test" + i + ".xlsx");
            try {
                baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        ExcelUtils.exportExcelX("title", headMap, ja, null, 0, baos);
        ExcelUtils.compressFileToZipStream(zipOutputStream, baos, dir + "/total" + ".xlsx");
        zipOutputStream.flush();
        zipOutputStream.close();
        sos.close();
        System.out.println("导出zip完成");
    }

    @GetMapping("/export")
    public void export(HttpServletResponse response) {
        List<StudentTest> studentTests = new ArrayList<>();
        StudentTest studentTest1 = new StudentTest();
        studentTest1.setId(1);
        studentTest1.setName("1");
        studentTest1.setPictures01("1-1.png");
        studentTest1.setPictures02("1-2.png");

        StudentTest studentTest2 = new StudentTest();
        studentTest2.setId(2);
        studentTest2.setName("2");
        studentTest2.setPictures01("2-1.png");
        studentTest2.setPictures02("2-2.png");

        studentTests.add(studentTest1);
        studentTests.add(studentTest2);
        ExcelUtil<StudentTest> excelUtil = new ExcelUtil<>(StudentTest.class);
        excelUtil.exportExcel(studentTests, "studentTests");
    }
}
