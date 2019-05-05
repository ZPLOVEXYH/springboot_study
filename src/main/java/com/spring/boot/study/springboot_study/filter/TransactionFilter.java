package com.spring.boot.study.springboot_study.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Slf4j
@Order(1)
public class TransactionFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        log.info("Starting a transaction for req : {}", httpServletRequest.getRequestURI());

        filterChain.doFilter(servletRequest, servletResponse);

        log.info("Committing a transaction for req : {}", httpServletRequest.getRequestURI());
    }

}
