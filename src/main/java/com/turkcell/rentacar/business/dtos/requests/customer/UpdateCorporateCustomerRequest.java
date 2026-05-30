package com.turkcell.rentacar.business.dtos.requests.customer;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateCorporateCustomerRequest {
    private String companyName;
    @Size(min = 10, max = 10)
    private String taxNumber;
    private String address;
    @Size(min = 11, max = 11)
    private String phoneNumber;
    private String email;
    private LocalDateTime updateDate;
}
