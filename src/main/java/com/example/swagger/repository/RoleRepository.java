package com.example.swagger.repository;

import com.example.swagger.domain.core.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Malu
 */
public interface RoleRepository extends JpaRepository<Role, Integer> {
}
