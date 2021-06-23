package com.simple.page.controller;

import com.simple.page.domain.Classroom;
import com.simple.page.domain.Student;
import com.simple.page.service.ClassroomService;
import com.simple.page.service.StudentService;
import com.simple.util.SimpleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chengxing.wu@xiaobao100.com
 * @date 2021/6/23 14:12
 */
@RestController
@RequestMapping("/classroom")
public class ClassroomController {
    @Autowired
    private ClassroomService classroomService;

    @PostMapping("/save")
    public SimpleResponse<Boolean> save(@RequestBody Classroom classroom) {
        return new SimpleResponse<>(classroomService.save(classroom));
    }

}
