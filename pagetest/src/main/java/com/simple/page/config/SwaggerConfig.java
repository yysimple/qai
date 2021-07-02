package com.simple.page.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.sql.Date;
import java.time.LocalDateTime;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: swagger配置
 *
 * @author: WuChengXing
 * @create: 2021-07-03 00:09
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createApis() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.simple.page.controller"))
                .paths(PathSelectors.any())
                .build()
                .directModelSubstitute(LocalDateTime.class, Date.class);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("测试接口")
                .description("接口测试平台")
                .contact(new Contact("wcx", "", "1449697757@qq.com"))
                .version("v1.0")
                .build();
    }
}
