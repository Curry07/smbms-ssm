package cn.smbms.dao.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.smbms.pojo.User;

public interface UserMapper {

	
	/**
	 * 利用ajax根据id查询用户
	 * @param id
	 * @return
	 */
	User getUserById(@Param("id")Integer id);
	
	/**
	 * 
	 * 获取总记录数
	 * @param username
	 * @param userRole
	 * @return
	 */
	int getUserCount( @Param("username")String username, @Param("userRole")String userRole);

	/**
	 * 获取用户列表
	 * @param startIndex
	 * @param pageSize
	 * @param username
	 * @param userRole
	 * @return
	 */
	List<User> getUserListForPage(@Param("startIndex")int startIndex, @Param("pageSize")int pageSize, @Param("username")String username,@Param("userRole")String userRole);
	
	
	/**
	 * 密码修改
	 * @param id
	 * @param newpassword
	 * @return
	 */
	int updatePwd(@Param("id")Integer id,@Param("password")String newpassword);
	
	/**
	 * 根据用户编码查询用户
	 * @param userCode
	 * @return
	 */
	User getUserByUserCode(@Param("userCode")String userCode);



	

	

}
