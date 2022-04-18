package com.example.swagger.controller.core;

import com.example.swagger.domain.base.AjaxResult;
import com.example.swagger.domain.core.Role;
import com.example.swagger.domain.core.User;
import com.example.swagger.repository.GroupRepository;
import com.example.swagger.repository.RoleRepository;
import com.example.swagger.repository.UserRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author Malu
 */
@RestController
@RequestMapping("/admin")
@Api(tags = "用户管理")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private RoleRepository roleRepository;


    @GetMapping(value = "/users")
    @ApiOperation(value = "获取所有用户", notes = "获取所有用户")
    public AjaxResult gerUserList() {
        return AjaxResult.success(userRepository.findAll());
    }

    @GetMapping(value = "/user/{userId}")
    @ApiOperation(value = "用户详情", notes = "用户详情")
    public AjaxResult getUserById(@PathVariable(value = "userId") Integer userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.map(value -> AjaxResult.success(user)).orElseGet(AjaxResult::success);
    }

    @PostMapping("/user/add")
    @ApiOperation(value = "增加用户", notes = "增加用户")
    public AjaxResult insertUser(@RequestBody Map<String, Object> body) {
        User user = new User();
        user.setEmail(String.valueOf(body.get("email")));
        user.setName((String) body.get("name"));
        user.setGroup(groupRepository.getById((Integer) body.get("group_id")));
        user.setRole(roleRepository.getById((Integer) body.get("role_id")));
        user.setNickName((String) body.get("nickname"));
        return AjaxResult.success(userRepository.save(user));
    }

    @PutMapping("/user/update/{userId}")
    @ApiOperation(value = "更新用户", notes = "更新用户")
    public AjaxResult updateUser(@RequestBody Map<String, Object> body,
                                 @PathVariable(value = "userId") Integer userId) {
        Optional<User> user = userRepository.findById(userId);
        try {
            user.ifPresent(value -> {
                value.setEmail(String.valueOf(body.get("email")));
                value.setName((String) body.get("name"));
                value.setGroup(groupRepository.getById((Integer) body.get("group_id")));
                value.setRole(roleRepository.getById((Integer) body.get("role_id")));
                value.setKeycloakId("test_id");
                value.setNickName((String) body.get("nickname"));
            });
            return AjaxResult.success(userRepository.save(user.get()));
        } catch (Exception e) {
            logger.error("更新用户{}失败", userId);
        }
        return AjaxResult.error();
    }

    @DeleteMapping("/user/delete/{userId}")
    @ApiOperation(value = "删除用户", notes = "删除用户")
    public AjaxResult deleteUser(@RequestParam(value = "userId") Integer userId) {
        Optional<User> user = userRepository.findById(userId);
        try {
            user.ifPresent(value -> userRepository.delete(value));
            return AjaxResult.success();
        } catch (Exception e) {
            logger.error("删除用户{}失败", userId);
            e.printStackTrace();
        }
        return AjaxResult.error();
    }

}
