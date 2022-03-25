package com.example.swagger.controller.user;

import com.example.swagger.AjaxResult;
import com.example.swagger.domain.user.User;
import com.example.swagger.repository.UserRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

/**
 * @author Malu
 */
@RestController
@Api(tags = "用户管理")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @ApiOperation(value = "获取所有用户", notes = "拿到所有用户的")
    @GetMapping(value = "/user")
    public List<User> gerUserList() {
        System.out.println("gerUserList");
        return userRepository.findAll();
    }

    @ApiOperation(value = "用户详情", notes = "拿到某个用户信息")
    @GetMapping(value = "/user/{userId}")
    public AjaxResult getUserById(@PathVariable(value = "userId") Integer userId) {
        Optional<User> optional = userRepository.findById(userId);
        if (optional.isPresent()) {
            User user = optional.get();
            return AjaxResult.success("操作成功", user);
        }
        return AjaxResult.success("操作成功");
    }

    @ApiOperation(value = "多个用户", notes = "拿到某个用户信息")
    @GetMapping(value = "/user/range")
    public AjaxResult getUserById(@RequestParam(value = "start") Integer start, @RequestParam(value = "end") Integer end) {
        List<User> list = userRepository.findUsersByRange(start, end);
        return AjaxResult.success("操作成功", list);
    }

    @GetMapping("/swagger")
    public ModelAndView swagger(Model model) {
        return new ModelAndView("redirect:/swagger-ui.html");
    }
}
