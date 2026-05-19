package com.turkcell.rentacar.business.dtos.requests.fuelType;

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
public class CreateFuelTypeRequest {
    @NotEmpty
    @Size(min=1, max=100)
    private String name;
}
