package com.example.swagger.domain.core;

import com.example.swagger.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "t_role")
public class Role extends BaseEntity implements Serializable {
    @Column(nullable = false, unique = true, columnDefinition = "varchar(128) comment '角色名称'")
    private String name;

    @Column(columnDefinition = "varchar(128) comment '角色描述'")
    private String desc;

    @Column(nullable = false, columnDefinition = "int(1) default 0 comment '角色等级'")
    private Integer level;
}
