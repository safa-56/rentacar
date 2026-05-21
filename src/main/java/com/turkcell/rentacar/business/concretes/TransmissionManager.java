package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.TransmissionService;
import com.turkcell.rentacar.business.dtos.requests.transmission.CreateTransmissionRequest;
import com.turkcell.rentacar.business.dtos.requests.transmission.UpdateTransmissionRequest;
import com.turkcell.rentacar.business.dtos.responses.transmission.CreatedTransmissionResponse;
import com.turkcell.rentacar.business.dtos.responses.transmission.GetTransmissionResponse;
import com.turkcell.rentacar.business.dtos.responses.transmission.UpdatedTransmissionResponse;
import com.turkcell.rentacar.business.rules.TransmissionBusinessRules;
import com.turkcell.rentacar.core.utilities.mapping.ModelMapperService;
import com.turkcell.rentacar.dataAccess.abstracts.TransmissionsRepository;
import com.turkcell.rentacar.entities.concretes.Transmission;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class TransmissionManager implements TransmissionService {

    private TransmissionsRepository transmissionsRepository;
    private ModelMapperService modelMapperService;
    private TransmissionBusinessRules transmissionBusinessRules;

    @Transactional
    @Override
    public CreatedTransmissionResponse add(CreateTransmissionRequest createTransmissionRequest) {
        this.transmissionBusinessRules.transmissionNameCanNotBeDuplicated(createTransmissionRequest.getName());

        Transmission transmission = this.modelMapperService.forRequest().map(createTransmissionRequest, Transmission.class);
        transmission.setCreatedDate(LocalDateTime.now());

        Transmission createdTransmission = transmissionsRepository.save(transmission);

//        CreatedTransmissionResponse createdTransmissionResponse = new CreatedTransmissionResponse();
//        createdTransmissionResponse.setId(createdTransmission.getId());
//        createdTransmissionResponse.setName(createdTransmission.getName());
//        createdTransmissionResponse.setCreatedDate(createdTransmission.getCreatedDate());
        CreatedTransmissionResponse createdTransmissionResponse = this.modelMapperService.forResponse().map(createdTransmission,CreatedTransmissionResponse.class);

        return createdTransmissionResponse;
    }

    @Override
    public GetTransmissionResponse getById(int id) {
        this.transmissionBusinessRules.transmissionIsExist(id);

        Transmission transmission = transmissionsRepository.findById(id).get();

//        GetTransmissionResponse getTransmissionResponse = new GetTransmissionResponse();
//        getTransmissionResponse.setId(transmission.getId());
//        getTransmissionResponse.setName(transmission.getName());
//        getTransmissionResponse.setCreatedDate(transmission.getCreatedDate());
//        getTransmissionResponse.setUpdatedDate(transmission.getUpdatedDate());
        GetTransmissionResponse getTransmissionResponse = this.modelMapperService.forResponse().map(transmission,GetTransmissionResponse.class);

        return getTransmissionResponse;
    }

    @Transactional
    @Override
    public UpdatedTransmissionResponse update(int id, UpdateTransmissionRequest updateTransmissionRequest) {
        this.transmissionBusinessRules.transmissionIsExist(id);
        this.transmissionBusinessRules.transmissionNameCanNotBeDuplicatedForUpdate(updateTransmissionRequest.getName(),id);

        Transmission existingTransmission = transmissionsRepository.findById(id).get();

        this.modelMapperService.forRequest().map(updateTransmissionRequest, existingTransmission);
        existingTransmission.setUpdatedDate(LocalDateTime.now());

        Transmission updatedTransmission = transmissionsRepository.save(existingTransmission);

//        UpdatedTransmissionResponse updatedTransmissionResponse = new UpdatedTransmissionResponse();
//        updatedTransmissionResponse.setId(transmission.getId());
//        updatedTransmissionResponse.setName(transmission.getName());
//        updatedTransmissionResponse.setUpdatedDate(transmission.getUpdatedDate());
        UpdatedTransmissionResponse updatedTransmissionResponse = this.modelMapperService.forResponse().map(updatedTransmission,UpdatedTransmissionResponse.class);

        return updatedTransmissionResponse;
    }


    @Transactional
    @Override
    public void delete(int id) {
        this.transmissionBusinessRules.transmissionIsExist(id);
        transmissionsRepository.deleteById(id);
    }

    @Override
    public Transmission getTransmissionById(int id) {
        this.transmissionBusinessRules.transmissionIsExist(id);
        return transmissionsRepository.findById(id).get();
    }
}
