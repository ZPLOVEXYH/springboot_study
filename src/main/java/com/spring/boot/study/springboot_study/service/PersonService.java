package com.spring.boot.study.springboot_study.service;

import com.spring.boot.study.springboot_study.bean.Person;

public interface PersonService {

    Person findPersonByUsername(String username);
}
