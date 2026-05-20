package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.BrandService;
import com.turkcell.rentacar.business.abstracts.FuelTypeService;
import com.turkcell.rentacar.business.abstracts.ModelService;
import com.turkcell.rentacar.business.abstracts.TransmissionService;
import com.turkcell.rentacar.business.dtos.requests.model.CreateModelRequest;
import com.turkcell.rentacar.business.dtos.requests.model.UpdateModelRequest;
import com.turkcell.rentacar.business.dtos.responses.model.CreatedModelResponse;
import com.turkcell.rentacar.business.dtos.responses.model.GetModelResponse;
import com.turkcell.rentacar.business.dtos.responses.model.UpdatedModelResponse;
import com.turkcell.rentacar.dataAccess.abstracts.ModelRepository;
import com.turkcell.rentacar.entities.concretes.Brand;
import com.turkcell.rentacar.entities.concretes.FuelType;
import com.turkcell.rentacar.entities.concretes.Model;
import com.turkcell.rentacar.entities.concretes.Transmission;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class ModelManager implements ModelService {

    private ModelRepository modelRepository;
    private BrandService brandService;
    private TransmissionService transmissionService;
    private FuelTypeService fuelTypeService;

    @Transactional
    @Override
    public CreatedModelResponse add(CreateModelRequest createModelRequest) {
        Brand brand = brandService.getBrandById(createModelRequest.getBrandId());
        FuelType fuelType = fuelTypeService.getFuelTypeById(createModelRequest.getFuelTypeId());
        Transmission transmission = transmissionService.getTransmissionById(createModelRequest.getTransmissionId());

        Model model = new Model();
        model.setBrand(brand);
        model.setFuelType(fuelType);
        model.setTransmission(transmission);
        model.setName(createModelRequest.getName());
        model.setCreatedDate(LocalDateTime.now());

        Model createdModel = modelRepository.save(model);

        CreatedModelResponse createdModelResponse = new CreatedModelResponse();
        createdModelResponse.setId(createdModel.getId());
        createdModelResponse.setCreatedDate(createdModel.getCreatedDate());
        createdModelResponse.setName(createdModel.getName());
        createdModelResponse.setBrandName(brand.getName());
        createdModelResponse.setFuelTypeName(fuelType.getName());
        createdModelResponse.setTransmissionName(transmission.getName());

        return createdModelResponse;
    }

    @Override
    public GetModelResponse getById(int id) {
        Model existModel = modelRepository.findById(id).orElse(null);

        GetModelResponse getModelResponse = new GetModelResponse();
        getModelResponse.setId(existModel.getId());
        getModelResponse.setName(existModel.getName());
        getModelResponse.setBrandName(existModel.getBrand().getName());
        getModelResponse.setFuelTypeName(existModel.getFuelType().getName());
        getModelResponse.setTransmissionName(existModel.getTransmission().getName());
        getModelResponse.setCreatedDate(existModel.getCreatedDate());
        getModelResponse.setUpdatedDate(existModel.getUpdatedDate());

        return getModelResponse;
    }

    @Transactional
    @Override
    public UpdatedModelResponse update(int id, UpdateModelRequest updateModelRequest) {
        Model oldModel = modelRepository.findById(id).orElse(null);

        updateBrandIfExists(oldModel, updateModelRequest.getBrandId());
        updateFuelTypeIfExists(oldModel, updateModelRequest.getFuelTypeId());
        updateTransmissionIfExists(oldModel, updateModelRequest.getTransmissionId());
        updateModelNameIfExists(oldModel, updateModelRequest.getName());
        oldModel.setUpdatedDate(LocalDateTime.now());

        Model updatedModel =  modelRepository.save(oldModel);

        UpdatedModelResponse updatedModelResponse = new UpdatedModelResponse();

        updatedModelResponse.setName(updatedModel.getName());
        updatedModelResponse.setBrandName(updatedModel.getBrand().getName());
        updatedModelResponse.setFuelTypeName(updatedModel.getFuelType().getName());
        updatedModelResponse.setTransmissionName(updatedModel.getTransmission().getName());
        updatedModelResponse.setUpdatedDate(updatedModel.getUpdatedDate());

        return updatedModelResponse;
    }

    @Transactional
    @Override
    public void delete(int id) {
        modelRepository.deleteById(id);
    }

    // değerlerin güncellenip güncellenmediğini kontrol ederler
    private void updateBrandIfExists(Model model, Integer brandId) {
        if (brandId != null) {
            Brand brand = brandService.getBrandById(brandId);
            model.setBrand(brand);
        }
    }

    private void updateTransmissionIfExists(Model model, Integer transmissionId) {
        if (transmissionId != null) {
            Transmission transmission = transmissionService.getTransmissionById(transmissionId);
            model.setTransmission(transmission);
        }
    }

    private void updateFuelTypeIfExists(Model model, Integer fuelTypeId) {
        if (fuelTypeId != null) {
            FuelType fuelType = fuelTypeService.getFuelTypeById(fuelTypeId);
            model.setFuelType(fuelType);
        }
    }

    private void updateModelNameIfExists(Model model, String modelName) {
        if (modelName != null) {
            model.setName(modelName);
        }
    }
}
