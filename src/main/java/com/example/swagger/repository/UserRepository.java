package com.example.swagger.repository;

import com.example.swagger.domain.core.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Malu
 */
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "select * from user where id between ?1 and ?2", nativeQuery = true)
    public List<User> findUsersByRange(Integer start, Integer end);
}
