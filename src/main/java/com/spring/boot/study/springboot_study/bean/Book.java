package com.spring.boot.study.springboot_study.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@ToString
@Getter
@Setter
@Entity
public class Book {

    @Id
    private long id;

    @Column
    private String title;

    @Column
    private String author;
}
