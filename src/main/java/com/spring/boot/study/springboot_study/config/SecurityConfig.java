package com.spring.boot.study.springboot_study.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 引入jar包
 * <dependency>
 *     <groupId>org.springframework.boot</groupId>
 *     <artifactId>spring-boot-starter-security</artifactId>
 * </dependency>
 * 如果我们在类路径上有启动器，我们通常应该
 * 通过扩展WebSecurityConfigurerAdapter类来定义我们自己的自定义安全配置：
 */
@Slf4j
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        log.info("进入安全配置", http);
        http.authorizeRequests()
                .anyRequest()
                .permitAll()
                .and().csrf().disable();
    }
}
