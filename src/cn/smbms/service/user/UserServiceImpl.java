package cn.smbms.service.user;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.smbms.dao.user.UserMapper;
import cn.smbms.pojo.User;
import cn.smbms.util.PageBean;

@Transactional
@Service
public class UserServiceImpl implements UserService {
	@Resource
	private UserMapper userMapper;


	@Override
	public User getUserById(Integer id) {
		return userMapper.getUserById(id);
	}

	
	
	
	@Override
	public void getUserListForPage(PageBean<User> pageBean, String username, String userRole) {

		int totalCount = userMapper.getUserCount(username,userRole);
		pageBean.setTotalCount(totalCount);
		
		List<User> result = userMapper.getUserListForPage(pageBean.getStartIndex(),pageBean.getPageSize(),username,userRole);
		pageBean.setResult(result);
	}

	
	@Override
	public boolean updatePwd(Integer id, String newpassword) {
		boolean flag = false;
		if (userMapper.updatePwd(id,newpassword) > 0) {
			flag = true;
		}
		return flag;
	}
	
	
	@Override
	public User login(String userCode, String userPassword) {
		User result = null;
		result = userMapper.getUserByUserCode(userCode);
		if (result != null) {
			if (!result.getUserPassword().equals(userPassword)) {
				result = null;
			}
		}
		return result;
	}


	

	

	







}
