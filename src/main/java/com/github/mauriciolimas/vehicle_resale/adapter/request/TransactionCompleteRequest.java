package com.github.mauriciolimas.vehicle_resale.adapter.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionCompleteRequest {

	@NotNull
	@NotBlank
	@Size(min = 36, max = 36)
	private String code;
	
	@NotNull
	private boolean completed;
}
