package com.github.mauriciolimas.vehicle_resale.application.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Service;

import com.github.mauriciolimas.vehicle_resale.core.service.AuthenticationService;
import com.github.mauriciolimas.vehicle_resale.core.valueobject.authentication.User;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

	@Override
	public User getAuthenticatedUser() {
		Jwt jwt = getJwt();
		return new User(jwt.getSubject(), jwt.getClaimAsString("name"), jwt.getClaimAsString("email"));
	}
	
	private Jwt getJwt() {
		JwtAuthenticationToken jwt = (JwtAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
		return jwt.getToken();
	}

}
