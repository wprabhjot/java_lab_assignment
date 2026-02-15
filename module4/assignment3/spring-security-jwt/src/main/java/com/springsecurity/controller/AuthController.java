package com.springsecurity.controller;

import com.springsecurity.config.JwtService;
import com.springsecurity.dto.AuthRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

	@Autowired
	private JwtService jwtService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping("/authenticate")
	public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));

		if (authentication.isAuthenticated()) {
			UserDetails userDetails = (UserDetails) authentication.getPrincipal();
			return jwtService.generateToken(userDetails);
		} else {
			throw new UsernameNotFoundException("Invalid user request !");
		}
	}
}