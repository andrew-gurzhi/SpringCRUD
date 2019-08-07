package testgroup.dbService;

import org.springframework.beans.factory.annotation.Autowired;
import testgroup.model.Role;
import testgroup.model.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
public class TestData {

	@Autowired
	private RoleService roleService;

	@Autowired
	private UserService userService;

	public void init() {
		User userUs = new User();
		 Role userRole = new Role();
		Role adminRole = new Role();
		Role moderRole = new Role();
		List<Role> userRoles = new ArrayList<Role>();
		List<Role> adminRoles = new ArrayList<>();
		List<Role> moderRoles = new ArrayList<>();

		userRole.setType("USER");
		adminRole.setType("ADMIN");
		moderRole.setType("MODERATOR");
		roleService.addRole(userRole);
		roleService.addRole(adminRole);
		roleService.addRole(moderRole);
		userRoles.add(userRole);
		adminRoles.add(userRole);
		adminRoles.add(adminRole);
		adminRoles.add(moderRole);
		moderRoles.add(moderRole);
		moderRoles.add(userRole);

		userUs.setLogin("User");
		userUs.setPass("User");
		userUs.setName("User");
		userUs.setRoles(userRoles);

		User userAd = new User();
		userAd.setName("Admin");
		userAd.setPass("Admin");
		userAd.setLogin("Admin");
		userAd.setRoles(adminRoles);

		User userMod = new User();
		userMod.setLogin("Moderator");
		userMod.setPass("Moderator");
		userMod.setName("Moderator");
		userMod.setRoles(moderRoles);
		userService.addUser(userUs);
		userService.addUser(userMod);
		userService.addUser(userAd);

	}

//	@PersistenceContext
//	private EntityManager entityManager;


//	public void afterPropertiesSet() throws Exception {
////		System.out.println("Init method after properties are set : " + message);
//
//		user.setName("koll");
//		user.setLogin("koll");
//		user.setPass("koll");
//		user.setRole("user");
//		entityManager.persist(user);
//	}
//
//	public void destroy() throws Exception {
//		System.out.println("Spring Container is destroy! Customer clean up");
//	}

}
