package com.example.swagger.domain.core;


import com.example.swagger.domain.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author 51544
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "t_grp")
public class GroupRolePower extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1585447927823252895L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    private Group group;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "power_id", referencedColumnName = "id")
    private Power power;
}
