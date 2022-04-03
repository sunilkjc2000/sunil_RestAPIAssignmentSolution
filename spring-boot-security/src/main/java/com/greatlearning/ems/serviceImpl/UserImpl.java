package com.greatlearning.ems.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.greatlearning.ems.entity.Employee;
import com.greatlearning.ems.entity.Role;
import com.greatlearning.ems.entity.User;
import com.greatlearning.ems.repository.RoleRepository;
import com.greatlearning.ems.repository.UserRepository;
import com.greatlearning.ems.config.WebSecurityConfig;

@Service
public class UserImpl {

	@Autowired 
	UserRepository userrepository;

	@Autowired 
	RoleRepository rolerepository;

	public User addUser(User user) {
		String password = user.getPassword();
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(password));
		userrepository.save(user);
		userrepository.flush();
		return user;
	}

	public Role addRole(Role role)
	{
		rolerepository.save(role);
		return role;
	}

}
