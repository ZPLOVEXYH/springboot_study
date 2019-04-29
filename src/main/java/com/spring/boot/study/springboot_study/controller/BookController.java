package com.spring.boot.study.springboot_study.controller;

import com.spring.boot.study.springboot_study.bean.Book;
import com.spring.boot.study.springboot_study.config.ConfigProperties;
import com.spring.boot.study.springboot_study.config.MailPropertiesConfig;
import com.spring.boot.study.springboot_study.exception.BookNotFoundException;
import com.spring.boot.study.springboot_study.repository.BookRepository;
import com.spring.boot.study.springboot_study.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    BookService bookService;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    MailPropertiesConfig mailPropertiesConfig;

    @Autowired
    ConfigProperties configProperties;

    /**
     * 查询所有的数据
     * @return
     */
    public Iterable findAll() {
        return bookRepository.findAll();
    }

    @GetMapping("/title/{bookTitle}")
    public List findByTitle(@PathVariable(name = "bookTitle") String bookTitle) {
        return bookRepository.findByTitle(bookTitle);
    }

    @GetMapping("/{id}")
    public Book findOne(@PathVariable(name = "id") long id) {
        log.info("configProperties======, {}", configProperties);
        return bookRepository.findById(id)
                .orElseThrow(BookNotFoundException::new);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book create(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        bookRepository.findById(id)
                .orElseThrow(BookNotFoundException::new);
        bookRepository.deleteById(id);
    }

    @GetMapping("/queryByAuthor/{title}")
    public List<Book> queryByAuthor(@PathVariable("title") String title){
        return bookRepository.findByAuthor(title);
    }
}
