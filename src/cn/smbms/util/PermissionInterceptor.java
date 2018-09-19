package cn.smbms.util;

import javax.naming.NoPermissionException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class PermissionInterceptor extends HandlerInterceptorAdapter {

    /**
     * 前置处理  可以在指定的目标资源之前执行   类型与过滤器
     * 如果为true表示放行
     * false表示不在执行
     * */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//判断用户是否登录
		Object obj = request.getSession().getAttribute("loginUser");
		if (obj == null) {
			throw new NoPermissionException("用户没有登录");
		}
		return true;
	}
	
}
