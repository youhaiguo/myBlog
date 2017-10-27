package com.mo.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestSer extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Cookie[] cookies = req.getCookies();
		if(cookies != null) {
			for (Cookie cookie : cookies) {
				System.out.print(cookie.getName()+":");
				System.out.println(cookie.getValue());
			}
		}else {
			System.out.println("没有cookie");
		}
		Cookie c1 = new Cookie("a", "a");
		Cookie c2 = new Cookie("b", "b");
		Cookie c3 = new Cookie("c", "c");
		Cookie c4 = new Cookie("d", "d");
		resp.addCookie(c1);
		resp.addCookie(c2);
		resp.addCookie(c3);
		resp.addCookie(c4);
	}
	
}
