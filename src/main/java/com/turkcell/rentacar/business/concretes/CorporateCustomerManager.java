package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.CorporateCustomerService;
import com.turkcell.rentacar.business.abstracts.FindexService;
import com.turkcell.rentacar.business.dtos.requests.customer.CreateCorporateCustomerRequest;
import com.turkcell.rentacar.business.dtos.requests.customer.UpdateCorporateCustomerRequest;
import com.turkcell.rentacar.business.dtos.responses.customer.CreatedCorporateCustomerResponse;
import com.turkcell.rentacar.business.dtos.responses.customer.GetCorporateCustomerResponse;
import com.turkcell.rentacar.business.dtos.responses.customer.UpdatedCorporateCustomerResponse;
import com.turkcell.rentacar.business.rules.CorporateCustomerBusinessRules;
import com.turkcell.rentacar.core.utilities.mapping.ModelMapperService;
import com.turkcell.rentacar.dataAccess.abstracts.CorporateCustomerRepository;
import com.turkcell.rentacar.entities.concretes.CorporateCustomer;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class CorporateCustomerManager implements CorporateCustomerService {
    private CorporateCustomerRepository corporateCustomerRepository;
    private ModelMapperService modelMapperService;
    private final FindexService findexService;
    private CorporateCustomerBusinessRules corporateCustomerBusinessRules;

    @Transactional
    @Override
    public CreatedCorporateCustomerResponse add(CreateCorporateCustomerRequest createCorporateCustomerRequest) {
        corporateCustomerBusinessRules.customerNameCanNotBeDuplicated(createCorporateCustomerRequest.getCompanyName());

        CorporateCustomer corporateCustomer = modelMapperService.forRequest().map(createCorporateCustomerRequest, CorporateCustomer.class);

        corporateCustomer.setFindexScore(findexService.getCorporateCustomerScore(createCorporateCustomerRequest.getTaxNumber()));
        corporateCustomer.setCreatedDate(LocalDateTime.now());

        CorporateCustomer createdCorporateCustomer = corporateCustomerRepository.save(corporateCustomer);

        CreatedCorporateCustomerResponse createdCorporateCustomerResponse = modelMapperService.forResponse().map(createdCorporateCustomer,CreatedCorporateCustomerResponse.class);

        return createdCorporateCustomerResponse;
    }

    @Override
    public GetCorporateCustomerResponse getById(int id) {
        CorporateCustomer corporateCustomer = corporateCustomerBusinessRules.customerIsExist(id);

        GetCorporateCustomerResponse getCorporateCustomerResponse = modelMapperService.forResponse().map(corporateCustomer,GetCorporateCustomerResponse.class);

        return getCorporateCustomerResponse;
    }

    @Transactional
    @Override
    public UpdatedCorporateCustomerResponse update(int id, UpdateCorporateCustomerRequest updateCorporateCustomerRequest) {
        CorporateCustomer existingCorporateCustomer = corporateCustomerBusinessRules.customerIsExist(id);
        corporateCustomerBusinessRules.customerNameCanNotBeDuplicatedForUpdate(id,updateCorporateCustomerRequest.getCompanyName());

        modelMapperService.forRequest().map(updateCorporateCustomerRequest,existingCorporateCustomer);

        existingCorporateCustomer.setFindexScore(findexService.getCorporateCustomerScore(updateCorporateCustomerRequest.getTaxNumber()));
        existingCorporateCustomer.setUpdatedDate(LocalDateTime.now());

        CorporateCustomer updatedCorporateCustomer = corporateCustomerRepository.save(existingCorporateCustomer);

        UpdatedCorporateCustomerResponse updatedCorporateCustomerResponse = modelMapperService.forResponse().map(updatedCorporateCustomer,UpdatedCorporateCustomerResponse.class);

        return updatedCorporateCustomerResponse;
    }

    @Transactional
    @Override
    public void delete(int id) {
        CorporateCustomer corporateCustomer = corporateCustomerBusinessRules.customerIsExist(id);
        corporateCustomerRepository.delete(corporateCustomer);
    }
}
