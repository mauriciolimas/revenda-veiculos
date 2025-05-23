package com.github.mauriciolimas.vehicle_resale.infra.database.specifications;

import java.math.BigDecimal;

import org.springframework.data.jpa.domain.Specification;

public class CommonsSpecifications {

	public static <T> Specification<T> hasName(String name, String field) {
		return (root, query, criteriaBuilder) -> {
			if(name != null && !name.isEmpty()) {
				return criteriaBuilder.like(root.get(field), "%" + name + "%");
			}
			return criteriaBuilder.conjunction();
		};
	}
	
	public static <T> Specification<T> hasEnum(Enum<?> enumerator, String field) {
		return (root, query, criteriaBuilder) -> {
			if(enumerator != null) {
				return criteriaBuilder.equal(root.get(field), enumerator);
			}
			return criteriaBuilder.conjunction();
		};
	}
	
	public static <T> Specification<T> hasValueMin(Integer value, String field) {
		return (root, query, criteriaBuilder) -> {
			if(value != null) {
				return criteriaBuilder.greaterThanOrEqualTo(root.get(field), value);
			}
			return criteriaBuilder.conjunction();
		};
	}
	
	public static <T> Specification<T> hasValueMin(BigDecimal value, String field) {
		return (root, query, criteriaBuilder) -> {
			if(value != null) {
				return criteriaBuilder.greaterThanOrEqualTo(root.get(field), value);
			}
			return criteriaBuilder.conjunction();
		};
	}
	
	public static <T> Specification<T> hasValueMax(Integer value, String field) {
		return (root, query, criteriaBuilder) -> {
			if(value != null) {
				return criteriaBuilder.lessThanOrEqualTo(root.get(field), value);
			}
			return criteriaBuilder.conjunction();
		};
	}
	
	public static <T> Specification<T> hasValueMax(BigDecimal value, String field) {
		return (root, query, criteriaBuilder) -> {
			if(value != null) {
				return criteriaBuilder.lessThanOrEqualTo(root.get(field), value);
			}
			return criteriaBuilder.conjunction();
		};
	}
	
	public static <T> Specification<T> hasValue(String value, String field) {
		return (root, query, criteriaBuilder) -> {
			if(value != null && !value.isEmpty()) {
				return criteriaBuilder.equal(root.get(field), value);
			}
			return criteriaBuilder.conjunction();
		};
	}
}
