package com.spring.boot.study.springboot_study.validator;


import com.spring.boot.study.springboot_study.bean.Book;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class BookValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return Book.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Book book = (Book) o;
        if(checkInputString(book.getTitle())){
            errors.rejectValue("title", "title.empty");
        }

        if(checkInputString(book.getAuthor())){
            errors.rejectValue("author", "author.empty");
        }
    }

    /**
     * 判断输入的字符串是否为空
     * @param input
     * @return
     */
    private boolean checkInputString(String input) {
        return (input == null || input.trim().length() == 0);
    }
}
