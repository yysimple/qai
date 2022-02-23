package com.simple.ocr.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.simple.ocr.entity.UserInfo;
import com.simple.ocr.mapper.UserInfoMapper;
import com.simple.ocr.service.UserInfoService;
import org.springframework.stereotype.Service;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2022-02-23 15:05
 **/
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo>
        implements UserInfoService {
}
