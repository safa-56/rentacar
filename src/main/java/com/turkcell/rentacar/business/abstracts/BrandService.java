package com.turkcell.rentacar.business.abstracts;

import com.turkcell.rentacar.business.dtos.requests.brand.CreateBrandRequest;
import com.turkcell.rentacar.business.dtos.requests.brand.UpdateBrandRequest;
import com.turkcell.rentacar.business.dtos.responses.brand.CreatedBrandResponse;
import com.turkcell.rentacar.business.dtos.responses.brand.GetBrandResponse;
import com.turkcell.rentacar.business.dtos.responses.brand.UpdatedBrandResponse;

public interface BrandService {
    CreatedBrandResponse add(CreateBrandRequest createBrandRequest);
    GetBrandResponse getById(int id);
    void delete(int id);
    UpdatedBrandResponse update(int id, UpdateBrandRequest updateBrandRequest);
}
