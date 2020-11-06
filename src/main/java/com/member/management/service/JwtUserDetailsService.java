package com.member.management.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.member.management.entity.CustomerData;
import com.member.management.repository.RegistrationServiceRepository;


@Service
public class JwtUserDetailsService implements UserDetailsService {
	

@Autowired
private RegistrationServiceRepository repository;

@Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

	CustomerData user = repository.findCustomerDataByUserName(username);
	if (user == null) {
		throw new UsernameNotFoundException("User not found with username: " + username);
	}
	return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
			new ArrayList<>());
	}
}
