package com.spring.boot.study.springboot_study.bean;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User {
    private String name;
    private int age;

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        sb.append("-");
        sb.append(age);

        return sb.toString();
    }
}
