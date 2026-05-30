package com.turkcell.rentacar.business.abstracts;

import com.turkcell.rentacar.business.dtos.requests.customer.CreateCorporateCustomerRequest;
import com.turkcell.rentacar.business.dtos.requests.customer.CreateIndividualCustomerRequest;
import com.turkcell.rentacar.business.dtos.requests.customer.UpdateCorporateCustomerRequest;
import com.turkcell.rentacar.business.dtos.responses.customer.*;

public interface CorporateCustomerService {
    CreatedCorporateCustomerResponse add(CreateCorporateCustomerRequest createCorporateCustomerRequest);
    GetCorporateCustomerResponse getById(int id);
    UpdatedCorporateCustomerResponse update(int id, UpdateCorporateCustomerRequest updateCorporateCustomerRequest);
    void delete(int id);
}
