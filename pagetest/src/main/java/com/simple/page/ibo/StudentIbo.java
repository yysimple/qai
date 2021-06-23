package com.simple.page.ibo;

/**
 * @author chengxing.wu@xiaobao100.com
 * @date 2021/6/23 17:44
 */
public class StudentIbo extends BasePageIbo {
    private Integer age;

    private String studentName;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
