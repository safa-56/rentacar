package com.turkcell.rentacar.business.abstracts;

import com.turkcell.rentacar.business.dtos.requests.fuelType.CreateFuelTypeRequest;
import com.turkcell.rentacar.business.dtos.requests.fuelType.UpdateFuelTypeRequest;
import com.turkcell.rentacar.business.dtos.responses.fuelType.CreatedFuelTypeResponse;
import com.turkcell.rentacar.business.dtos.responses.fuelType.GetFuelTypeResponse;
import com.turkcell.rentacar.business.dtos.responses.fuelType.UpdatedFuelTypeResponse;
import com.turkcell.rentacar.entities.concretes.FuelType;

public interface FuelTypeService {
    CreatedFuelTypeResponse add(CreateFuelTypeRequest createFuelTypeRequest);
    GetFuelTypeResponse getById(int id);
    UpdatedFuelTypeResponse update(int id, UpdateFuelTypeRequest updateFuelTypeRequest);
    void delete(int id);
    FuelType getFuelTypeById(int id);
}
