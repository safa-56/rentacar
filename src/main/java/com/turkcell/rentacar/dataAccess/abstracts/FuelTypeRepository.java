package com.turkcell.rentacar.dataAccess.abstracts;

import com.turkcell.rentacar.entities.concretes.FuelType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FuelTypeRepository extends JpaRepository<FuelType, Integer> {
    Optional<FuelType> findByNameIgnoreCase(String fuelTypeName);
    boolean existsByNameIgnoreCaseAndIdNot(String fuelTypeName, int fuelTypeId);
}
