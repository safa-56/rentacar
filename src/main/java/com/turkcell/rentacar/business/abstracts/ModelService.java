package com.turkcell.rentacar.business.abstracts;

import com.turkcell.rentacar.business.dtos.requests.model.CreateModelRequest;
import com.turkcell.rentacar.business.dtos.requests.model.UpdateModelRequest;
import com.turkcell.rentacar.business.dtos.responses.model.CreatedModelResponse;
import com.turkcell.rentacar.business.dtos.responses.model.GetModelResponse;
import com.turkcell.rentacar.business.dtos.responses.model.UpdatedModelResponse;
import com.turkcell.rentacar.entities.concretes.Model;

public interface ModelService {
    CreatedModelResponse add(CreateModelRequest createModelRequest);
    GetModelResponse getById(int id);
    UpdatedModelResponse update(int id, UpdateModelRequest updateModelRequest);
    void delete(int id);
    Model getModel(int id);
}
