package com.greatlearning.ems.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.greatlearning.ems.entity.User;
import com.greatlearning.ems.repository.UserRepository;
import com.greatlearning.ems.security.MyUserDetails;

public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired 
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User usr = userRepository.getUserByUserName(username);
		if(usr == null) {
			throw new UsernameNotFoundException("Could not find usr");
		}
		return new MyUserDetails(usr);
	}

}
