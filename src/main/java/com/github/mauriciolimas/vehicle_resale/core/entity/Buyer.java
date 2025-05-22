package com.github.mauriciolimas.vehicle_resale.core.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Buyer {

	private String id;
	private String name;
	private String email;
	
}
