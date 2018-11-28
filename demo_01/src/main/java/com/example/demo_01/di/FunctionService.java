package com.example.demo_01.di;

import org.springframework.stereotype.Service;

@Service
public class FunctionService {

    public String sayHello(String str){
        return "hello " + str + " !";
    }

}
