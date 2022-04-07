package com.example.swagger.config;

import com.example.swagger.domain.base.AjaxResult;
import org.keycloak.adapters.springsecurity.KeycloakConfiguration;
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Malu
 */
@KeycloakConfiguration
public class KeycloakSecurityConfig extends KeycloakWebSecurityConfigurerAdapter {

    private final Logger logger = LoggerFactory.getLogger(KeycloakSecurityConfig.class);

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(keycloakAuthenticationProvider());
    }

    @Bean
    @Override
    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
        return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
    }


    @Override
    protected AuthenticationEntryPoint authenticationEntryPoint() {
        return (request, response, authException) -> {
            logger.warn("401 Unauthorized while processing " + request.getRequestURI());
            response.setCharacterEncoding("utf-8");
            response.setContentType("text/javascript;charset=utf-8");
            Map<String, String> map = new HashMap<>();
            map.put("msg", "操作失败，没有权限访问");
            map.put("code", "50000");
            response.getWriter().write(map.toString());
        };
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        http.csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/admin/**", "/manage").hasRole("ADMIN")
                .antMatchers("/common/**", "/books").hasRole("COMMON")
                .anyRequest().permitAll();

    }
}
