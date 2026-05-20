package com.turkcell.rentacar.api.controllers;

import com.turkcell.rentacar.business.abstracts.ModelService;
import com.turkcell.rentacar.business.dtos.requests.model.CreateModelRequest;
import com.turkcell.rentacar.business.dtos.requests.model.UpdateModelRequest;
import com.turkcell.rentacar.business.dtos.responses.model.CreatedModelResponse;
import com.turkcell.rentacar.business.dtos.responses.model.GetModelResponse;
import com.turkcell.rentacar.business.dtos.responses.model.UpdatedModelResponse;
import com.turkcell.rentacar.entities.concretes.Model;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class ModelsController {

    private ModelService modelService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/models")
    public CreatedModelResponse add(@Valid @RequestBody CreateModelRequest createModelRequest){
        return modelService.add(createModelRequest);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/models/{id}")
    public GetModelResponse getById(@PathVariable int id){
        return modelService.getById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/models/{id}")
    public UpdatedModelResponse update(@PathVariable int id, @Valid @RequestBody UpdateModelRequest updateModelRequest){
        return modelService.update(id, updateModelRequest);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/models/{id}")
    public void delete(@PathVariable int id){
        modelService.delete(id);
    }
}