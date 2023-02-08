package com.jacaranda.miPrimeraApiClase.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jacaranda.miPrimeraApiClase.model.Users;
import com.jacaranda.miPrimeraApiClase.security.JwtUtils;
import com.jacaranda.miPrimeraApiClase.security.LoginCredential;

@RestController
public class AuthController {
// Declaramos un objeto de la clae AuthenticationManager
// https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/authentication/AuthenticationManager.html
	@Autowired
	AuthenticationManager authenticationManager;
	
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@RequestBody LoginCredential loginRequest) {
		//Si el usuario y el password que le paso son los adecuados me devuele unautentication
		Authentication authentication = authenticationManager.authenticate(
		new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),loginRequest.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		Users user = (Users)authentication.getPrincipal();
		String jwt = JwtUtils.generateToken(loginRequest.getUsername(), user.getEmail(),
				user.getRole());

	Users userDetails = (Users) authentication.getPrincipal();
	List<String> roles = userDetails.getAuthorities().stream().map(item ->
	item.getAuthority())
	.collect(Collectors.toList());
	return ResponseEntity.ok(jwt);
	}
}