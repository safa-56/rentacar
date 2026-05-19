package com.turkcell.rentacar.api.controllers;

import com.turkcell.rentacar.business.abstracts.TransmissionService;
import com.turkcell.rentacar.entities.concretes.Transmission;
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
    public Transmission add(@RequestBody Transmission transmission){
        return transmissionService.add(transmission);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/transmissions/{id}")
    public Transmission getById(@PathVariable int id){
        return transmissionService.getById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/transmissions/{id}")
    public Transmission update(@PathVariable int id,@RequestBody Transmission transmission){
        return transmissionService.update(id, transmission);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/transmissions/{id}")
    public void delete(@PathVariable int id){
        transmissionService.delete(id);
    }
}
