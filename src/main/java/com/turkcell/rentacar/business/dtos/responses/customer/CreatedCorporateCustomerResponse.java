package com.turkcell.rentacar.business.dtos.responses.customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreatedCorporateCustomerResponse {
    private int id;
    private String companyName;
    private String taxNumber;
    private String address;
    private String phoneNumber;
    private String email;
    private LocalDateTime createdDate;
}
