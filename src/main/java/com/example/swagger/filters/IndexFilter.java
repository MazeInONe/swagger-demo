package com.example.swagger.filters;

import org.apache.catalina.filters.CorsFilter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author Malu
 */
@WebFilter(value = "/*", filterName = "默认过滤")
public class IndexFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("before IndexFilter");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("after IndexFilter");
    }
}
