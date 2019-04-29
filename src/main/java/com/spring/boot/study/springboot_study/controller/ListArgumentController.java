package com.spring.boot.study.springboot_study.controller;

import com.spring.boot.study.springboot_study.annotation.ListAttribute;
import com.spring.boot.study.springboot_study.bean.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ListArgumentController {

    @RequestMapping("/list")
    public String argumentResolver(@ListAttribute User user){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(user);
        stringBuilder.append("<br/>");

        return stringBuilder.toString();
    }
}
