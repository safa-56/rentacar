package com.turkcell.rentacar.business.abstracts;

import com.turkcell.rentacar.business.dtos.requests.customer.CreateIndividualCustomerRequest;
import com.turkcell.rentacar.business.dtos.responses.customer.CreatedIndividualCustomerResponse;
import com.turkcell.rentacar.business.dtos.responses.customer.GetIndividualCustomerResponse;
import com.turkcell.rentacar.business.dtos.responses.customer.UpdatedIndividualCustomerResponse;

public interface IndividualCustomerService {
    //TODO: buranın managerı ve controllerını yaz.corporate customer, maintenance, rental alanları için de dto ve servisleri yaz
    CreatedIndividualCustomerResponse add(CreateIndividualCustomerRequest createIndividualCustomerRequest);
    GetIndividualCustomerResponse getById(int id);
    UpdatedIndividualCustomerResponse update(int id,UpdatedIndividualCustomerResponse updatedIndividualCustomerRequest);
    void delete(int id);
}
