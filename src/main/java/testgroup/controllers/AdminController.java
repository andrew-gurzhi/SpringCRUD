package testgroup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import testgroup.dbService.RoleService;
import testgroup.dbService.UserService;
import testgroup.model.Role;
import testgroup.model.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;

	@RequestMapping(value = "/films", method = RequestMethod.GET)
	public ModelAndView allUsers(@ModelAttribute User user) {
		List<User> users = userService.getAllUsers();
		ModelAndView modelAndView = new ModelAndView();
		List<Role> roles = roleService.getAllRoles();
		modelAndView.addObject(user);
		List<Role> userRoles = user.getRoles();
		List<String> userRoles1 = new ArrayList<>();
		for (Role userRole : userRoles) {
			userRoles1.add(userRole.getType());
		}
		modelAndView.addObject("userroles", userRoles1);

		modelAndView.addObject("rolelist", roles);

		modelAndView.setViewName("films");
		modelAndView.addObject("usersList", users);
		return modelAndView;
	}


	@RequestMapping(value = "add", method = RequestMethod.GET)
	public ModelAndView addPage(@ModelAttribute User user) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("add");
		List<Role> roles = roleService.getAllRoles();
		modelAndView.addObject(user);
		modelAndView.addObject("rolelist", roles);
		return modelAndView;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute User user,
								@RequestParam(value = "role.type") String[] roles

	) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/admin/films");
		List<Role> roleSet = new ArrayList<>();
		for (String role : roles) {
			roleSet.add(roleService.getRole(role));
			System.out.println(role);
		}
		user.setRoles(roleSet);
		userService.addUser(user);
		return modelAndView;
	}

	@RequestMapping(value = "/edit/", method = RequestMethod.POST)
	public ModelAndView editUser(
								@RequestParam(value = "name") String name,
								 @RequestParam(value = "id") long id,
								 @RequestParam(value = "login") String login,
								 @RequestParam(value = "pass") String pass,
								 @RequestParam(value = "role.type") String[] roles
	) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/admin/films");

		User newUser = new User();
		newUser.setName(name);
		newUser.setLogin(login);
		newUser.setPass(pass);
		List<Role> roleSet = new ArrayList<>();
		for (String role : roles) {
			roleSet.add(roleService.getRole(role));
			System.out.println(role);
		}

		newUser.setRoles(roleSet);
		userService.updateUser(newUser, id);
		return modelAndView;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editPage(@PathVariable("id") int id) {
		User user = userService.getUser(id);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("edit");
		List<Role> roles = roleService.getAllRoles();
		List<Role> userRoles = user.getRoles();
		List<String> userRoles1 = new ArrayList<>();
		for (Role userRole : userRoles) {
			userRoles1.add(userRole.getType());
		}
		modelAndView.addObject("rolelist", roles);
		modelAndView.addObject("userroles", userRoles1);
		modelAndView.addObject("user", user);
		return modelAndView;
	}

	//
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteUser(@PathVariable("id") int id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/admin/films");
		User user = userService.getUser(id);
		userService.deleteUser(user.getId());

		return modelAndView;
	}
}
