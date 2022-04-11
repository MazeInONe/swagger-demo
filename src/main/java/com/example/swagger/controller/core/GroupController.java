package com.example.swagger.controller.core;


import com.example.swagger.domain.base.AjaxResult;
import com.example.swagger.domain.core.Group;
import com.example.swagger.repository.GroupRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@Api(tags = "组管理")
public class GroupController {
    @Autowired
    private GroupRepository groupRepository;

    @GetMapping("/groups")
    public AjaxResult groups() {
        return AjaxResult.success("操作成功", groupRepository.findAll());
    }

    @GetMapping("/group/{groupId}")
    public AjaxResult group(@PathVariable(value = "groupId") Integer groupId) {
        Optional<Group> group = groupRepository.findById(groupId);
        return group.map(value -> AjaxResult.success("操作成功", value)).orElseGet(() -> AjaxResult.success("操作成功"));
    }


}
