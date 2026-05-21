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
import com.turkcell.rentacar.business.rules.ModelBusinessRules;
import com.turkcell.rentacar.core.utilities.mapping.ModelMapperService;
import com.turkcell.rentacar.dataAccess.abstracts.ModelRepository;
import com.turkcell.rentacar.entities.concretes.Brand;
import com.turkcell.rentacar.entities.concretes.FuelType;
import com.turkcell.rentacar.entities.concretes.Model;
import com.turkcell.rentacar.entities.concretes.Transmission;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class ModelManager implements ModelService {

    private ModelRepository modelRepository;
    private BrandService brandService;
    private TransmissionService transmissionService;
    private FuelTypeService fuelTypeService;
    private ModelMapperService modelMapperService;
    private ModelBusinessRules modelBusinessRules;

    @Transactional
    @Override
    public CreatedModelResponse add(CreateModelRequest createModelRequest) {

        Brand brand = brandService.getBrandById(createModelRequest.getBrandId());
        FuelType fuelType = fuelTypeService.getFuelTypeById(createModelRequest.getFuelTypeId());
        Transmission transmission = transmissionService.getTransmissionById(createModelRequest.getTransmissionId());

        Model model = this.modelMapperService.forRequest().map(createModelRequest,Model.class);
        model.setBrand(brand);
        model.setFuelType(fuelType);
        model.setTransmission(transmission);
        model.setCreatedDate(LocalDateTime.now());

        Model createdModel = modelRepository.save(model);

//        CreatedModelResponse createdModelResponse = this.modelMapperService.forResponse().map(createdModel, CreatedModelResponse.class);
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
        this.modelBusinessRules.modelIsExist(id);

        Model existModel = modelRepository.findById(id).get();
// TODO: yukarıdaki iki satırda aynı sorgu iki defa veritabanına atılıyor. rule'da direk entity dön
// public Model getModelIfExists(int id) {
//    return modelRepository.findById(id)
//        .orElseThrow(() -> new BusinessException("Model not found"));
//}

        GetModelResponse getModelResponse = getResponse(existModel);

        return getModelResponse;
    }

    //Bu metod, daha sonra olası bir getAll() gibi bir metodun eklenmesi durumunda aynı alanları tekrar etmemek için yazılmıştır.
    private @NonNull GetModelResponse getResponse(Model existModel) {
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
        this.modelBusinessRules.modelIsExist(id);

        Model oldModel = modelRepository.findById(id).get();

        updateBrandIfProvided(oldModel, updateModelRequest.getBrandId());
        updateFuelTypeIfProvided(oldModel, updateModelRequest.getFuelTypeId());
        updateTransmissionIfProvided(oldModel, updateModelRequest.getTransmissionId());
        updateModelNameIfProvided(oldModel, updateModelRequest.getName());
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
        this.modelBusinessRules.modelIsExist(id);
        modelRepository.deleteById(id);
    }

    // değerlerin güncellenip güncellenmediğini kontrol ederler
    private void updateBrandIfProvided(Model model, Integer brandId) {
        if (brandId != null) {
            Brand brand = brandService.getBrandById(brandId);
            model.setBrand(brand);
        }
    }

    private void updateTransmissionIfProvided(Model model, Integer transmissionId) {
        if (transmissionId != null) {
            Transmission transmission = transmissionService.getTransmissionById(transmissionId);
            model.setTransmission(transmission);
        }
    }

    private void updateFuelTypeIfProvided(Model model, Integer fuelTypeId) {
        if (fuelTypeId != null) {
            FuelType fuelType = fuelTypeService.getFuelTypeById(fuelTypeId);
            model.setFuelType(fuelType);
        }
    }

    private void updateModelNameIfProvided(Model model, String modelName) {
        if (modelName != null) {
            model.setName(modelName);
        }
    }
}
