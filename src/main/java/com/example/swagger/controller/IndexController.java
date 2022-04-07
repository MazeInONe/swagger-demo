package com.example.swagger.controller;

import com.example.swagger.domain.base.AjaxResult;
import org.keycloak.KeycloakSecurityContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


/**
 * @author Malu
 */
@RestController
public class IndexController {

    @GetMapping("/admin/index")
    public AjaxResult index(HttpServletRequest request) {
        System.out.println("qqqqqqqqqqqqqqqqqqqqqqqqq===");
        KeycloakSecurityContext keycloak = (KeycloakSecurityContext) request.getAttribute(KeycloakSecurityContext.class.getName());
        System.out.println(keycloak.getTokenString());
        return AjaxResult.success("Hello,World");
    }
}
