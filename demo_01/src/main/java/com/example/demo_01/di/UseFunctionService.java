package com.example.demo_01.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UseFunctionService {

    @Autowired
    private FunctionService functionService;

    public String sayHello(String str){
        return functionService.sayHello(str);
    }

}
