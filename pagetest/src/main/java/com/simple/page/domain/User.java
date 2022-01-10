package com.simple.page.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2022-01-10 14:49
 **/
@Data
@TableName(value = "t_user")
public class User {
    private Long userId;
    private String username;
    private String ustatus;
}
