package testgroup.dbService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import testgroup.dao.UserDAO;
import testgroup.model.Role;
import testgroup.model.User;

import java.util.List;

@Service("userService")

public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userdao;



    @Override
	public List<User> getAllUsers() {
		return userdao.getAllUsers();
	}
	@Override
	public void deleteUser(long id) {
		userdao.deleteUser(id);
	}

	@Override
	public void addUser(User user) {
		userdao.addUser(user);
	}

	@Override
	public void updateUser(User user, long id) {
		userdao.updateUser(user, id);
	}
	@Override
	public User getUser(long id) {
		return userdao.getUser(id);
	}
	@Override
	public boolean checkUser(String name) {
		return userdao.checkUser(name);
	}
	@Override
	public boolean checkpass(String name, String pass) {
		return userdao.checkpass(name, pass);
	}
	@Override
	public User getUser(String name) {
		return userdao.getUser(name);
	}



}
