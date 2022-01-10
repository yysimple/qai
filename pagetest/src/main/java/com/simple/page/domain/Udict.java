package com.simple.page.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2022-01-10 14:50
 **/

@Data
@TableName(value = "t_udict")
public class Udict {
    private Long dictid;
    private String ustatus;
    private String uvalue;
}
