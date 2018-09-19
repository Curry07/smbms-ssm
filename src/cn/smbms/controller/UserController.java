package cn.smbms.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import cn.smbms.pojo.Role;
import cn.smbms.pojo.User;
import cn.smbms.service.role.RoleService;
import cn.smbms.service.user.UserService;
import cn.smbms.util.PageBean;

@Controller
@RequestMapping("/auth/user")
public class UserController extends BaseController{

	@Resource
	private UserService userService;
	
	@Resource
	private RoleService roleService;
	
	
	
	@RequestMapping("/useraddsave")
	public String userAddSave() {
		return null;
	}
	
	
	/**
	 * 跳转到用户添加的页面
	 * @return
	 */
	@RequestMapping("/touseradd")
	public String toUserAdd() {
		return "useradd";
		
	}
	
	/**
	 * 
	 * 利用ajax查询用户
	 * @param id
	 * @return
	 */
	@ResponseBody   //ajax进行异步请求的处理
	@RequestMapping(value="/userView/{id}")//rest风格进行处理   在参数中添加参数注解获得rest风格的参数
	public String toUserView(@PathVariable Integer id) {
		HashMap<String, Object> hashMap = new HashMap<>();
		User user = userService.getUserById(id);
		if (user != null) {
			hashMap.put("flag","success");
			hashMap.put("user", user);
		}
		return JSON.toJSONStringWithDateFormat(hashMap, "yyyy-MM-dd");
	}
	
	
	
	@RequestMapping("/userlist")
	public String doUselist(Model model,
			                @RequestParam(value="p",required=false)Integer p,
			                @RequestParam(value="queryUserName",required=false)String username,
			                @RequestParam(value="queryUserRole",required=false)String userRole) {
		//当前页
		Integer currentPageNo = 1;
		//每页显示多少页
		Integer pageSize = 5;
		//当前页     p 为起始索引
		if(p != null) {
			currentPageNo = p;
		}
		PageBean<User> pageBean = new PageBean<User>();
		pageBean.setCurrentPageNo(currentPageNo);
		pageBean.setPageSize(pageSize);
		userService.getUserListForPage(pageBean,username,userRole);
		
		//查询所有的角色信息
		List<Role> roleList = roleService.getRoleList();
		
		model.addAttribute("pageBean", pageBean);
		model.addAttribute("roleList", roleList);
		//回显
		model.addAttribute("queryUserName", username);
		model.addAttribute("queryUserRole", userRole);
		return "userlist";
	}
	
	/**
	 * 修改密码的保存
	 * @param model
	 * @param newpassword
	 * @return
	 */
	@RequestMapping("/pwdsave")
	public String pwdsave(Model model,@RequestParam String newpassword) {
		boolean result = userService.updatePwd(this.getCurrentUser().getId(),newpassword);
		if (!result) {
			model.addAttribute("message", "密码修改失败！请重试");
			return "pwdmodify";
		}
		return "redirect:/";
		
	}

	/**
	 * 检查原密码
	 * 处理异步请求
	 * 加上次注解  就不需要跳转页面   而是将return数据直接塞到请求体中
	 * */
	@ResponseBody
	@RequestMapping("/pwdmodify")
	public String checkOldPwd(HttpSession session,@RequestParam String oldpassword) {
		HashMap<String, Object> hashMap = new HashMap<>();
		//User user = (User) session.getAttribute("loginUser");
		User user = this.getCurrentUser();
		String result = "true";
		if ( user == null) {//用户session失效 
			result = "sessionerror";
		}else if (userService.login(user.getUserCode(), oldpassword) == null) {
			result = "false";
		}
		hashMap.put("result", result);
		//ajax的请求方式   返回值类型是json   需要将其转换成json格式
		String jsonString = JSON.toJSONString(hashMap);
		return jsonString;
	}
	
	@RequestMapping("/topwdmodify")
	public String topwdmodify() {
		return "pwdmodify";
	}
}
