package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.FuelTypeService;
import com.turkcell.rentacar.business.dtos.requests.fuelType.CreateFuelTypeRequest;
import com.turkcell.rentacar.business.dtos.requests.fuelType.UpdateFuelTypeRequest;
import com.turkcell.rentacar.business.dtos.responses.fuelType.CreatedFuelTypeResponse;
import com.turkcell.rentacar.business.dtos.responses.fuelType.GetFuelTypeResponse;
import com.turkcell.rentacar.business.dtos.responses.fuelType.UpdatedFuelTypeResponse;
import com.turkcell.rentacar.dataAccess.abstracts.FuelTypeRepository;
import com.turkcell.rentacar.entities.concretes.FuelType;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class FuelTypeManager implements FuelTypeService {

    private FuelTypeRepository fuelTypeRepository;

    @Transactional
    @Override
    public CreatedFuelTypeResponse add(CreateFuelTypeRequest createFuelTypeRequest) {
        FuelType fuelType = new FuelType();
        fuelType.setName(createFuelTypeRequest.getName());
        fuelType.setCreatedDate(LocalDateTime.now());

        FuelType createdFuelType = fuelTypeRepository.save(fuelType);

        CreatedFuelTypeResponse createdFuelTypeResponse = new CreatedFuelTypeResponse();
        createdFuelTypeResponse.setId(createdFuelType.getId());
        createdFuelTypeResponse.setName(createdFuelType.getName());
        createdFuelTypeResponse.setCreatedDate(createdFuelType.getCreatedDate());

        return createdFuelTypeResponse;
    }

    @Override
    public GetFuelTypeResponse getById(int id) {
        FuelType fuelType= fuelTypeRepository.findById(id).orElse(null);

        GetFuelTypeResponse getFuelTypeResponse = new GetFuelTypeResponse();
        getFuelTypeResponse.setId(fuelType.getId());
        getFuelTypeResponse.setName(fuelType.getName());
        getFuelTypeResponse.setCreatedDate(fuelType.getCreatedDate());
        getFuelTypeResponse.setUpdatedDate(fuelType.getUpdatedDate());

        return getFuelTypeResponse;
    }

    @Transactional
    @Override
    public UpdatedFuelTypeResponse update(int id, UpdateFuelTypeRequest updateFuelTypeRequest) {

        FuelType existingFuelType = fuelTypeRepository.findById(id).orElse(null);
        existingFuelType.setName(updateFuelTypeRequest.getName());
        existingFuelType.setUpdatedDate(LocalDateTime.now());

        FuelType updatedFuelType = fuelTypeRepository.save(existingFuelType);

        UpdatedFuelTypeResponse updatedFuelTypeResponse = new UpdatedFuelTypeResponse();
        updatedFuelTypeResponse.setId(updatedFuelType.getId());
        updatedFuelTypeResponse.setName(updatedFuelType.getName());
        updatedFuelTypeResponse.setUpdatedDate(updatedFuelType.getUpdatedDate());

        return updatedFuelTypeResponse;
    }

    @Transactional
    @Override
    public void delete(int id) {
        fuelTypeRepository.deleteById(id);
    }
}
