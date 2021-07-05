package com.simple.page.controller;

import com.simple.page.domain.Student;
import com.simple.page.ibo.StudentIbo;
import com.simple.page.service.StudentService;
import com.simple.page.util.SimpleResponse;
import com.simple.pagination.util.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author chengxing.wu@xiaobao100.com
 * @date 2021/6/23 14:05
 */
@RestController
@RequestMapping("/student")
@Api(tags = "学生接口")
@CrossOrigin
public class StudentController {

    @Autowired
    private StudentService studentService;

    @ApiOperation(value = "保存操作")
    @PostMapping("/save")
    public SimpleResponse<Boolean> save(@RequestBody Student student) {
        return new SimpleResponse<>(studentService.save(student));
    }

    @ApiOperation("分页查询")
    @PostMapping("/list")
    public SimpleResponse<Page<Student>> listStudent(@RequestBody StudentIbo studentIbo) {
        Page<Student> studentPage = studentService.listStudent(studentIbo);
        return new SimpleResponse<>(studentPage);
    }

    @GetMapping("/hello")
    public SimpleResponse<String> hello() {
        return new SimpleResponse<>("test");
    }

    @ApiOperation("更新操作")
    @PostMapping("/update")
    public SimpleResponse<Boolean> update(@RequestBody Student student) {
        return new SimpleResponse<>(studentService.updateById(student));
    }

    @ApiOperation("通过id获取学生信息")
    @GetMapping("/getStudentById")
    public SimpleResponse<Student> getStudentById(Long studentId) {
        return new SimpleResponse<>(studentService.getById(studentId));
    }

    @ApiOperation("获取学生信息，id放在 / 后面")
    @GetMapping("/getStudentByPathId/{id}")
    public SimpleResponse<Student> getStudentByPathId(@PathVariable("id") Long studentId) {
        return new SimpleResponse<>(studentService.getById(studentId));
    }



}
