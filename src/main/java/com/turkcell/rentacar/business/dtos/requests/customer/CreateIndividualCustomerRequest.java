package com.turkcell.rentacar.business.dtos.requests.customer;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateIndividualCustomerRequest {
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @NotEmpty
    @Size(min = 11, max = 11)
    private String identityNumber;
    @NotEmpty
    private String address;
    @NotEmpty
    @Size(min = 11, max = 11)
    private String phoneNumber;
    @NotEmpty
    @Email
    private String email;
}
