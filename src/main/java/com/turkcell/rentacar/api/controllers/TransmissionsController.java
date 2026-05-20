package com.turkcell.rentacar.api.controllers;

import com.turkcell.rentacar.business.abstracts.TransmissionService;
import com.turkcell.rentacar.business.dtos.requests.transmission.CreateTransmissionRequest;
import com.turkcell.rentacar.business.dtos.requests.transmission.UpdateTransmissionRequest;
import com.turkcell.rentacar.business.dtos.responses.transmission.CreatedTransmissionResponse;
import com.turkcell.rentacar.business.dtos.responses.transmission.GetTransmissionResponse;
import com.turkcell.rentacar.business.dtos.responses.transmission.UpdatedTransmissionResponse;
import com.turkcell.rentacar.entities.concretes.Transmission;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class TransmissionsController {

    private TransmissionService transmissionService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/transmissions")
    public CreatedTransmissionResponse add(@Valid @RequestBody CreateTransmissionRequest createTransmissionRequest){
        return transmissionService.add(createTransmissionRequest);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/transmissions/{id}")
    public GetTransmissionResponse getById(@PathVariable int id){
        return transmissionService.getById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/transmissions/{id}")
    public UpdatedTransmissionResponse update(@PathVariable int id, @Valid @RequestBody UpdateTransmissionRequest updateTransmissionRequest){
        return transmissionService.update(id, updateTransmissionRequest);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/transmissions/{id}")
    public void delete(@PathVariable int id){
        transmissionService.delete(id);
    }
}
