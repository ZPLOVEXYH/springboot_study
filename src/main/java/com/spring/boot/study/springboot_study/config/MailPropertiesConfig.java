package com.spring.boot.study.springboot_study.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Setter
@Getter
@ToString
@Configuration
@PropertySource(value = "classpath:application-dev.properties")
@ConfigurationProperties(prefix = "mail")
public class MailPropertiesConfig {
    private String hostname;
    private int port;
    private String from;
}
