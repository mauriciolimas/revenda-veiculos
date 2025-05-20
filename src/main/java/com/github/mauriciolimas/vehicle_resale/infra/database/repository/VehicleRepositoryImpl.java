package com.github.mauriciolimas.vehicle_resale.infra.database.repository;

import static com.github.mauriciolimas.vehicle_resale.infra.database.specifications.CommonsSpecifications.hasEnum;
import static com.github.mauriciolimas.vehicle_resale.infra.database.specifications.CommonsSpecifications.hasName;
import static com.github.mauriciolimas.vehicle_resale.infra.database.specifications.CommonsSpecifications.hasValueMax;
import static com.github.mauriciolimas.vehicle_resale.infra.database.specifications.CommonsSpecifications.hasValueMin;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.github.mauriciolimas.vehicle_resale.core.entity.Vehicle;
import com.github.mauriciolimas.vehicle_resale.core.repository.VehicleRepository;
import com.github.mauriciolimas.vehicle_resale.core.valueobject.pagination.PageData;
import com.github.mauriciolimas.vehicle_resale.core.valueobject.pagination.Pageable;
import com.github.mauriciolimas.vehicle_resale.core.valueobject.vehicle.VehicleFilter;
import com.github.mauriciolimas.vehicle_resale.infra.database.jpa.entity.VehicleJpaEntity;
import com.github.mauriciolimas.vehicle_resale.infra.database.jpa.repository.VehicleJpaRepository;
import com.github.mauriciolimas.vehicle_resale.infra.database.mapper.VehicleJpaMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class VehicleRepositoryImpl implements VehicleRepository {

	private final VehicleJpaRepository repository;
	private final VehicleJpaMapper mapper;
	
	@Override
	public Optional<Vehicle> findByCode(String code) {
		Optional<VehicleJpaEntity> optional = repository.findById(code);
		return optional.isEmpty() ? Optional.empty() : Optional.of(mapper.toEntity(optional.get()));
	}

	@Override
	public Vehicle save(Vehicle vehicle) {
		VehicleJpaEntity entity = mapper.toJpaEntity(vehicle);
		repository.save(entity);
		return mapper.toEntity(entity);
	}

	@Override
	public PageData<Vehicle> list(VehicleFilter filter, Pageable pageable) {
		Specification<VehicleJpaEntity> spec = Specification
				.<VehicleJpaEntity>where(hasName(filter.getModel(), "model"))
				.and(hasName(filter.getBrand(), "brand"))
				.and(hasEnum(filter.getColor(), "color"))
				.and(hasEnum(filter.getStatus(), "status"))
				.and(hasValueMin(filter.getYearMin(), "year"))
				.and(hasValueMax(filter.getYearMax(), "year"))
				.and(hasValueMin(filter.getPriceMin(), "price"))
				.and(hasValueMax(filter.getPriceMax(), "price"));

		Page<VehicleJpaEntity> page = repository.findAll(spec, pageable.getPageRequest());
		return PageData.from(page.getContent().stream().map(mapper::toEntity).toList(), page);
	}

}
