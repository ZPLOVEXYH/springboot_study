package com.spring.boot.study.springboot_study.resolver;

import com.spring.boot.study.springboot_study.annotation.ListAttribute;
import com.spring.boot.study.springboot_study.bean.User;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Service
public class ListArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.getParameterAnnotation(ListAttribute.class) != null;
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        List<User> users = new ArrayList<>();
        HttpServletRequest request = nativeWebRequest.getNativeRequest(HttpServletRequest.class);

        nativeWebRequest.getParameterNames();
        String[] names = request.getParameterValues("name");
        String[] ages = request.getParameterValues("age");



        for(int i = 0; i< names.length; i++){
            User user = new User();

            String name = names[i];
            String age = ages[i];
            BeanWrapper beanWrapper = PropertyAccessorFactory.forBeanPropertyAccess(user);
            beanWrapper.setPropertyValue("name", name);
            beanWrapper.setPropertyValue("age", age);

            users.add(user);
        }

        return users;
    }
}
