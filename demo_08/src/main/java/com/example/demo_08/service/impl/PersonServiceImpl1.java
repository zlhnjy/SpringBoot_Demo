package com.example.demo_08.service.impl;

import com.example.demo_08.bean.PersonBean;
import com.example.demo_08.entity.PersonEntity;
import org.springframework.stereotype.Service;
import com.example.demo_08.service.IPersonService;

import java.util.List;

/**
 * @Auther: zhangliang
 * @Date: 2019/4/12 16:10
 * @Description:
 */
@Service
public class PersonServiceImpl1 implements IPersonService {

    @Override
    public PersonEntity save(PersonEntity personEntity) {
        return null;
    }

    @Override
    public List<PersonEntity> list() {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public PersonBean findById(Long id) {
        return null;
    }
}
