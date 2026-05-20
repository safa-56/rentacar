package com.turkcell.rentacar.business.dtos.responses.model;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdatedModelResponse {
    private int id;
    private String name;
    private String brandName;
    private String fuelTypeName;
    private String transmissionName;
    private LocalDateTime updatedDate;
}
