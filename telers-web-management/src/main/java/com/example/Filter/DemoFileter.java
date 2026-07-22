package com.example.Filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;
//@WebFilter(urlPatterns = "/*")
public class DemoFileter implements Filter {
    //初始化方法,web服务器启动时执行，只执行一次
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }
  //拦截到请求后执行 会执行多次
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    //放行
        chain.doFilter(request,response);
    }
    //销毁方法,web服务器关闭时执行，只执行一次
    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
