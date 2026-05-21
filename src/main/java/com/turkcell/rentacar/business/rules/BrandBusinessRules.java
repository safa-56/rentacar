package com.turkcell.rentacar.business.rules;

import com.turkcell.rentacar.dataAccess.abstracts.BrandRepository;
import com.turkcell.rentacar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class BrandBusinessRules {
    private BrandRepository brandRepository;

    public void brandNameCanNotBeDuplicated(String brandName) {
        Optional<Brand> brand = this.brandRepository.findByNameIgnoreCase(brandName);
        if (brand.isPresent()) {
            throw new RuntimeException("Brand with name " + brandName + " already exists");
        }
    }

    public void brandIsExist(int brandId){
        Optional<Brand> brand = this.brandRepository.findById(brandId);
        if (brand.isEmpty()) {
            throw new RuntimeException("Brand with id " + brandId + " does not exist");
        }
    }

    public void brandNameCanNotBeDuplicatedForUpdate(String brandName, int brandId) {
        if (this.brandRepository.existsByNameIgnoreCaseAndIdNot(brandName, brandId)) {
            throw new RuntimeException("Brand with name " + brandName + " already exists");
        }
    }
}
