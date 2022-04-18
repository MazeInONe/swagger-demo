package com.example.swagger.domain.core;

import com.example.swagger.domain.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Malu
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "t_user")
public class User extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 8673223947797271299L;

    @Column(length = 128, nullable = false)
    private String name;

    @Column(name = "nick_name", length = 128)
    private String nickName;

    @Column(name = "keycloak_id", length = 64)
    private String keycloakId;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @Column(length = 32)
    private String email;

}
