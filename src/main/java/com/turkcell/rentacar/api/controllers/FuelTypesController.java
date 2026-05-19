package com.turkcell.rentacar.api.controllers;

import com.turkcell.rentacar.business.abstracts.FuelTypeService;
import com.turkcell.rentacar.entities.concretes.FuelType;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class FuelTypesController {

    private FuelTypeService fuelTypeService;

    @ResponseStatus(HttpStatus.FOUND)
    @GetMapping("/fueltypes/{id}")
    public FuelType getById(@PathVariable int id){
        return fuelTypeService.getById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/fueltypes")
    public FuelType add(@RequestBody FuelType fuelType){
        return fuelTypeService.add(fuelType);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/fueltypes/{id}")
    public FuelType update(@PathVariable int id,@RequestBody FuelType fuelType){
        return fuelTypeService.update(id, fuelType);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/fueltypes/{id}")
    public void delete(@PathVariable int id){
        fuelTypeService.delete(id);
    }
}
