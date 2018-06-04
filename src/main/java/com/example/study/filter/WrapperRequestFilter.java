package com.example.study.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by zzqfsy on 3/15/17.
 */
public class WrapperRequestFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        chain.doFilter(new ModifiableRequestWrapper((HttpServletRequest) request),response);
    }

    @Override
    public void destroy() {

    }
}
