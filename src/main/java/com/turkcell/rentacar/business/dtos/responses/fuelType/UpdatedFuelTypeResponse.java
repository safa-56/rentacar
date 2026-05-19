package com.turkcell.rentacar.business.dtos.responses.fuelType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdatedFuelTypeResponse {
    private int id;
    private String name;
    private LocalDateTime updatedDate;
}
