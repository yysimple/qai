package com.simple.page.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 班级
 * @TableName classroom
 */
@TableName(value ="classroom")
@Data
public class Classroom implements Serializable {
    /**
     * 班级id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 
     */
    private String classroomName;

    /**
     * 班级描述
     */
    private String classroomDescribe;

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
        Classroom other = (Classroom) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getClassroomName() == null ? other.getClassroomName() == null : this.getClassroomName().equals(other.getClassroomName()))
            && (this.getClassroomDescribe() == null ? other.getClassroomDescribe() == null : this.getClassroomDescribe().equals(other.getClassroomDescribe()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getClassroomName() == null) ? 0 : getClassroomName().hashCode());
        result = prime * result + ((getClassroomDescribe() == null) ? 0 : getClassroomDescribe().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", classroomName=").append(classroomName);
        sb.append(", desc=").append(classroomDescribe);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}