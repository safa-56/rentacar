package com.turkcell.rentacar.api.controllers;

import com.turkcell.rentacar.business.abstracts.IndividualCustomerService;
import com.turkcell.rentacar.business.dtos.requests.customer.CreateIndividualCustomerRequest;
import com.turkcell.rentacar.business.dtos.responses.customer.CreatedIndividualCustomerResponse;
import com.turkcell.rentacar.business.dtos.responses.customer.GetIndividualCustomerResponse;
import com.turkcell.rentacar.business.dtos.responses.customer.UpdatedIndividualCustomerResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class IndividualCustomersController {
    private IndividualCustomerService individualCustomerService;

    @PostMapping("/individualCustomers")
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedIndividualCustomerResponse add(@Valid @RequestBody CreateIndividualCustomerRequest createIndividualCustomerRequest){
        return individualCustomerService.add(createIndividualCustomerRequest);
    }

    @GetMapping("/individualCustomers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetIndividualCustomerResponse getById(@PathVariable int id){
        return individualCustomerService.getById(id);
    }

    @PostMapping("/individualCustomers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UpdatedIndividualCustomerResponse update(@PathVariable int id,@Valid @RequestBody UpdatedIndividualCustomerResponse updatedIndividualCustomerRequest){
        return individualCustomerService.update(id, updatedIndividualCustomerRequest);
    }

    @DeleteMapping("/individualCustomers/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable int id){
        individualCustomerService.delete(id);
    }
}
