package com.turkcell.rentacar.dataAccess.abstracts;

import com.turkcell.rentacar.entities.concretes.FuelType;
import com.turkcell.rentacar.entities.concretes.Transmission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TransmissionsRepository extends JpaRepository<Transmission, Integer> {
    Optional<Transmission> findByNameIgnoreCase(String transmissionName);
    boolean existsByNameIgnoreCaseAndIdNot(String transmissionName,int transmissionId);
}
