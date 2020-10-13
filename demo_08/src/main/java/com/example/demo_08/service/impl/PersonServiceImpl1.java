package com.example.demo_08.service.impl;

import com.example.demo_08.bean.PersonBean;
import com.example.demo_08.entity.PersonEntity;
import com.example.demo_08.repository.IPersonJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo_08.service.IPersonService;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther: zhangliang
 * @Date: 2019/4/12 16:10
 * @Description:
 */
@Service("personService1")
public class PersonServiceImpl1 implements IPersonService {

    @Autowired
    private IPersonJpaRepository personJpaRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public PersonEntity save(PersonEntity personEntity) {
        return personJpaRepository.save(personEntity);
    }

    @Override
    public List<PersonEntity> save(List<PersonEntity> personEntities) {
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

    @Override
    public void testSave() {

    }
}
