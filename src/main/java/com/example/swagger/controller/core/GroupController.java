package com.example.swagger.controller.core;


import com.example.swagger.domain.base.AjaxResult;
import com.example.swagger.domain.core.Group;
import com.example.swagger.repository.GroupRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

/**
 * @author 51544
 */
@RestController
@RequestMapping("/admin")
@Api(tags = "组管理")
public class GroupController {

    private final Logger logger = LoggerFactory.getLogger(GroupController.class);

    @Autowired
    private GroupRepository groupRepository;

    @GetMapping("/groups")
    @ApiOperation(value = "组列表", notes = "组列表")
    public AjaxResult groups() {
        return AjaxResult.success("操作成功", groupRepository.findAll());
    }

    @GetMapping("/group/{groupId}")
    @ApiOperation(value = "组详情", notes = "组详情")
    public AjaxResult group(@PathVariable(value = "groupId") Integer groupId) {
        Optional<Group> group = groupRepository.findById(groupId);
        return group.map(value -> AjaxResult.success("操作成功", value)).orElseGet(() -> AjaxResult.success("操作成功"));
    }

    @PostMapping("/group/add")
    @ApiOperation(value = "新增组", notes = "新增组")
    public AjaxResult addGroup(@RequestBody Map<String, Object> body) {
        Group group = new Group();
        group.setName(String.valueOf(body.get("name")));
        group.setParentId((Integer) body.getOrDefault("parent_id", "0"));
        return AjaxResult.success(groupRepository.save(group));
    }

    @PostMapping("/group/update/{groupId}")
    @ApiOperation(value = "更新组信息", notes = "更新组信息")
    public AjaxResult addGroup(@PathVariable Integer groupId,
                               @RequestBody Map<String, Object> body) {
        try {
            Optional<Group> group = groupRepository.findById(groupId);
            group.ifPresent(value -> {
                value.setName(String.valueOf(body.get("name")));
                value.setParentId((Integer) body.get("parent_id"));
            });
            return AjaxResult.success(groupRepository.save(group.get()));
        } catch (Exception e) {
            logger.error("更新组{}信息失败", groupId);
        }
        return AjaxResult.error();
    }

    @PostMapping("/group/delete/{groupId}")
    @ApiOperation(value = "删除组信息", notes = "删除组信息")
    public AjaxResult addGroup(@PathVariable Integer groupId) {
        try {
            Optional<Group> group = groupRepository.findById(groupId);
            group.ifPresent(value -> groupRepository.delete(value));
            return AjaxResult.success();
        } catch (Exception e) {
            logger.error("删除组{}信息失败", groupId);
        }
        return AjaxResult.error();
    }

}
