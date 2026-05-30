package com.turkcell.rentacar.business.dtos.responses.brand;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetBrandResponse {
    private Integer id;
    private String name;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}
