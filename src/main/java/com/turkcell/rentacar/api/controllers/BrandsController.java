package com.turkcell.rentacar.api.controllers;

import com.turkcell.rentacar.business.abstracts.BrandService;
import com.turkcell.rentacar.entities.concretes.Brand;
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
    public Brand add(@RequestBody Brand brand) {
        return brandService.add(brand);
    }

    @GetMapping("/brands/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Brand getById(@PathVariable int id) {
        return brandService.getById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/brands/{id}")
    public Brand update(@PathVariable int id,@RequestBody Brand brand) {
        return brandService.update(id, brand);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/brands/{id}")
    public void delete(@PathVariable int id) {
        brandService.delete(id);
    }
}
