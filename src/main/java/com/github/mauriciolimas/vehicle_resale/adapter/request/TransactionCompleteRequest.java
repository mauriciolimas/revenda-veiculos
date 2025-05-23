package com.github.mauriciolimas.vehicle_resale.adapter.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionCompleteRequest {

	private String code;
	private boolean completed;
}
