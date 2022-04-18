package com.example.swagger.controller.core;

import com.example.swagger.domain.base.AjaxResult;
import com.example.swagger.domain.core.Role;
import com.example.swagger.repository.RoleRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @author 51544
 */
@RestController
@RequestMapping("/admin")
@Api(tags = "角色管理")
public class RoleController {

    private final Logger logger = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/roles")
    @ApiOperation(value = "获取所有角色", notes = "获取所有角色")
    public AjaxResult roles() {
        return AjaxResult.success(roleRepository.findAll());
    }

    @GetMapping(value = "/role/{roleId}")
    @ApiOperation(value = "角色详情", notes = "角色详情")
    public AjaxResult getRoleById(@PathVariable(value = "roleId") Integer roleId) {
        Optional<Role> role = roleRepository.findById(roleId);
        return role.map(AjaxResult::success).orElseGet(() -> AjaxResult.success("操作成功"));
    }

    @PostMapping("/role/add")
    @ApiOperation(value = "增加角色", notes = "增加角色")
    public AjaxResult insertRole(@RequestBody Map<String, Object> body) {
        Role role = new Role();
        role.setName(String.valueOf(body.get("name")));
        role.setDescription(String.valueOf(body.get("description")));
        role.setLevel((Integer) body.get("level"));
        return AjaxResult.success(roleRepository.save(role));
    }

    @PutMapping("/role/update/{roleId}")
    @ApiOperation(value = "更新角色", notes = "更新角色")
    public AjaxResult updateRole(@RequestBody Map<String, Object> body,
                                 @PathVariable(value = "roleId") Integer roleId) {
        Optional<Role> role = roleRepository.findById(roleId);
        try {
            role.ifPresent(value -> {
                value.setName(String.valueOf(body.get("name")));
                value.setDescription(String.valueOf(body.get("description")));
                value.setLevel((Integer) body.get("level"));
            });
            return AjaxResult.success(roleRepository.save(role.get()));
        } catch (Exception e) {
            logger.error("更新角色{}失败", roleId);
            e.printStackTrace();
        }
        return AjaxResult.error();
    }

    @DeleteMapping("/role/delete/{roleId}")
    @ApiOperation(value = "删除角色", notes = "删除角色")
    public AjaxResult deleteRole(@PathVariable(value = "roleId") Integer roleId) {
        Optional<Role> role = roleRepository.findById(roleId);
        try {
            role.ifPresent(value -> roleRepository.delete(value));
            return AjaxResult.success();
        } catch (Exception e) {
            logger.error("删除角色{}失败", roleId);
            e.printStackTrace();
        }
        return AjaxResult.error();
    }
}
