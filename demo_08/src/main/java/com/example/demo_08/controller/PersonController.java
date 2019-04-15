package com.example.demo_08.controller;

import com.example.demo_08.bean.PersonBean;
import com.example.demo_08.entity.PersonEntity;
import com.example.demo_08.service.impl.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import com.example.demo_08.service.IPersonService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Auther: zhangliang
 * @Date: 2019/4/12 16:12
 * @Description:
 */
@RestController
@RequestMapping("/person")
public class PersonController {

    //当使用@Autowired的时候，会优先匹配类型，如果存在多个实现类，会按照bean的名称进行匹配
    //也可以配合@Qualifier("personService")来使用，byName装配
    @Autowired
    private IPersonService personService;

    //@Resource的作用和@Autowired的作用一样
    //当使用@Resource的时候，通过name和type属性来进行查询
    //当什么都不写的时候，默认通过名称来匹配
    //当指定了name，按照name来匹配
    //当指定了type，按照type来匹配
    //当同时指定了name和type，则按照name和type同时匹配
//    @Resource
//    private  IPersonService personService;

    @GetMapping("/{id}")
    public PersonBean findById(@PathVariable("id") Long id) {
        return personService.findById(id);
    }

}
