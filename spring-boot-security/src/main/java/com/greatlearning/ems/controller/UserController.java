package com.greatlearning.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.ems.entity.Employee;
import com.greatlearning.ems.entity.Role;
import com.greatlearning.ems.entity.User;
import com.greatlearning.ems.repository.UserRepository;
import com.greatlearning.ems.serviceImpl.UserImpl;


@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserImpl userService;

	@PostMapping("/addUser")
	public User addUser(User usr)
	{
		return userService.addUser(usr);
	}

	@PostMapping("/addRole")
	public Role addRole(Role role)
	{
		return userService.addRole(role);
	}
}
