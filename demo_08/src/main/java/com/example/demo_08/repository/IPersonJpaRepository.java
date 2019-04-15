package com.example.demo_08.repository;

import com.example.demo_08.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Auther: zhangliang
 * @Date: 2019/4/12 17:51
 * @Description:
 */
public interface IPersonJpaRepository extends JpaRepository<PersonEntity, Long> {
}
