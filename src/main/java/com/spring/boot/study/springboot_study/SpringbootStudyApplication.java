package com.spring.boot.study.springboot_study;

import com.spring.boot.study.springboot_study.autoconfiguration.Greeter;
import com.spring.boot.study.springboot_study.filter.JwtFilter;
import com.spring.boot.study.springboot_study.filter.RequestResponseLoggingFilter;
import com.spring.boot.study.springboot_study.filter.TransactionFilter;
import com.spring.boot.study.springboot_study.servlet.HelloWorldServlet;
import com.spring.boot.study.springboot_study.servlet.SpringHelloServletRegistrationBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

/**
 * @EnableJpaRepositories扫描指定的包以获取存储库
 * @EntityScan可以获取我们的JPA实体
 *
 */
@Slf4j
@SpringBootApplication
@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
public class SpringbootStudyApplication {

    private static ApplicationContext applicationContext;

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(SpringbootStudyApplication.class, args);
//        String[] strs = applicationContext.getBeanDefinitionNames();
//        for(String str : strs) {
//            log.info("beanName，{}", str);
//        }
//        System.exit(SpringApplication.exit(SpringApplication.run(SpringbootStudyApplication.class, args)));
    }

//    @Bean
//    public SpringHelloServletRegistrationBean servletRegistrationBean() {
//        SpringHelloServletRegistrationBean springHelloServletRegistrationBean = new SpringHelloServletRegistrationBean(new HelloWorldServlet(), "/springHelloWorld/*");
//        springHelloServletRegistrationBean.setLoadOnStartup(1);
//        springHelloServletRegistrationBean.addInitParameter("message", "SpringHelloWorldServlet special message");
//
//        return springHelloServletRegistrationBean;
//    }
//
//    @Bean
//    public FilterRegistrationBean<TransactionFilter> transactionFilter(){
//        String[] urlStr = new String[]{"/api/books/*" ,"/simple/*"};
//        FilterRegistrationBean<TransactionFilter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
//        filterFilterRegistrationBean.setFilter(new TransactionFilter());
//        filterFilterRegistrationBean.addUrlPatterns(urlStr);
//
//        return filterFilterRegistrationBean;
//    }
//
//    @Bean
//    public FilterRegistrationBean<JwtFilter> jwtFilterFilterRegistrationBean(){
//        FilterRegistrationBean<JwtFilter> jwtFilterFilterRegistrationBean = new FilterRegistrationBean<>();
//        jwtFilterFilterRegistrationBean.setFilter(new JwtFilter());
//        jwtFilterFilterRegistrationBean.addUrlPatterns("/*");
//
//        return jwtFilterFilterRegistrationBean;
//    }
//
//    @Bean
//    public FilterRegistrationBean<RequestResponseLoggingFilter> requestResponseLoggingFilter(){
//        FilterRegistrationBean<RequestResponseLoggingFilter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
//        filterFilterRegistrationBean.setFilter(new RequestResponseLoggingFilter());
//        filterFilterRegistrationBean.addUrlPatterns("/simple/*");
//
//        return filterFilterRegistrationBean;
//    }
//
////    @Override
////    public int getExitCode() {
////        return 42;
////    }
//
//    @Autowired
//    private Greeter greeter;
//
//    @Override
//    public void run(String... args) throws Exception {
//        String message = greeter.greet();
//
//        log.info("输出的内容为：{}", message);
//    }
}
