package cn.smbms.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.smbms.pojo.User;
import cn.smbms.service.user.UserService;

@Controller
public class LoginController {
	 
	@Resource
	private UserService userService;
	
	/**
	 * 注销
	 * @return
	 */
	@RequestMapping("/user/logout.html")
	public String loginout(HttpSession session) {
		session.invalidate();//利用session对象注销用户
		return "redirect:/";
	}

	@RequestMapping("/auth/main.html")
	public String toMain() {
		return "frame";
	}
	
	/**
	 * 用户的登录跳转
	 * @param model
	 * @param userCode
	 * @param userPassword
	 * @return
	 */
	@RequestMapping("/user/dologin.html")
	public String doLogin(
			              HttpServletRequest request,
			              @RequestParam String userCode,
			              @RequestParam String userPassword) {
		User loginUser = userService.login(userCode,userPassword);
		if (loginUser == null) {
			request.setAttribute("loginErroe", "用户编码或密码错误");
			return "login";
		}
		request.getSession().setAttribute("loginUser", loginUser);
		return "redirect:/auth/main.html";
	}
}
