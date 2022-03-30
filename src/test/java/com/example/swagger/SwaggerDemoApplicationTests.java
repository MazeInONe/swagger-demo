package com.example.swagger;

import com.example.swagger.domain.core.User;
import com.example.swagger.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class SwaggerDemoApplicationTests {
    @Autowired
    private UserRepository userRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void testInsert() {
        User user = new User();
        user.setEmail("www.qq.com");
        user.setGroupId(2);
        user.setRoleId(2);
        user.setKeycloakId("66666666666666666666666666666666666");
        user.setName("毛路海");
        user.setNickName("毛子");
        user.setCreatedOn(new Date());
        user.setUpdatedOn(new Date());
        userRepository.save(user);
    }
}
