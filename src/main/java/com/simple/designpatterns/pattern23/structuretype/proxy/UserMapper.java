package com.simple.designpatterns.pattern23.structuretype.proxy;

import com.simple.designpatterns.pattern23.structuretype.proxy.annotation.Select;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-06-27 12:54
 **/
public interface UserMapper {
    @Select("select user_name from user where user_id = #{userId}")
    String queryUserInfo(String userId);
}
