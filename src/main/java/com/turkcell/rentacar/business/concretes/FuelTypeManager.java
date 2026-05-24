package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.FuelTypeService;
import com.turkcell.rentacar.business.dtos.requests.fuelType.CreateFuelTypeRequest;
import com.turkcell.rentacar.business.dtos.requests.fuelType.UpdateFuelTypeRequest;
import com.turkcell.rentacar.business.dtos.responses.fuelType.CreatedFuelTypeResponse;
import com.turkcell.rentacar.business.dtos.responses.fuelType.GetFuelTypeResponse;
import com.turkcell.rentacar.business.dtos.responses.fuelType.UpdatedFuelTypeResponse;
import com.turkcell.rentacar.business.rules.FuelTypeBusinessRules;
import com.turkcell.rentacar.core.utilities.mapping.ModelMapperService;
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
    private FuelTypeBusinessRules fuelTypeBusinessRules;
    private ModelMapperService modelMapperService;

    @Transactional
    @Override
    public CreatedFuelTypeResponse add(CreateFuelTypeRequest createFuelTypeRequest) {
        this.fuelTypeBusinessRules.fuelTypeNameCanNotBeDuplicated(createFuelTypeRequest.getName());

//        FuelType fuelType = new FuelType();
//        fuelType.setName(createFuelTypeRequest.getName());
        FuelType fuelType = this.modelMapperService.forRequest().map(createFuelTypeRequest,FuelType.class);
        fuelType.setCreatedDate(LocalDateTime.now());

        FuelType createdFuelType = fuelTypeRepository.save(fuelType);

//        CreatedFuelTypeResponse createdFuelTypeResponse = new CreatedFuelTypeResponse();
//        createdFuelTypeResponse.setId(createdFuelType.getId());
//        createdFuelTypeResponse.setName(createdFuelType.getName());
//        createdFuelTypeResponse.setCreatedDate(createdFuelType.getCreatedDate());
        CreatedFuelTypeResponse createdFuelTypeResponse = this.modelMapperService.forResponse().map(createdFuelType,CreatedFuelTypeResponse.class);

        return createdFuelTypeResponse;
    }

    @Override
    public GetFuelTypeResponse getById(int id) {
        FuelType fuelType = this.fuelTypeBusinessRules.fuelTypeIsExist(id);

//        GetFuelTypeResponse getFuelTypeResponse = new GetFuelTypeResponse();
//        getFuelTypeResponse.setId(fuelType.getId());
//        getFuelTypeResponse.setName(fuelType.getName());
//        getFuelTypeResponse.setCreatedDate(fuelType.getCreatedDate());
//        getFuelTypeResponse.setUpdatedDate(fuelType.getUpdatedDate());
        GetFuelTypeResponse getFuelTypeResponse = this.modelMapperService.forResponse().map(fuelType,GetFuelTypeResponse.class);

        return getFuelTypeResponse;
    }

    @Transactional
    @Override
    public UpdatedFuelTypeResponse update(int id, UpdateFuelTypeRequest updateFuelTypeRequest) {
        FuelType existingFuelType = this.fuelTypeBusinessRules.fuelTypeIsExist(id);
        this.fuelTypeBusinessRules.fuelTypeNameCanNotBeDuplicatedForUpdate(updateFuelTypeRequest.getName(),id);

        this.modelMapperService.forRequest().map(updateFuelTypeRequest,existingFuelType);
        existingFuelType.setUpdatedDate(LocalDateTime.now());

        FuelType updatedFuelType = fuelTypeRepository.save(existingFuelType);

//        UpdatedFuelTypeResponse updatedFuelTypeResponse = new UpdatedFuelTypeResponse();
//        updatedFuelTypeResponse.setId(updatedFuelType.getId());
//        updatedFuelTypeResponse.setName(updatedFuelType.getName());
//        updatedFuelTypeResponse.setUpdatedDate(updatedFuelType.getUpdatedDate());
        UpdatedFuelTypeResponse updatedFuelTypeResponse = this.modelMapperService.forResponse().map(updatedFuelType,UpdatedFuelTypeResponse.class);

        return updatedFuelTypeResponse;
    }

    @Transactional
    @Override
    public void delete(int id) {
        FuelType fuelType = this.fuelTypeBusinessRules.fuelTypeIsExist(id);
        fuelTypeRepository.delete(fuelType);
    }

    @Override
    public FuelType getFuelTypeById(int id) {
        FuelType fuelType = this.fuelTypeBusinessRules.fuelTypeIsExist(id);
        return fuelType;
    }
}
