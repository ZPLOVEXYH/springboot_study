package com.spring.boot.study.springboot_study.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/simple")
public class SimpleController {

    @Value("${spring.application.name}")
    String appName;

    @RequestMapping("/home")
    public String pageHome(Model model){
        model.addAttribute("appName", appName);

        return "error";
    }
}
