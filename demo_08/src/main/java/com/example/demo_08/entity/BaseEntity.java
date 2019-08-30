package com.example.demo_08.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @Auther: zhangliang
 * @Date: 2019-08-08 15:07
 * @Description:
 */
@Data
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

}
