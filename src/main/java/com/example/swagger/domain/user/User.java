package com.example.swagger.domain.user;

import com.example.swagger.domain.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author Malu
 */
@Data
@Entity
@Table(name = "user")
public class User extends BaseEntity implements Serializable {

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
