package testgroup.dbService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import testgroup.dao.UserDAO;
import testgroup.model.Role;
import testgroup.model.User;

import java.util.List;

public interface UserService  {


	 List<User> getAllUsers();

	void deleteUser(long id);


	void addUser(User user);

	//
	void updateUser(User user, long id);

	//
	User getUser(long id);

	//
	boolean checkUser(String name);

	//
	boolean checkpass(String name, String pass);

	User getUser(String name);

}
