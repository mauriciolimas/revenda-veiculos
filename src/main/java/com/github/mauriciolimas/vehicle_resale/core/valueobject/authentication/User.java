package com.github.mauriciolimas.vehicle_resale.core.valueobject.authentication;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

	private String id;
	private String name;
	private String email;
	
}
