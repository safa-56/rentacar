package com.turkcell.rentacar.dataAccess.abstracts;

import com.turkcell.rentacar.entities.concretes.IndividualCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IndividualCustomerRepository extends JpaRepository<IndividualCustomer, Integer> {
    Optional<IndividualCustomer> findByFirstNameAndLastNameIgnoreCase(String firstName, String lastName);
    boolean existsByFirstNameAndLastNameIgnoreCaseAndIdNot(String firstName, String lastName, int customerId);
}
