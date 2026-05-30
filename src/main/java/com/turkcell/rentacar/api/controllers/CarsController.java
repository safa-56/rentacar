package com.turkcell.rentacar.api.controllers;

import com.turkcell.rentacar.business.abstracts.CarService;
import com.turkcell.rentacar.business.dtos.requests.car.CreateCarRequest;
import com.turkcell.rentacar.business.dtos.requests.car.UpdateCarRequest;
import com.turkcell.rentacar.business.dtos.responses.car.CreatedCarResponse;
import com.turkcell.rentacar.business.dtos.responses.car.GetCarResponse;
import com.turkcell.rentacar.business.dtos.responses.car.UpdatedCarResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class CarsController {
    private CarService carService;

    @PostMapping("/cars")
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedCarResponse add(@Valid @RequestBody CreateCarRequest createCarRequest){
        return carService.add(createCarRequest);
    }

    @GetMapping("/cars/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetCarResponse getById(@PathVariable int id){
        return carService.getById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/cars/{id}")
    public UpdatedCarResponse update(@PathVariable int id,@Valid @RequestBody UpdateCarRequest updateCarRequest){
        return carService.update(id,updateCarRequest);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/cars/{id}")
    public void delete(@PathVariable int id){
        carService.delete(id);
    }
}
