package com.simple.page.controller;

import com.simple.page.domain.Classroom;
import com.simple.page.service.ClassroomService;
import com.simple.page.util.SimpleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author chengxing.wu@xiaobao100.com
 * @date 2021/6/23 14:12
 */
@RestController
@RequestMapping("/classroom")
@CrossOrigin
public class ClassroomController {
    @Autowired
    private ClassroomService classroomService;

    @PostMapping("/save")
    public SimpleResponse<Boolean> save(@RequestBody Classroom classroom) {
        return new SimpleResponse<>(classroomService.save(classroom));
    }

    @GetMapping("/list")
    public SimpleResponse<List<Classroom>> list() {
        return new SimpleResponse<>(classroomService.list());
    }

}
