package com.simple.page.mapper;

import com.simple.page.domain.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.simple.page.ibo.StudentIbo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Entity com.simple.page.domain.Student
 */
@Mapper
public interface StudentMapper extends BaseMapper<Student> {

    List<Student> listStudent(StudentIbo studentIbo);

}




