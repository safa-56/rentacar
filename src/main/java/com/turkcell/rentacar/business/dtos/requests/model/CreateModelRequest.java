package com.turkcell.rentacar.business.dtos.requests.model;
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
public class CreateModelRequest {
    @NotEmpty
    @Size(min = 1, max = 100)
    private String name;

    @NotEmpty
    private int transmissionId;

    @NotEmpty
    private int fuelTypeId;

    @NotEmpty
    private int brandId;
}
