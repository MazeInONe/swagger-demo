package com.example.swagger.domain.core;

import com.example.swagger.domain.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author 51544
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "t_role")
@org.hibernate.annotations.Table(appliesTo = "t_role",comment = "角色表")
public class Role extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -1603245439828280281L;

    @Column(nullable = false, unique = true, columnDefinition = "varchar(128) comment '角色名称'")
    private String name;

    @Column(columnDefinition = "varchar(128) comment '角色描述'")
    private String description;

    @Column(nullable = false, columnDefinition = "int(1) default 0 comment '角色等级'")
    private Integer level;
}
