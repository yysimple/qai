package com.simple.page.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 学生表
 * @TableName student
 */
@TableName(value ="student")
@Data
public class Student implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 学生姓名
     */
    private String studentName;

    /**
     * 学生年龄
     */
    private Integer age;

    /**
     * 学生描述
     */
    private String studentDescribe;

    /**
     * 所属班级
     */
    private Long classroomId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Student other = (Student) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getStudentName() == null ? other.getStudentName() == null : this.getStudentName().equals(other.getStudentName()))
            && (this.getAge() == null ? other.getAge() == null : this.getAge().equals(other.getAge()))
            && (this.getStudentDescribe() == null ? other.getStudentDescribe() == null : this.getStudentDescribe().equals(other.getStudentDescribe()))
            && (this.getClassroomId() == null ? other.getClassroomId() == null : this.getClassroomId().equals(other.getClassroomId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getStudentName() == null) ? 0 : getStudentName().hashCode());
        result = prime * result + ((getAge() == null) ? 0 : getAge().hashCode());
        result = prime * result + ((getStudentDescribe() == null) ? 0 : getStudentDescribe().hashCode());
        result = prime * result + ((getClassroomId() == null) ? 0 : getClassroomId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(studentName);
        sb.append(", age=").append(age);
        sb.append(", desc=").append(studentDescribe);
        sb.append(", classroomId=").append(classroomId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}