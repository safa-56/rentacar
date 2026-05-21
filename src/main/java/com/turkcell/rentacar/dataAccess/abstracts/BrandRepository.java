package com.turkcell.rentacar.dataAccess.abstracts;

import com.turkcell.rentacar.entities.concretes.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
    Optional<Brand> findByNameIgnoreCase(String brandName);
    boolean existsByNameIgnoreCaseAndIdNot(String brandName, int brandId); // aynı isimde farklı idye sahip kayıt var mı?
}