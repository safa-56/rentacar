package com.turkcell.rentacar.business.dtos.responses.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreatedModelResponse {
    private Integer id;
    private String name;
    private String brandName;
    private String fuelTypeName;
    private String transmissionName;
    private LocalDateTime createdDate;
}
