package com.springdemo.rest;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.springdemo.rest.model.Manager;
import com.springdemo.rest.model.ManagerRepository;

@Component
public class SpringDataJpaUserDetailsService implements UserDetailsService {
	
	private final ManagerRepository repository;
	
	public SpringDataJpaUserDetailsService(ManagerRepository repository) {
		this.repository = repository;
	}

	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		Manager manager = this.repository.findByName(name);
		return new User(manager.getName(), manager.getPassword(), 
				AuthorityUtils.createAuthorityList(manager.getRoles()));
	}
}
