package com.example.swagger.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


/**
 * @author 51544
 */
@RestController
public class SwaggerController {

    @GetMapping("/swagger")
    public ModelAndView swagger(Model model) {
        return new ModelAndView("redirect:/swagger-ui.html");
    }
}
