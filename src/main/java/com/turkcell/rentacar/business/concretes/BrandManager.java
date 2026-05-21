package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.BrandService;
import com.turkcell.rentacar.business.dtos.requests.brand.CreateBrandRequest;
import com.turkcell.rentacar.business.dtos.requests.brand.UpdateBrandRequest;
import com.turkcell.rentacar.business.dtos.responses.brand.CreatedBrandResponse;
import com.turkcell.rentacar.business.dtos.responses.brand.GetBrandResponse;
import com.turkcell.rentacar.business.dtos.responses.brand.UpdatedBrandResponse;
import com.turkcell.rentacar.business.rules.BrandBusinessRules;
import com.turkcell.rentacar.core.utilities.mapping.ModelMapperService;
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
    private ModelMapperService modelMapperService;
    private BrandBusinessRules brandBusinessRules;

    @Transactional
    @Override
    public CreatedBrandResponse add(CreateBrandRequest createBrandRequest) {
        this.brandBusinessRules.brandNameCanNotBeDuplicated(createBrandRequest.getName());
// Manuel mapleme için
//        Brand brand = new Brand();
//        brand.setName(createBrandRequest.getName());
        Brand brand = this.modelMapperService.forRequest().map(createBrandRequest,Brand.class);
        brand.setCreatedDate(LocalDateTime.now());

        Brand createdBrand = brandRepository.save(brand);
// Manuel mapleme için
//        CreatedBrandResponse createdBrandResponse = new CreatedBrandResponse();
//        createdBrandResponse.setId(createdBrand.getId());
//        createdBrandResponse.setName(createdBrand.getName());
//        createdBrandResponse.setCreatedDate(createdBrand.getCreatedDate());

        CreatedBrandResponse createdBrandResponse = this.modelMapperService.forResponse().map(createdBrand,CreatedBrandResponse.class);

        return createdBrandResponse;
    }

    @Override
    public GetBrandResponse getById(int id) {
        this.brandBusinessRules.brandIsExist(id);

        Brand brand = brandRepository.findById(id).get();

//        GetBrandResponse getBrandResponse = new GetBrandResponse();
//        getBrandResponse.setId(brand.getId());
//        getBrandResponse.setName(brand.getName());
//        getBrandResponse.setCreatedDate(brand.getCreatedDate());
//        getBrandResponse.setUpdatedDate(brand.getUpdatedDate());
        GetBrandResponse getBrandResponse = this.modelMapperService.forResponse().map(brand, GetBrandResponse.class);

        return getBrandResponse;
    }

    @Transactional
    @Override
    public UpdatedBrandResponse update(int id, UpdateBrandRequest updateBrandRequest) {
        this.brandBusinessRules.brandIsExist(id);
        this.brandBusinessRules.brandNameCanNotBeDuplicatedForUpdate(updateBrandRequest.getName(),id);

        Brand existingBrand = brandRepository.findById(id).get();
        modelMapperService.forRequest().map(updateBrandRequest,existingBrand);
        //existingBrand.setName(updateBrandRequest.getName());
        existingBrand.setUpdatedDate(LocalDateTime.now());

        Brand updatedBrand = brandRepository.save(existingBrand);

//        UpdatedBrandResponse updatedBrandResponse = new UpdatedBrandResponse();
//        updatedBrandResponse.setId(updatedBrand.getId());
//        updatedBrandResponse.setName(updatedBrand.getName());
//        updatedBrandResponse.setUpdatedDate(LocalDateTime.now());
        UpdatedBrandResponse updatedBrandResponse = modelMapperService.forResponse().map(updatedBrand,UpdatedBrandResponse.class);

        return updatedBrandResponse;
    }

    @Transactional
    @Override
    public void delete(int id) {
        this.brandBusinessRules.brandIsExist(id);
        brandRepository.deleteById(id);
    }

    @Override
    public Brand getBrandById(int id) {
        brandBusinessRules.brandIsExist(id);
        return brandRepository.findById(id).get();
    }
}
