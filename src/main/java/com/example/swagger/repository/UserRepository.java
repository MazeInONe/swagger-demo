package com.example.swagger.repository;

import com.example.swagger.domain.core.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Malu
 */
public interface UserRepository extends JpaRepository<User, Integer> {
}
