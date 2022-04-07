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
@Table(name = "t_group")
public class Group extends BaseEntity implements Serializable {
    @Column(nullable = false, columnDefinition = "varchar(128) comment '组名称'")
    private String name;

    @Column(nullable = false, columnDefinition = "int(4) comment '父级组名称'")
    private Integer parentId;
}
