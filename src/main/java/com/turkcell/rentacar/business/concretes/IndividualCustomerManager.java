package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.FindexService;
import com.turkcell.rentacar.business.abstracts.IndividualCustomerService;
import com.turkcell.rentacar.business.dtos.requests.customer.CreateIndividualCustomerRequest;
import com.turkcell.rentacar.business.dtos.responses.customer.CreatedIndividualCustomerResponse;
import com.turkcell.rentacar.business.dtos.responses.customer.GetIndividualCustomerResponse;
import com.turkcell.rentacar.business.dtos.responses.customer.UpdatedIndividualCustomerResponse;
import com.turkcell.rentacar.business.rules.IndividualCustomerBusinessRules;
import com.turkcell.rentacar.core.utilities.mapping.ModelMapperService;
import com.turkcell.rentacar.dataAccess.abstracts.IndividualCustomerRepository;
import com.turkcell.rentacar.entities.concretes.IndividualCustomer;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class IndividualCustomerManager implements IndividualCustomerService {
    private IndividualCustomerRepository  individualCustomerRepository;
    private IndividualCustomerBusinessRules individualCustomerBusinessRules;
    private ModelMapperService modelMapperService;
    private FindexService findexService;

    @Transactional
    @Override
    public CreatedIndividualCustomerResponse add(CreateIndividualCustomerRequest createIndividualCustomerRequest) {
        individualCustomerBusinessRules.customerNameCanNotBeDuplicated(createIndividualCustomerRequest.getFirstName()
                                                    ,createIndividualCustomerRequest.getLastName());

        IndividualCustomer individualCustomer = modelMapperService.forRequest()
                                                    .map(createIndividualCustomerRequest, IndividualCustomer.class);

        individualCustomer.setFindexScore(findexService.getIndividualCustomerScore(individualCustomer.getIdentityNumber()));
        individualCustomer.setCreatedDate(LocalDateTime.now());

        IndividualCustomer createdIndividualCustomer = individualCustomerRepository.save(individualCustomer);

        CreatedIndividualCustomerResponse createdIndividualCustomerResponse = modelMapperService.forResponse().map(createdIndividualCustomer,CreatedIndividualCustomerResponse.class);

        return createdIndividualCustomerResponse;
    }

    @Override
    public GetIndividualCustomerResponse getById(int id) {
        IndividualCustomer individualCustomer = individualCustomerBusinessRules.customerIsExist(id);

        GetIndividualCustomerResponse getIndividualCustomerResponse = modelMapperService.forResponse().map(individualCustomer,GetIndividualCustomerResponse.class);

        return getIndividualCustomerResponse;
    }

    @Transactional
    @Override
    public UpdatedIndividualCustomerResponse update(int id, UpdatedIndividualCustomerResponse updatedIndividualCustomerRequest) {
        IndividualCustomer existingIndividualCustomer = individualCustomerBusinessRules.customerIsExist(id);
        individualCustomerBusinessRules.customerNameCanNotBeDuplicatedForUpdate(id,updatedIndividualCustomerRequest.getFirstName()
                                                    ,updatedIndividualCustomerRequest.getLastName());

        modelMapperService.forRequest().map(updatedIndividualCustomerRequest, existingIndividualCustomer);

        existingIndividualCustomer.setUpdatedDate(LocalDateTime.now());
        existingIndividualCustomer.setFindexScore(findexService.getIndividualCustomerScore(updatedIndividualCustomerRequest.getIdentityNumber()));

        IndividualCustomer updatedIndividualCustomer = individualCustomerRepository.save(existingIndividualCustomer);

        UpdatedIndividualCustomerResponse updatedIndividualCustomerResponse = modelMapperService.forResponse().map(updatedIndividualCustomer,UpdatedIndividualCustomerResponse.class);

        return updatedIndividualCustomerResponse;
    }

    @Transactional
    @Override
    public void delete(int id) {
        IndividualCustomer individualCustomer = individualCustomerBusinessRules.customerIsExist(id);
        individualCustomerRepository.delete(individualCustomer);
    }
}
