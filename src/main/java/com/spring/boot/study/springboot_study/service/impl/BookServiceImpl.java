package com.spring.boot.study.springboot_study.service.impl;

import com.spring.boot.study.springboot_study.bean.Book;
import com.spring.boot.study.springboot_study.repository.BookRepository;
import com.spring.boot.study.springboot_study.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Book> queryBookByTitle(String title) {
        return bookRepository.findByTitle(title);
    }
}
