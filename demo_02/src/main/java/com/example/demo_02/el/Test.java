package com.example.demo_02.el;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class Test {

    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ElConfig.class);
        ElConfig elConfig = context.getBean(ElConfig.class);
        elConfig.outputResource();
        context.close();
    }

}
