package com.spring.boot.study.springboot_study.config;

import com.spring.boot.study.springboot_study.resolver.ListArgumentResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private ListArgumentResolver listArgumentResolver;

    /**
     * 配置ArgumentResolvers
     * 实现采用业务逻辑，向controllor 方法中注入参数
     * @param argumentResolvers
     */
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(listArgumentResolver);
    }
}
