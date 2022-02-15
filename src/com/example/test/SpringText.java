package com.example.test;

import com.example.service.BookService;
import com.example.web.WebUtils;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringText {
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    @Test
    public void test1(){
        BookService bean = WebUtils.getBean(BookService.class);
        System.out.println(bean);
    }
}
