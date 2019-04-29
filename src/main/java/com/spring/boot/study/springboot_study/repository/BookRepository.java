package com.spring.boot.study.springboot_study.repository;

import com.spring.boot.study.springboot_study.bean.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

    /**
     * 通过书的标题查询得到书名信息
     * @param title
     * @return
     */
    List<Book> findByTitle(String title);

    @Query("FROM Book b where b.author = :author")
    List<Book> findByAuthor(@Param("author") String author);
}
