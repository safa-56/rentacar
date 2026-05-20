package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.BrandService;
import com.turkcell.rentacar.business.dtos.requests.brand.CreateBrandRequest;
import com.turkcell.rentacar.business.dtos.requests.brand.UpdateBrandRequest;
import com.turkcell.rentacar.business.dtos.responses.brand.CreatedBrandResponse;
import com.turkcell.rentacar.business.dtos.responses.brand.GetBrandResponse;
import com.turkcell.rentacar.business.dtos.responses.brand.UpdatedBrandResponse;
import com.turkcell.rentacar.dataAccess.abstracts.BrandRepository;
import com.turkcell.rentacar.entities.concretes.Brand;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class BrandManager implements BrandService {
    private BrandRepository brandRepository;

    @Transactional
    @Override
    public CreatedBrandResponse add(CreateBrandRequest createBrandRequest) {
        Brand brand = new Brand();
        brand.setName(createBrandRequest.getName());
        brand.setCreatedDate(LocalDateTime.now());

        Brand createdBrand = brandRepository.save(brand);

        CreatedBrandResponse createdBrandResponse = new CreatedBrandResponse();
        createdBrandResponse.setId(createdBrand.getId());
        createdBrandResponse.setName(createdBrand.getName());
        createdBrandResponse.setCreatedDate(createdBrand.getCreatedDate());

        return createdBrandResponse;
    }

    @Override
    public GetBrandResponse getById(int id) {

        Brand brand = brandRepository.findById(id).orElse(null);

        GetBrandResponse getBrandResponse = new GetBrandResponse();
        getBrandResponse.setId(brand.getId());
        getBrandResponse.setName(brand.getName());
        getBrandResponse.setCreatedDate(brand.getCreatedDate());
        getBrandResponse.setUpdatedDate(brand.getUpdatedDate());

        return getBrandResponse;
    }

    @Transactional
    @Override
    public UpdatedBrandResponse update(int id, UpdateBrandRequest updateBrandRequest) {

        Brand existingBrand = brandRepository.findById(id).orElse(null);
        existingBrand.setName(updateBrandRequest.getName());
        existingBrand.setUpdatedDate(LocalDateTime.now());

        Brand updatedBrand = brandRepository.save(existingBrand);

        UpdatedBrandResponse updatedBrandResponse = new UpdatedBrandResponse();
        updatedBrandResponse.setId(updatedBrand.getId());
        updatedBrandResponse.setName(updatedBrand.getName());
        updatedBrandResponse.setUpdatedDate(LocalDateTime.now());

        return updatedBrandResponse;
    }

    @Override
    public Brand getBrandById(int id) {
        return brandRepository.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(int id) {
        brandRepository.deleteById(id);
    }
}
