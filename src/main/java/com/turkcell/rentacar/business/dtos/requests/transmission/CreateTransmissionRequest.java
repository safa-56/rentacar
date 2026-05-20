package com.turkcell.rentacar.business.dtos.requests.transmission;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateTransmissionRequest {
    @NotEmpty
    @Size(min=2, max=50)
    private String name;
}
