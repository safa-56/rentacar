package com.turkcell.rentacar.business.abstracts;

import com.turkcell.rentacar.business.dtos.requests.transmission.CreateTransmissionRequest;
import com.turkcell.rentacar.business.dtos.requests.transmission.UpdateTransmissionRequest;
import com.turkcell.rentacar.business.dtos.responses.transmission.CreatedTransmissionResponse;
import com.turkcell.rentacar.business.dtos.responses.transmission.GetTransmissionResponse;
import com.turkcell.rentacar.business.dtos.responses.transmission.UpdatedTransmissionResponse;
import com.turkcell.rentacar.entities.concretes.Transmission;

public interface TransmissionService {
    CreatedTransmissionResponse add(CreateTransmissionRequest createTransmissionRequest);
    GetTransmissionResponse getById(int id);
    UpdatedTransmissionResponse update(int id, UpdateTransmissionRequest updateTransmissionRequest);
    void delete(int id);
    Transmission getTransmissionById(int id);
}
