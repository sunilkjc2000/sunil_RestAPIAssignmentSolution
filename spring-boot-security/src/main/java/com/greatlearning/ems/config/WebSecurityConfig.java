package com.greatlearning.ems.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.greatlearning.ems.serviceImpl.UserDetailsServiceImpl;


// This class will be annotated with Configuration and all the beans will be defined here
// We will make use of WebSecurityConfigurerAdapter to ensure that the right people have access to the right pages
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailsServiceImpl();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());

		return authProvider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/","/employees/getEmployee","/employees/listEmployees","/employees/searchByFirstname","/employees/sortByFirstName").hasAnyAuthority("USER","ADMIN")
		.antMatchers("/employees/deleteEmployee","/employees/updateEmployee","/employees/addEmployee","/users/addUser").hasAuthority("ADMIN")
		.antMatchers("/h2-console/**").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin().loginProcessingUrl("/login").permitAll()
		.and()
		.logout().logoutSuccessUrl("/login").permitAll()
		.and()
		.cors().and().csrf().disable();

		http.csrf().disable();
		http.headers().frameOptions().disable();
	}

}