package com.simple.page.domain;

import lombok.Data;

/**
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2022-01-10 14:45
 **/
@Data
public class Course {
    private Long cid;
    private String cname;
    private Long userId;
    private String cstatus;
}
