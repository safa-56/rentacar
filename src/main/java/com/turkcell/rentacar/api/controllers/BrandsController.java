package com.turkcell.rentacar.api.controllers;

import com.turkcell.rentacar.business.abstracts.BrandService;
import com.turkcell.rentacar.business.dtos.requests.brand.CreateBrandRequest;
import com.turkcell.rentacar.business.dtos.requests.brand.UpdateBrandRequest;
import com.turkcell.rentacar.business.dtos.responses.brand.CreatedBrandResponse;
import com.turkcell.rentacar.business.dtos.responses.brand.GetBrandResponse;
import com.turkcell.rentacar.business.dtos.responses.brand.UpdatedBrandResponse;
import com.turkcell.rentacar.entities.concretes.Brand;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1")
public class BrandsController {
    private BrandService brandService;

    @PostMapping("/brands")
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedBrandResponse add(@Valid @RequestBody CreateBrandRequest createBrandRequest) {
        return brandService.add(createBrandRequest);
    }

    @GetMapping("/brands/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetBrandResponse getById(@PathVariable int id) {
        return brandService.getById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/brands/{id}")
    public UpdatedBrandResponse update(@PathVariable int id,@Valid @RequestBody UpdateBrandRequest updateBrandRequest) {
        return brandService.update(id, updateBrandRequest);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/brands/{id}")
    public void delete(@PathVariable int id) {
        brandService.delete(id);
    }
}
