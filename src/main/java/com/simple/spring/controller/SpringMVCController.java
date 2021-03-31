package com.simple.spring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 项目: mianshi-test
 * <p>
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-03-29 08:49
 **/
@RestController
@RequestMapping("/test")
public class SpringMVCController {
    ThreadLocal<String> threadLocal = new ThreadLocal<>();
}
