package testgroup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import testgroup.dbService.RoleService;
import testgroup.dbService.UserService;
import testgroup.model.Role;
import testgroup.model.User;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api/users")
public class RestController {
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;


	@RequestMapping(path = "{id}", method = RequestMethod.GET)
	public User getUser(@PathVariable(name = "id") long id) {
		return userService.getUser(id);
	}

	@GetMapping
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping("/roles")
	public List<Role> getAllRoles() {
		return roleService.getAllRoles();
	}
    @DeleteMapping(path = "{id}")
	public void deleteUser(@PathVariable(name = "id")long id) {
		userService.deleteUser(id);
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addUser(@RequestBody User user) {
		userService.addUser(user);
	}
//
	@PutMapping(path = "{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateUser(@PathVariable(name = "id") long id,@RequestBody User user) {
		userService.updateUser(user,id);
	}





}
