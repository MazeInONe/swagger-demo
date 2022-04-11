package com.example.swagger.repository;

import com.example.swagger.domain.core.Power;
import com.example.swagger.domain.core.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Malu
 */
public interface PowerRepository extends JpaRepository<Power, Integer> {
}
