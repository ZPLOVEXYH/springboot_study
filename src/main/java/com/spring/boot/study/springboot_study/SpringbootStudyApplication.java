package com.spring.boot.study.springboot_study;

import com.spring.boot.study.springboot_study.filter.RequestResponseLoggingFilter;
import com.spring.boot.study.springboot_study.filter.TransactionFilter;
import com.spring.boot.study.springboot_study.servlet.HelloWorldServlet;
import com.spring.boot.study.springboot_study.servlet.SpringHelloServletRegistrationBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

import java.util.Arrays;
import java.util.List;

/**
 * @EnableJpaRepositories扫描指定的包以获取存储库
 * @EntityScan可以获取我们的JPA实体
 *
 */
//@EnableJpaRepositories("com.spring.boot.study.springboot_study.repository")
//@EntityScan("com.spring.boot.study.springboot_study.bean")
@SpringBootApplication
@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
public class SpringbootStudyApplication extends RepositoryRestConfigurerAdapter {

    public static void main(String[] args) {
//        System.setProperty("server.servlet.context-path", "/baeldung");
        SpringApplication.run(SpringbootStudyApplication.class, args);
    }

    /**
     *  方法一：beforeCreateEvent是因为我们想要将新对象插入到我们的数据库中。但由于我们想要在请求中验证对象，我们需要首先定义验证器。
     */
//    @Bean
//    public BookValidator beforeCreateBookValidator(){
//        return new BookValidator();
//    }

//    @Override
//    public void configureValidatingRepositoryEventListener(ValidatingRepositoryEventListener v) {
//        v.addValidator("beforeCreate", new BookValidator());
//    }

    @Bean
    public SpringHelloServletRegistrationBean servletRegistrationBean() {
        SpringHelloServletRegistrationBean springHelloServletRegistrationBean = new SpringHelloServletRegistrationBean(new HelloWorldServlet(), "/springHelloWorld/*");
        springHelloServletRegistrationBean.setLoadOnStartup(1);
        springHelloServletRegistrationBean.addInitParameter("message", "SpringHelloWorldServlet special message");

        return springHelloServletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean<TransactionFilter> transactionFilter(){
        String[] urlStr = new String[]{"/api/books/*" ,"/simple/*"};
        FilterRegistrationBean<TransactionFilter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setFilter(new TransactionFilter());
        filterFilterRegistrationBean.addUrlPatterns(urlStr);

        return filterFilterRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean<RequestResponseLoggingFilter> requestResponseLoggingFilter(){
        FilterRegistrationBean<RequestResponseLoggingFilter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setFilter(new RequestResponseLoggingFilter());
        filterFilterRegistrationBean.addUrlPatterns("/simple/*");

        return filterFilterRegistrationBean;
    }
}
