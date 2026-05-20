package com.turkcell.rentacar.business.dtos.responses.transmission;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreatedTransmissionResponse {
    private int id;
    private String name;
    private LocalDateTime createdDate;
}
