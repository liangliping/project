package com.example.demo;

import springfox.documentation.service.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * @author hexiaohui
 */
@Configuration
@EnableSwagger2
public class Swagger2 {
    @Bean
    public Docket createRestApi() {

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //需要扫描controller的路径  配置错误的话 是扫描不到的
                .apis(RequestHandlerSelectors.basePackage("com.example.demo.controller"))
                .paths(PathSelectors.any())
                .build();

    }

    private ApiInfo apiInfo() {

        return new ApiInfoBuilder()
                .title("跟着分享牛学习Springboot源码分析系列课程")
                .description("更多Spring Boot相关文章请关注分享牛的博客")
                .termsOfServiceUrl("http://www.shareniu.com/")
                .contact("牛牛")
                .license("Copyright 2017-2018 分享牛")
                .version("1.0")
                .build();

    }
}