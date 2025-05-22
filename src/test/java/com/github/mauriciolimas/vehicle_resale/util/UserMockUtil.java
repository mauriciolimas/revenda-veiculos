package com.github.mauriciolimas.vehicle_resale.util;

import java.util.UUID;

import com.github.mauriciolimas.vehicle_resale.core.valueobject.authentication.User;

public class UserMockUtil {

	public static User user() {
		return new User(UUID.randomUUID().toString(), "Samara Morgan", "samara.morgan@gmai.com");
	}

}
