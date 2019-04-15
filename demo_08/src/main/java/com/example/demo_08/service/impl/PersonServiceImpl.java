package com.example.demo_08.service.impl;

import com.example.demo_08.bean.PersonBean;
import com.example.demo_08.entity.PersonEntity;
import com.example.demo_08.repository.IPersonJpaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.example.demo_08.service.IPersonService;

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

    @Override
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
}
