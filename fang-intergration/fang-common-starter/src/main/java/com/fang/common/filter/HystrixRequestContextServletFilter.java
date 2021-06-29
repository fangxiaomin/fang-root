package com.fang.common.filter;


import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @description:    Hystrix  缓存的过滤器
 * @projectName:fang-root
 * @see:com.fang.common.filter
 * @author:fxm
 * @createTime:2021/6/28 17:21
 * @version:1.0
 */
@WebFilter(filterName = "HystrixRequestContextServletFilter",urlPatterns = "/*",asyncSupported = true)
public class HystrixRequestContextServletFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        //初始化请求上下文
        HystrixRequestContext context = HystrixRequestContext.initializeContext();
        try {
            filterChain.doFilter(request, response);
        } finally {
            context.shutdown();
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
