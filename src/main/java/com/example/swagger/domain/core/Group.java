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
@Table(name = "t_group")
@org.hibernate.annotations.Table(appliesTo = "t_group",comment = "组表")
public class Group extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -5684795639035180646L;

    @Column(nullable = false, columnDefinition = "varchar(128) comment '组名称'")
    private String name;

    @Column(nullable = false, columnDefinition = "int(4) default 0 comment '父级组名称'")
    private Integer parentId;
}
