package com.turkcell.rentacar.business.abstracts;

import com.turkcell.rentacar.entities.concretes.FuelType;

public interface FuelTypeService {
    FuelType getById(int id);
    FuelType add(FuelType fuelType);
    FuelType update(int id,FuelType fuelType);
    void delete(int id);
}
