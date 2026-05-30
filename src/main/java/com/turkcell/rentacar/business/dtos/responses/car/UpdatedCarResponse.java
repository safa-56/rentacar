package com.turkcell.rentacar.business.dtos.responses.car;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdatedCarResponse {
    private Integer id;
    private String name;
    private String modelName;
    private LocalDateTime updatedDate;
}
