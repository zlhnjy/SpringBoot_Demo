package com.example.demo_08.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @Auther: zhangliang
 * @Date: 2019/4/12 17:19
 * @Description:
 */
@Entity
@Table(name = "person")
@Data
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;

}
