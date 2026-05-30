package com.turkcell.rentacar.business.rules;

import com.turkcell.rentacar.core.utilities.exceptions.types.BusinessException;
import com.turkcell.rentacar.dataAccess.abstracts.CorporateCustomerRepository;
import com.turkcell.rentacar.entities.concretes.CorporateCustomer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class CorporateCustomerBusinessRules {
    private CorporateCustomerRepository corporateCustomerRepository;

    public void customerNameCanNotBeDuplicated(String companyName){
        Optional<CorporateCustomer> corporateCustomer = corporateCustomerRepository.findByCompanyNameIgnoreCase(companyName);
        if(corporateCustomer.isPresent()){
            throw new BusinessException("Customer with company name " + companyName + " already exists");
        }
    }
    public CorporateCustomer customerIsExist(int customerId){
        return corporateCustomerRepository.findById(customerId).orElseThrow(() -> new BusinessException("Customer with id " + customerId + " does not exist"));
    }

    public void customerNameCanNotBeDuplicatedForUpdate(int customerId,String companyName){
        if (corporateCustomerRepository.existsByCompanyNameIgnoreCaseAndIdNot(companyName,customerId)) throw new BusinessException("Customer with id " + customerId + " already exists");
    }
}
