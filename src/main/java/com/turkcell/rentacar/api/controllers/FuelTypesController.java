package com.turkcell.rentacar.api.controllers;

import com.turkcell.rentacar.business.abstracts.FuelTypeService;
import com.turkcell.rentacar.business.dtos.requests.fuelType.CreateFuelTypeRequest;
import com.turkcell.rentacar.business.dtos.requests.fuelType.UpdateFuelTypeRequest;
import com.turkcell.rentacar.business.dtos.responses.fuelType.CreatedFuelTypeResponse;
import com.turkcell.rentacar.business.dtos.responses.fuelType.GetFuelTypeResponse;
import com.turkcell.rentacar.business.dtos.responses.fuelType.UpdatedFuelTypeResponse;
import com.turkcell.rentacar.entities.concretes.FuelType;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class FuelTypesController {

    private FuelTypeService fuelTypeService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/fueltypes")
    public CreatedFuelTypeResponse add(@Valid @RequestBody CreateFuelTypeRequest createFuelTypeRequest){
        return fuelTypeService.add(createFuelTypeRequest);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/fueltypes/{id}")
    public GetFuelTypeResponse getById(@PathVariable int id){
        return fuelTypeService.getById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/fueltypes/{id}")
    public UpdatedFuelTypeResponse update(@PathVariable int id, @Valid @RequestBody UpdateFuelTypeRequest updateFuelTypeRequest){
        return fuelTypeService.update(id, updateFuelTypeRequest);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/fueltypes/{id}")
    public void delete(@PathVariable int id){
        fuelTypeService.delete(id);
    }
}
