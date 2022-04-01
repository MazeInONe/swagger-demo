package com.example.swagger.controller;

import com.example.swagger.domain.base.AjaxResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author Malu
 */
@RestController
public class IndexController {

    @GetMapping("/")
    public AjaxResult index() {
        return AjaxResult.success("Hello,World");
    }
}
