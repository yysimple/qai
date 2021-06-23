package com.simple.page.controller;

import com.simple.page.domain.Student;
import com.simple.page.service.StudentService;
import com.simple.page.util.SimpleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chengxing.wu@xiaobao100.com
 * @date 2021/6/23 14:05
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/save")
    public SimpleResponse<Boolean> save(@RequestBody Student student) {
        return new SimpleResponse<>(studentService.save(student));
    }

}
