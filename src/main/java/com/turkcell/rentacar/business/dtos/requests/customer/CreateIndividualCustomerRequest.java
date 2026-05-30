package com.turkcell.rentacar.business.dtos.requests.customer;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
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
public class CreateIndividualCustomerRequest {
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    @Size(min = 11, max = 11)
    private String identityNumber;
    @NotNull
    private String address;
    @NotNull
    @Size(min = 11, max = 11)
    private String phoneNumber;
    @NotNull
    @Email
    private String email;
}
