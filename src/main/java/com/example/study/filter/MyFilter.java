package com.example.study.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by louis on 2018/5/30.
 */
public class MyFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        StringBuilder sb = new StringBuilder("\n");
        sb.append("url:").append(req.getRequestURL()).append("\n");
        sb.append("method:").append(req.getMethod()).append("\n");
        System.out.println(sb.toString());

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
