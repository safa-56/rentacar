package com.turkcell.rentacar.business.dtos.requests.customer;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateCorporateCustomerRequest {
    @NotNull
    private String companyName;

    @NotNull
    @Size(min = 10, max = 10)
    private String taxNumber;

    @NotNull
    private String address;

    @NotNull
    @Size(min = 11, max = 11)
    private String phoneNumber;

}
