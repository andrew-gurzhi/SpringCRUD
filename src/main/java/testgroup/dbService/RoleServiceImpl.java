package testgroup.dbService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import testgroup.dao.RoleDao;
import testgroup.model.Role;

import java.util.List;

@Service("roleService")
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleDao roleDao;
	@Override
	public void addRole(Role userRole) {
		roleDao.addRole(userRole);
	}

	@Override
	public Role getRole(String name) {
		return roleDao.getRole(name);
	}

	@Override
	public List<Role> getAllRoles() {
		return roleDao.getAllUsers();
	}
}
