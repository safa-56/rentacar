package com.turkcell.rentacar.business.abstracts;

import com.turkcell.rentacar.business.dtos.requests.brand.CreateBrandRequest;
import com.turkcell.rentacar.business.dtos.requests.brand.UpdateBrandRequest;
import com.turkcell.rentacar.business.dtos.responses.brand.CreatedBrandResponse;
import com.turkcell.rentacar.business.dtos.responses.brand.GetBrandResponse;
import com.turkcell.rentacar.business.dtos.responses.brand.UpdatedBrandResponse;
import com.turkcell.rentacar.entities.concretes.Brand;

public interface BrandService {
    CreatedBrandResponse add(CreateBrandRequest createBrandRequest);
    GetBrandResponse getById(int id);
    UpdatedBrandResponse update(int id, UpdateBrandRequest updateBrandRequest);
    void delete(int id);
    Brand getBrandById(int id);
}
