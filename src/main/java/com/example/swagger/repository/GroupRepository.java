package com.example.swagger.repository;

import com.example.swagger.domain.core.Group;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Malu
 */
public interface GroupRepository extends JpaRepository<Group, Integer> {
}
