package com.turkcell.rentacar.business.abstracts;

public interface FindexService {
    int getIndividualCustomerScore(String identityNumber);
    int getCorporateCustomerScore(String taxNumber);
}
