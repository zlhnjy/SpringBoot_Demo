package com.example.demo_08.service;


import com.alibaba.fastjson.JSON;
import com.example.demo_08.entity.PersonEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Auther: zhangliang
 * @Date: 2019/4/12 19:31
 * @Description:
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class IPersonServiceTest {

    @Autowired
    private IPersonService personService;

    @Test
    public void save() {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setName("zhangsan");
        personEntity.setAge(10);
        personEntity = personService.save(personEntity);
        System.out.println(JSON.toJSONString(personEntity, true));
    }

    @Test
    public void list() {
        List<PersonEntity> personEntityList = personService.list();
        System.out.println(JSON.toJSONString(personEntityList, true));
    }
}