package com.spring.boot.study.springboot_study.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Credentials {

    private String username;
    private String password;
    private String authMethod;

}
