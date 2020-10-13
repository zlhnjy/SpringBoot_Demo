package com.example.demo_08.service;

import com.example.demo_08.bean.PersonBean;
import com.example.demo_08.entity.PersonEntity;

import java.util.List;

/**
 * @Auther: zhangliang
 * @Date: 2019/4/12 16:08
 * @Description:
 */
public interface IPersonService {

    PersonEntity save(PersonEntity personEntity);
    List<PersonEntity> save(List<PersonEntity> personEntities);

    List<PersonEntity> list();

    void delete(Long id);

    PersonBean findById(Long id);

    void testSave();

}
