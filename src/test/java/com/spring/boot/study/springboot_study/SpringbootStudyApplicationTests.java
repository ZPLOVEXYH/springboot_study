package com.spring.boot.study.springboot_study;

import com.spring.boot.study.springboot_study.bean.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.ws.Response;
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SpringbootStudyApplicationTests {

    private final static String API_ROOT = "http://localhost:8081/api/books";

    private Book createRandomBook() {
        Book book = new Book();
        book.setTitle(new Random().toString());
        book.setAuthor(new Random().toString());

        return book;
    }
}
