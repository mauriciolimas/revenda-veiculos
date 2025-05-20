package com.github.mauriciolimas.vehicle_resale.core.usecase;

import com.github.mauriciolimas.vehicle_resale.core.exception.BusinessException;

public interface UseCase<Input, Output> {

	Output execute(Input input) throws BusinessException;
}
