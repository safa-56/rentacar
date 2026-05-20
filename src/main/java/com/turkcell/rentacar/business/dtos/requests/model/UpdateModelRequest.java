package com.turkcell.rentacar.business.dtos.requests.model;
import java.time.LocalDateTime;

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
public class UpdateModelRequest {
    @NotEmpty
    @Size(min = 1, max = 100)
    private String name;
    private Integer brandId;
    private Integer fuelTypeId;
    private Integer transmissionId;
}
