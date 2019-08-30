package com.example.demo_08.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @Auther: zhangliang
 * @Date: 2019-08-08 15:08
 * @Description: 项目
 */
@Data
@Entity
@Table(name = "dp_project")
public class ProjectEntity extends BaseEntity {

    /**
     * 项目名称
     */
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * 生产中心批次号
     */
    @Column(name = "flow_name", nullable = false)
    private String flow_name;


}
