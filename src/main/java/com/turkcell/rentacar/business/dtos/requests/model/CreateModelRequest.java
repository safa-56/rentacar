package com.turkcell.rentacar.business.dtos.requests.model;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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
    @NotNull
    @Size(min = 1, max = 100)
    private String name;

    @Positive
    @NotNull
    private Integer transmissionId;

    @Positive
    @NotNull
    private Integer fuelTypeId;

    @Positive
    @NotNull
    private Integer brandId;
}
