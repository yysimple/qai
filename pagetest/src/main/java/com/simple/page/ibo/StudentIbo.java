package com.simple.page.ibo;

import com.simple.pagination.util.Pageable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author chengxing.wu@xiaobao100.com
 * @date 2021/6/23 17:44
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class StudentIbo extends Pageable {
    private Integer age;

    private String studentName;
}
