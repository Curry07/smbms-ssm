package cn.smbms.service.user;

import cn.smbms.pojo.User;
import cn.smbms.util.PageBean;

public interface UserService {

	
	/**
	 * 使用ajax根据id查询用户
	 * @return
	 */
	User getUserById(Integer id);
	
	
	/**
	 * 分页查询用户列表
	 * @param pageBean
	 * @param username
	 * @param userRole
	 */
	void getUserListForPage(PageBean<User> pageBean, String username, String userRole);
	
	/**
	 * 修改密码
	 * @param userCode
	 * @param newpassword
	 * @return
	 */
	boolean updatePwd(Integer id, String newpassword);
	
	
	/**
	 * 用户的登录
	 * @param userCode
	 * @param userPassword
	 * @return
	 */
	User login(String userCode,String userPassword);

	

	


	

	

	

}
