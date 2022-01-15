package com.simple.jvm.two;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2022-01-15 16:30
 **/
@Data
public class Ticket {

    private Long id;

    private String scenicName;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private Integer orderType;

    private String desc;

    public static Ticket build(String desc, String scenicName, Integer orderType) {
        Ticket ticket = new Ticket();
        ticket.setStartTime(LocalDateTime.now().minusHours(2));
        ticket.setEndTime(LocalDateTime.now());
        ticket.setScenicName(scenicName);
        ticket.setOrderType(orderType);
        ticket.setDesc(desc);
        return ticket;
    }
}
