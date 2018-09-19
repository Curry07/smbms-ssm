package cn.smbms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import cn.smbms.pojo.User;

public class BaseController {
	
	//获取当前登陆的用户
	public User getCurrentUser() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("loginUser");
		return user;
		
	}

}
