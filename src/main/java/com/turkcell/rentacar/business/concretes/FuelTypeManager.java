package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.FuelTypeService;
import com.turkcell.rentacar.dataAccess.abstracts.FuelTypeRepository;
import com.turkcell.rentacar.entities.concretes.FuelType;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class FuelTypeManager implements FuelTypeService {

    private FuelTypeRepository fuelTypeRepository;

    @Override
    public FuelType getById(int id) {
        return fuelTypeRepository.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public FuelType add(FuelType fuelType) {
        return fuelTypeRepository.save(fuelType);
    }

    @Transactional
    @Override
    public FuelType update(int id, FuelType fuelType) {
        FuelType oldFuelType = getById(id);

        oldFuelType.setName(fuelType.getName());
        oldFuelType.setUpdatedDate(fuelType.getUpdatedDate());
        oldFuelType.setModelList(fuelType.getModelList());

        return fuelTypeRepository.save(fuelType);
    }

    @Transactional
    @Override
    public void delete(int id) {
        fuelTypeRepository.deleteById(id);
    }
}
