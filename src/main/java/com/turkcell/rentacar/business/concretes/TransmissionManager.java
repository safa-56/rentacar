package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.TransmissionService;
import com.turkcell.rentacar.business.dtos.requests.transmission.CreateTransmissionRequest;
import com.turkcell.rentacar.business.dtos.requests.transmission.UpdateTransmissionRequest;
import com.turkcell.rentacar.business.dtos.responses.transmission.CreatedTransmissionResponse;
import com.turkcell.rentacar.business.dtos.responses.transmission.GetTransmissionResponse;
import com.turkcell.rentacar.business.dtos.responses.transmission.UpdatedTransmissionResponse;
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

    @Transactional
    @Override
    public CreatedTransmissionResponse add(CreateTransmissionRequest createTransmissionRequest) {
        Transmission transmission = new Transmission();
        transmission.setName(createTransmissionRequest.getName());
        transmission.setCreatedDate(LocalDateTime.now());

        Transmission createdTransmission = transmissionsRepository.save(transmission);

        CreatedTransmissionResponse createdTransmissionResponse = new CreatedTransmissionResponse();
        createdTransmissionResponse.setId(createdTransmission.getId());
        createdTransmissionResponse.setName(createdTransmission.getName());
        createdTransmissionResponse.setCreatedDate(createdTransmission.getCreatedDate());

        return createdTransmissionResponse;
    }

    @Override
    public GetTransmissionResponse getById(int id) {

        Transmission transmission = transmissionsRepository.findById(id).orElse(null);

        GetTransmissionResponse getTransmissionResponse = new GetTransmissionResponse();
        getTransmissionResponse.setId(transmission.getId());
        getTransmissionResponse.setName(transmission.getName());
        getTransmissionResponse.setCreatedDate(transmission.getCreatedDate());
        getTransmissionResponse.setUpdatedDate(transmission.getUpdatedDate());

        return getTransmissionResponse;
    }

    @Transactional
    @Override
    public UpdatedTransmissionResponse update(int id, UpdateTransmissionRequest updateTransmissionRequest) {
        Transmission oldTransmission = transmissionsRepository.findById(id).orElse(null);

        oldTransmission.setName(updateTransmissionRequest.getName());
        oldTransmission.setUpdatedDate(LocalDateTime.now());

        Transmission transmission = transmissionsRepository.save(oldTransmission);

        UpdatedTransmissionResponse updatedTransmissionResponse = new UpdatedTransmissionResponse();
        updatedTransmissionResponse.setId(transmission.getId());
        updatedTransmissionResponse.setName(transmission.getName());
        updatedTransmissionResponse.setUpdatedDate(transmission.getUpdatedDate());

        return updatedTransmissionResponse;
    }


    @Transactional
    @Override
    public void delete(int id) {
        transmissionsRepository.deleteById(id);
    }

    @Override
    public Transmission getTransmissionById(int id) {
        return transmissionsRepository.findById(id).orElse(null);
    }
}
