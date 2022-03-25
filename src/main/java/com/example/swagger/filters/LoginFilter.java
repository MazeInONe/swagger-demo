package com.example.swagger.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author Malu
 */
@WebFilter(value = "/*", filterName = "登录过滤")
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("before...");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("after...");
    }
}
