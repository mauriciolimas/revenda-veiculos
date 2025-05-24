package com.github.mauriciolimas.vehicle_resale.infra.configuration.openapi;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.OAuthFlow;
import io.swagger.v3.oas.annotations.security.OAuthFlows;
import io.swagger.v3.oas.annotations.security.OAuthScope;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@Configuration
@OpenAPIDefinition(
    info = @Info(title = "API Revenda", version = "v1"),
    security = @SecurityRequirement(name = "bearerAuth")
)
@SecurityScheme(
	    name = "keycloak",
	    type = SecuritySchemeType.OAUTH2,
	    in = SecuritySchemeIn.HEADER,
	    scheme = "bearer",
	    bearerFormat = "JWT",
	    flows = @OAuthFlows(
	        password = @OAuthFlow(
	            tokenUrl = "http://localhost:8080/realms/revenda/protocol/openid-connect/token",
	            scopes = {
	                @OAuthScope(name = "profile", description = "Acesso ao perfil")
	            }
	        )
	    )
	)
public class OpenApiConfiguration {

}
