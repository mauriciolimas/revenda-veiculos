package com.github.mauriciolimas.vehicle_resale.infra.security;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@NoArgsConstructor
public class CustomJwtGrantedAuthoritiesConverter implements Converter<Jwt, Collection<GrantedAuthority>> {

	private String authoritiesClaimName = "groups";
	
	@Override
	public Collection<GrantedAuthority> convert(Jwt jwt) {
		List<String> groups = jwt.getClaimAsStringList(authoritiesClaimName);
		return groups.stream().map(group -> new SimpleGrantedAuthority("ROLE_" + group.toUpperCase())).collect(Collectors.toList());
	}

}
