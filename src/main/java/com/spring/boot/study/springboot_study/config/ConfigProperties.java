package com.spring.boot.study.springboot_study.config;

import com.spring.boot.study.springboot_study.bean.Credentials;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;
import java.util.Map;

@Setter
@Getter
@ToString
@Configuration
@ConfigurationProperties(prefix = "mail")
@PropertySource(value = "classpath:application-dev.properties")
public class ConfigProperties {

    private String hostname;
    private int port;
    private String from;
    private List<String> defaultRecipients;
    private Map<String, String> additionalHeaders;
    private Credentials credentials;
}
