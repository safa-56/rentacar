package com.turkcell.rentacar.business.rules;

import com.turkcell.rentacar.core.utilities.exceptions.types.BusinessException;
import com.turkcell.rentacar.dataAccess.abstracts.IndividualCustomerRepository;
import com.turkcell.rentacar.entities.concretes.IndividualCustomer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class IndividualCustomerBusinessRules {
    private IndividualCustomerRepository individualCustomerRepository;

    public void customerNameCanNotBeDuplicated(String firstName, String lastName) {
        Optional<IndividualCustomer>  individualCustomer = individualCustomerRepository.findByFirstNameAndLastNameIgnoreCase(firstName, lastName);
        if (individualCustomer.isPresent()) {
            throw new BusinessException("Customer with first name " + firstName + " and last name " + lastName + " already exists");
        }
    }

    public IndividualCustomer customerIsExist(int customerId) {
        return individualCustomerRepository.findById(customerId).orElseThrow(() -> new BusinessException("Customer with id " + customerId + " does not exist"));
    }

    public void customerNameCanNotBeDuplicatedForUpdate(int customerId, String firstName, String lastName) {
        if (individualCustomerRepository.existsByFirstNameAndLastNameIgnoreCaseAndIdNot(firstName, lastName, customerId)){
            throw new BusinessException("Customer with id " + customerId + " already exists");
        }
    }
}
