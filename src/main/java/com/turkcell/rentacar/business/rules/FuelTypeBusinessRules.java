package com.turkcell.rentacar.business.rules;

import com.turkcell.rentacar.dataAccess.abstracts.FuelTypeRepository;
import com.turkcell.rentacar.entities.concretes.FuelType;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class FuelTypeBusinessRules {
    private FuelTypeRepository  fuelTypeRepository;

    public void fuelTypeNameCanNotBeDuplicated(String fuelTypeName){
        Optional<FuelType> fuelType = fuelTypeRepository.findByNameIgnoreCase(fuelTypeName);
        if (fuelType.isPresent()){
            throw new RuntimeException("FuelType with name " + fuelTypeName + " already exists");
        }
    }

    public void fuelTypeIsExist(int fuelTypeId) {
        Optional<FuelType> fuelType = fuelTypeRepository.findById(fuelTypeId);
        if (fuelType.isEmpty()){
            throw new RuntimeException("FuelType with id " + fuelTypeId + " does not exist");
        }
    }

    public void fuelTypeNameCanNotBeDuplicatedForUpdate(String fuelTypeName,int fuelTypeId){
        if (fuelTypeRepository.existsByNameIgnoreCaseAndIdNot(fuelTypeName, fuelTypeId)){
            throw new RuntimeException("FuelType with name " + fuelTypeName + " already exists");
        }
    }
}
