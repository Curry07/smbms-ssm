package cn.smbms.service.role;

import java.util.List;

import cn.smbms.pojo.Role;

public interface RoleService {

	/**
	 * 查询角色列表
	 * @return
	 */
	List<Role> getRoleList();

}
