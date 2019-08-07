package testgroup.dbService;

import testgroup.model.Role;

import java.util.List;

public interface RoleService {
	void addRole(Role role);
	Role getRole(String name);

	List<Role> getAllRoles();
}

