package com.example.swagger.domain.core;

import com.example.swagger.domain.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Map;

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

    @Column(name = "keycloak_id", length = 64, nullable = false)
    private String keycloakId;

    @Column(name = "group_id", length = 32, nullable = false)
    private Integer groupId;

    @Column(name = "role_id", length = 32, nullable = false)
    private Integer roleId;

    @Column(length = 32)
    private String email;

}
