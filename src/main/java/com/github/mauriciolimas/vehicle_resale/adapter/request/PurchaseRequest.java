package com.github.mauriciolimas.vehicle_resale.adapter.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record PurchaseRequest(@NotNull @NotBlank @Size(min = 10, max = 10) String code) {
}
