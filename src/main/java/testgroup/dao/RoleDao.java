package testgroup.dao;

import testgroup.model.Role;
import testgroup.model.User;

import java.util.List;

public interface RoleDao {
	void addRole(Role userRole);

	Role getRole(String name);

	List<Role> getAllUsers();
}
