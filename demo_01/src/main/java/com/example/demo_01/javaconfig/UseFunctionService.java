package com.example.demo_01.javaconfig;

public class UseFunctionService {

    private FunctionService functionService;

    public void setFunctionService(FunctionService functionService) {
        this.functionService = functionService;
    }

    public String sayHello(String str){
        return functionService.sayHello(str);
    }
}
