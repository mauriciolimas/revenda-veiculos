package com.github.mauriciolimas.vehicle_resale.core.service;

import com.github.mauriciolimas.vehicle_resale.core.valueobject.authentication.User;

public interface AuthenticationService {

	User getAuthenticatedUser();
}
