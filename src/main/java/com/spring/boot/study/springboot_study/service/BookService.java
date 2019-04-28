package com.spring.boot.study.springboot_study.service;

import com.spring.boot.study.springboot_study.bean.Book;

import java.util.List;

public interface BookService {

    List<Book> queryBookByTitle(String title);
}
