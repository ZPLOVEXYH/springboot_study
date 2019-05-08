package com.spring.boot.study.springboot_study.controller;

import com.spring.boot.study.springboot_study.bean.ReqPerson;
import com.spring.boot.study.springboot_study.bean.Role;
import com.spring.boot.study.springboot_study.service.PersonService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program: users
 * @author: 李泰郎
 * @create: 2018-02-27 19:28
 **/
@RestController
public class PersonController {

    @Autowired
    private PersonService personService;


    /**
     * User register with whose username and password
     * @param reqPerson
     * @return Success message
     * @throws ServletException
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@RequestBody() ReqPerson reqPerson) throws ServletException {
        // Check if username and password is null
        if (reqPerson.getUsername() == "" || reqPerson.getUsername() == null
                || reqPerson.getPassword() == "" || reqPerson.getPassword() == null)
            throw new ServletException("Username or Password invalid!");

        // Check if the username is used
        if(personService.findPersonByUsername(reqPerson.getUsername()) != null)
            throw new ServletException("Username is used!");

        // Give a default role : MEMBER
        List<Role> roles = new ArrayList<>();
        roles.add(Role.MEMBER);

        // Create a person in ignite
//        personService.save(new Person(reqPerson.getUsername(), reqPerson.getPassword(), roles));
        return "Register Success!";
    }

    /**
     * Check user`s login info, then create a jwt token returned to front end
     * @param reqPerson
     * @return jwt token
     * @throws ServletException
     */
    @PostMapping
    public String login(@RequestBody() ReqPerson reqPerson) throws ServletException {
        // Check if username and password is null
        if (reqPerson.getUsername() == "" || reqPerson.getUsername() == null
                || reqPerson.getPassword() == "" || reqPerson.getPassword() == null)
            throw new ServletException("Please fill in username and password");

        // Check if the username is used
        if(personService.findPersonByUsername(reqPerson.getUsername()) == null
                || !reqPerson.getPassword().equals(personService.findPersonByUsername(reqPerson.getUsername()).getPassword())){
            throw new ServletException("Please fill in username and password");
        }

        // Create Twt token
        String jwtToken = Jwts.builder().setSubject(reqPerson.getUsername()).claim("roles", "member").setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "secretkey").compact();

        return jwtToken;
    }
}