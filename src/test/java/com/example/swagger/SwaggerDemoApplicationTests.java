package com.example.swagger;

import com.example.swagger.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class SwaggerDemoApplicationTests {
    @Autowired
    private UserRepository userRepository;

    @Test
    void contextLoads() {
    }
}
