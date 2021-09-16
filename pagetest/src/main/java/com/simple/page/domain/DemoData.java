package com.simple.page.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 测试导入的表
 * @TableName demo_data
 */
@TableName(value ="demo_data")
@Data
public class DemoData implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 字符串标题
     */
    private String string;

    /**
     * 日期标题
     */
    private Date date;

    /**
     * 
     */
    private Double doubleData;

    /**
     * 图片路径1
     */
    private String imgUrl1;

    /**
     * 图片路径2
     */
    private String imgUrl2;

    /**
     * 忽略的字段
     */
    private String ignore;

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
        DemoData other = (DemoData) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getString() == null ? other.getString() == null : this.getString().equals(other.getString()))
            && (this.getDate() == null ? other.getDate() == null : this.getDate().equals(other.getDate()))
            && (this.getDoubleData() == null ? other.getDoubleData() == null : this.getDoubleData().equals(other.getDoubleData()))
            && (this.getImgUrl1() == null ? other.getImgUrl1() == null : this.getImgUrl1().equals(other.getImgUrl1()))
            && (this.getImgUrl2() == null ? other.getImgUrl2() == null : this.getImgUrl2().equals(other.getImgUrl2()))
            && (this.getIgnore() == null ? other.getIgnore() == null : this.getIgnore().equals(other.getIgnore()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getString() == null) ? 0 : getString().hashCode());
        result = prime * result + ((getDate() == null) ? 0 : getDate().hashCode());
        result = prime * result + ((getDoubleData() == null) ? 0 : getDoubleData().hashCode());
        result = prime * result + ((getImgUrl1() == null) ? 0 : getImgUrl1().hashCode());
        result = prime * result + ((getImgUrl2() == null) ? 0 : getImgUrl2().hashCode());
        result = prime * result + ((getIgnore() == null) ? 0 : getIgnore().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", string=").append(string);
        sb.append(", date=").append(date);
        sb.append(", doubleData=").append(doubleData);
        sb.append(", imgUrl1=").append(imgUrl1);
        sb.append(", imgUrl2=").append(imgUrl2);
        sb.append(", ignore=").append(ignore);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}