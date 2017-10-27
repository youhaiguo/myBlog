package com.mo.filter;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.mo.service.BusinessService;
import com.mo.service.BusinessServiceImpl;
import com.mo.util.FormatDate;

public class IpInfoFilter implements Filter {

	private BusinessService s = BusinessServiceImpl.getInstance();
	
	public void destroy() {}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest) arg0;//获取request对象
		HttpServletResponse response=(HttpServletResponse) arg1;//获取response对象
		HttpSession session = request.getSession();
		
		//访问人数
		session.getServletContext().setAttribute("applicationTotal",s.findTotalIp());
		
		if(session.getAttribute("lastVisitTime") != null) {
			//
		}else {
			Cookie[] cookies = request.getCookies();
			boolean flag = true;
			if(cookies != null) {
				for (Cookie cookie : cookies) {
					if(cookie.getName().equals("lastVisitTime")) {
						String lastVisitTime = cookie.getValue();
						session.setAttribute("lastVisitTime", "你上次访问的时间是:" + lastVisitTime);
						flag = false;
					}
				}
				if(flag) {
					session.setAttribute("lastVisitTime", "这是你首次访问该网站" + ", 是第" + s.findTotalIp() + "个访客");
				}
			}else {
				session.setAttribute("lastVisitTime","这是你首次访问该网站"+ ", 是第" + s.findTotalIp() + "个访客");
			}
			
			//设置Cookie的过期时间是十年
			Cookie cookie = new Cookie("lastVisitTime", FormatDate.changeDateToString(new Date()));
			cookie.setMaxAge(10*365*24*60*60);
			response.addCookie(cookie);
		}
		
		arg2.doFilter(arg0, arg1);
	}

	public void init(FilterConfig arg0) throws ServletException {}

}
