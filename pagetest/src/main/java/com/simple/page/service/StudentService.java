package com.simple.page.service;

import com.simple.page.domain.Student;
import com.baomidou.mybatisplus.extension.service.IService;
import com.simple.page.ibo.StudentIbo;
import com.simple.pagination.util.Page;

import java.util.List;

/**
 *
 */
public interface StudentService extends IService<Student> {

     Page<Student> listStudent(StudentIbo studentIbo);

     List<Student> listStudents(StudentIbo studentIbo);
}
