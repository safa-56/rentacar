package com.turkcell.rentacar.api.controllers;

import com.turkcell.rentacar.business.abstracts.ModelService;
import com.turkcell.rentacar.entities.concretes.Model;
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
    public Model add(@RequestBody Model model){
        return modelService.add(model);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/models/{id}")
    public Model update(@PathVariable int id,@RequestBody Model model){
        return modelService.update(id, model);
    }

    @ResponseStatus(HttpStatus.FOUND)
    @GetMapping("/models/{id}")
    public Model getById(@PathVariable int id){
        return modelService.getById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/models/{id}")
    public void delete(@PathVariable int id){
        modelService.delete(id);
    }
}