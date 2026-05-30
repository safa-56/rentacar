package com.turkcell.rentacar.business.dtos.requests.customer;
import jakarta.validation.constraints.Email;
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
public class UpdateIndividualCustomerRequest {
    private String firstName;
    private String lastName;
    @Size(min = 11, max = 11)
    private String identityNumber;
    @Email
    private String email;
    @Size(min = 11, max = 11)
    private String phoneNumber;
    private String address;
    private LocalDateTime updatedDate;

}
