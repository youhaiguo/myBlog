package com.mo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UrlFilter implements Filter{

	public void destroy() {}
	public void init(FilterConfig arg0) throws ServletException {}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest) arg0;//获取request对象
		HttpServletResponse response=(HttpServletResponse) arg1;//获取response对象
		
		//获取登录信息
		String isLogin = (String)request.getSession().getAttribute("isLogin");
		
		if("true".equals(isLogin)) {
			chain.doFilter(arg0, arg1);
		}else {
			//如果没有获取到信息就是还没有进行登录
			response.sendRedirect("/mo/login.jsp");
		}
	}

	
	

}
