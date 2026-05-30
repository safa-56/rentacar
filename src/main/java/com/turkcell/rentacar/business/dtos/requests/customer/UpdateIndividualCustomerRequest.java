package com.turkcell.rentacar.business.dtos.requests.customer;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
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
    @NotNull
    @Size(min = 1, max = 15)
    private String firstName;

    @NotNull
    @Size(min = 1, max = 20)
    private String lastName;

    @NotNull
    @Size(min = 11, max = 11)
    private String identityNumber;

    @NotNull
    @Email
    private String email;

    @NotNull
    @Size(min = 11, max = 11)
    private String phoneNumber;

    @NotNull
    @Size(min = 1)
    private String address;


}
