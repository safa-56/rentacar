package com.turkcell.rentacar.api.controllers;

import com.turkcell.rentacar.business.abstracts.CorporateCustomerService;
import com.turkcell.rentacar.business.dtos.requests.customer.CreateCorporateCustomerRequest;
import com.turkcell.rentacar.business.dtos.requests.customer.UpdateCorporateCustomerRequest;
import com.turkcell.rentacar.business.dtos.responses.customer.CreatedCorporateCustomerResponse;
import com.turkcell.rentacar.business.dtos.responses.customer.GetCorporateCustomerResponse;
import com.turkcell.rentacar.business.dtos.responses.customer.UpdatedCorporateCustomerResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class CorporateCustomersController {
    private CorporateCustomerService corporateCustomerService;

    @PostMapping("/corporateCustomers")
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedCorporateCustomerResponse add(@Valid @RequestBody CreateCorporateCustomerRequest createCorporateCustomerRequest){
        return corporateCustomerService.add(createCorporateCustomerRequest);
    }

    @GetMapping("/corporateCustomers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetCorporateCustomerResponse getById(@PathVariable int id){
        return corporateCustomerService.getById(id);
    }

    @PostMapping("/corporateCustomers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UpdatedCorporateCustomerResponse update(@PathVariable int id,@Valid @RequestBody UpdateCorporateCustomerRequest updateCorporateCustomerRequest){
        return corporateCustomerService.update(id, updateCorporateCustomerRequest);
    }

    @DeleteMapping("/corporateCustomers/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id){
        corporateCustomerService.delete(id);
    }
}
