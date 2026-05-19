package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.BrandService;
import com.turkcell.rentacar.dataAccess.abstracts.BrandRepository;
import com.turkcell.rentacar.entities.concretes.Brand;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class BrandManager implements BrandService {
    private BrandRepository brandRepository;

    @Transactional
    @Override
    public Brand add(Brand brand) {
        return brandRepository.save(brand);
    }

    @Override
    public Brand getById(int id) {
        return brandRepository.findById(id).get();
    }

    @Transactional
    @Override
    public void delete(int id) {
        brandRepository.deleteById(id);
    }

    @Transactional
    @Override
    public Brand update(int id, Brand brand) {

        Brand existingBrand =getById(id);

        existingBrand.setName(brand.getName());
        existingBrand.setUpdatedDate(brand.getUpdatedDate());
        existingBrand.setModelList(brand.getModelList());

        return brandRepository.save(existingBrand);
    }
}
