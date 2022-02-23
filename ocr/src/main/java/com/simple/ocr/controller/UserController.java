package com.simple.ocr.controller;

import com.simple.ocr.entity.UserInfo;
import com.simple.ocr.service.UserInfoService;
import com.simple.ocr.util.SimpleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * 项目: question-study-improve
 * <p>
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2022-02-23 14:46
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserInfoService userInfoService;

    @GetMapping("/listUser")
    public SimpleResponse<List<UserInfo>> listUser() {
        List<UserInfo> list = userInfoService.list();
        return new SimpleResponse<>(list);
    }

    @GetMapping("/getUserInfo")
    public SimpleResponse<UserInfo> getUserInfo(Long id) {
        UserInfo byId = userInfoService.getById(id);
        return new SimpleResponse<>(byId);
    }
}

