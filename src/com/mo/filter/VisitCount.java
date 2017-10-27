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
import javax.servlet.http.HttpSession;
import com.mo.po.IpInfo;
import com.mo.service.BusinessService;
import com.mo.service.BusinessServiceImpl;
import com.mo.util.IpAddress;

public class VisitCount implements Filter {
	
	private BusinessService s = BusinessServiceImpl.getInstance();
	
	public void destroy() {}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest) arg0;//获取request对象
		HttpServletResponse response=(HttpServletResponse) arg1;//获取response对象
		HttpSession session = request.getSession();
		//获取全局变量
		ServletContext application = request.getSession().getServletContext();
		
		//ip信息用于显示welcome那里的
		if(session.getAttribute("ipInfo") != null) {
			//
		}else {
			String ip = request.getRemoteAddr();
			ip = "14.118.136.177";
			String addressLocation = IpAddress.changeIpToAddress(ip);
			//无论ip库有么有该ip都直接添加 
			IpInfo ipInfo = new IpInfo();
			ipInfo.setIp(ip);
			ipInfo.setAddressLocation(addressLocation);
			//增加一天ip记录
			s.addIpInfo(ipInfo);
			session.setAttribute("ipInfo", addressLocation);//这里是come from + 地名的那里
		}
		
		
		//统计网站的访问量
		Integer totalVisit = null;
		synchronized(application) {
			totalVisit = (Integer)application.getAttribute("totalVisit");
			//如果还没有人访问就没有这个内容，要新建一个
			if(totalVisit == null) {
				totalVisit = 1;
				application.setAttribute("totalVisit", totalVisit);
			}
			totalVisit = totalVisit + 1;
			application.setAttribute("totalVisit", totalVisit);
		}
		//进入下一个过滤器
		arg2.doFilter(arg0, arg1);
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		
	}
	
	
}
