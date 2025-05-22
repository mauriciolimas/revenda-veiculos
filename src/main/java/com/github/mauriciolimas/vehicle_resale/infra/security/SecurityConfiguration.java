package com.github.mauriciolimas.vehicle_resale.infra.security;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true, prePostEnabled = true, jsr250Enabled = true)
public class SecurityConfiguration {

	@Value("${app.security.routes.permited-all}")
	private String routesPermited;

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http.oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults())).cors(cors -> cors.disable())
				.csrf(csrf -> csrf.disable())
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authorizeHttpRequests((authorize) -> authorize.requestMatchers(permitedAll()).permitAll().anyRequest()
						.authenticated())
				.build();
	}
	
	@Bean
	JwtAuthenticationConverter customJwtAuthenticationConverter() {
		JwtAuthenticationConverter converter = new JwtAuthenticationConverter();
		converter.setJwtGrantedAuthoritiesConverter(new CustomJwtGrantedAuthoritiesConverter());
		return converter;
	}
	
	private String[] permitedAll() {
		if(this.routesPermited == null || this.routesPermited.isEmpty()) {
			return new String[] {};
		}
		String[] routes = this.routesPermited.split(",");
		Stream.of(routes).forEach(route -> log.debug("Route {} permited without authentication", route));
		return routes;
	}
}
