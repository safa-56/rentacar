package com.turkcell.rentacar.business.dtos.requests.car;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateCarRequest {
    @NotNull
    @Size(min = 1,max = 15)
    private String name;

    @Positive
    @NotNull
    private Integer modelId;
}
