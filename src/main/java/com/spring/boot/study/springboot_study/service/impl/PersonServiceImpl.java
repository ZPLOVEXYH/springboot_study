package com.spring.boot.study.springboot_study.service.impl;

import com.spring.boot.study.springboot_study.bean.Person;
import com.spring.boot.study.springboot_study.service.PersonService;
import org.springframework.stereotype.Service;


@Service
public class PersonServiceImpl implements PersonService {

    @Override
    public Person findPersonByUsername(String username) {
        Person person = new Person();
        person.setUsername(username);
        person.setPassword("111111");

        return person;
    }
}
