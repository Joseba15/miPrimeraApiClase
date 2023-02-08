package com.jacaranda.miPrimeraApiClase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jacaranda.miPrimeraApiClase.model.Users;
import com.jacaranda.miPrimeraApiClase.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {
	    
		@Autowired
	    UserRepository repository;
	    
	    @Override
		public UserDetails loadUserByUsername(String username) throws
		UsernameNotFoundException {
			Users user = repository.findById(username).orElse(null);
			if (user == null) {
				throw new UsernameNotFoundException("User not found");
			}
				return user;
			}
	    
	    
}


