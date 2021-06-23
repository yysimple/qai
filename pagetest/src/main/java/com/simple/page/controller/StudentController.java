package com.simple.page.controller;

import com.simple.page.domain.Student;
import com.simple.page.ibo.StudentIbo;
import com.simple.page.service.StudentService;
import com.simple.page.util.SimpleResponse;
import com.simple.pagination.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/list")
    public SimpleResponse<Page<Student>> listStudent(@RequestBody StudentIbo studentIbo) {
        Page<Student> studentPage = studentService.listStudent(studentIbo);
        return new SimpleResponse<>(studentPage);
    }

}
