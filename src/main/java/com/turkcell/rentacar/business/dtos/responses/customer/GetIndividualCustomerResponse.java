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
public class GetIndividualCustomerResponse {
    private int id;
    private int findexScore;
    private String firstName;
    private String lastName;
    private String identityNumber;
    private String address;
    private String phoneNumber;
    private String email;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}
