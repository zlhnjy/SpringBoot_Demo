package com.example.demo_08.service.impl;

import com.example.demo_08.bean.PersonBean;
import com.example.demo_08.entity.PersonEntity;
import com.example.demo_08.repository.IPersonJpaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.example.demo_08.service.IPersonService;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @Auther: zhangliang
 * @Date: 2019/4/12 16:09
 * @Description:
 */
@Service("personService")
public class PersonServiceImpl implements IPersonService {

    @Autowired
    private IPersonJpaRepository personJpaRepository;

    @Autowired
    @Qualifier("personService1")
    private IPersonService personService1;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)  //当调用方法A和被调用的方法B在同一个class中的时候，B不会被事务拦截器拦截，因此不会生效，依然会回滚
    public PersonEntity save(PersonEntity personEntity) {
        return personJpaRepository.save(personEntity);
    }

    @Override
    public List<PersonEntity> list() {
        return personJpaRepository.findAll();
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    @Cacheable(value = "personBean", key = "#id")
    public PersonBean findById(Long id) {
        Optional<PersonEntity> personEntityOptional = personJpaRepository.findById(id);
        if(personEntityOptional.isPresent()) {
            PersonEntity personEntity = personEntityOptional.get();
            PersonBean personBean = new PersonBean();
            BeanUtils.copyProperties(personEntity, personBean);
            return personBean;
        }
        return null;
    }

    @Override
    @Transactional
    public void testSave() {
        PersonEntity personEntity2 = new PersonEntity("wangwu", 10);
        personService1.save(personEntity2);
        PersonEntity personEntity = new PersonEntity("zhangsan", 11);
        save(personEntity);
//        personJpaRepository.save(personEntity);
        PersonEntity personEntity1 = new PersonEntity("lisi", 10);
        personJpaRepository.save(personEntity1);
        throw new IllegalArgumentException("test exception");
    }
}
