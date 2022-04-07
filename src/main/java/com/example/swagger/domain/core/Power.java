package com.example.swagger.domain.core;

import com.example.swagger.domain.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "t_power")
public class Power extends BaseEntity implements Serializable {
    @Column(nullable = false, columnDefinition = "varchar(128) comment '权限名称'")
    private String name;

    @Column(nullable = false, columnDefinition = "int(11) default 0 comment '父权限id'")
    private String parentId;

    @Column(nullable = false, columnDefinition = "int(2) comment '权限类型: 1模块 2页面 3API'")
    private Integer type;

    @Column(columnDefinition = "int(4) comment '同级权限排序'")
    private Integer orderId;

    @Column(nullable = false, columnDefinition = "varchar(128) comment '权限路由'")
    private Integer url;

    @Column(nullable = false, columnDefinition = "varchar(16) comment '权限请求方式'")
    private Integer method;


}
