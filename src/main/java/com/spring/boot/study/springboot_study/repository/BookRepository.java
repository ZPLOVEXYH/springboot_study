package com.spring.boot.study.springboot_study.repository;

import com.spring.boot.study.springboot_study.bean.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {

    /**
     * 通过书的标题查询得到书名信息
     * @param title
     * @return
     */
    List<Book> findByTitle(String title);
}
