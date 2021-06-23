package com.simple.page.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.simple.page.domain.Student;
import com.simple.page.ibo.StudentIbo;
import com.simple.page.service.StudentService;
import com.simple.page.mapper.StudentMapper;
import com.simple.pagination.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student>
        implements StudentService {

    @Resource
    StudentMapper studentMapper;

    @Override
    public Page<Student> listStudent(StudentIbo studentIbo) {
        List<Student> students = studentMapper.listStudent(studentIbo);
        return Page.of(students);
    }
}




