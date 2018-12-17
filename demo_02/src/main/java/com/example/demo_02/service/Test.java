package com.example.demo_02.service;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        SingletonService s1 = context.getBean(SingletonService.class);
        SingletonService s2 = context.getBean(SingletonService.class);
        System.out.println(s1.equals(s2));

        PrototypeService s3 = context.getBean(PrototypeService.class);
        PrototypeService s4 = context.getBean(PrototypeService.class);
        System.out.println(s3.equals(s4));

        context.close();
    }

}
