package testgroup.dao;

import org.springframework.beans.factory.annotation.Autowired;
import testgroup.model.Role;
import testgroup.model.User;

import java.util.List;

public interface UserDAO {

	void addUser(User user);

	//
	void updateUser(User user, long id);

	boolean checkUser(String name);

	boolean checkpass(String name, String pass);

	User getUser(String name);

	User getUser(long id);

	void deleteUser(long id);

	List<User> getAllUsers();


}
