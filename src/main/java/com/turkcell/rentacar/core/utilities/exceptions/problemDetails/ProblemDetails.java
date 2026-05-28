package com.turkcell.rentacar.core.utilities.exceptions.problemDetails;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProblemDetails {
    //rfcs standartları
    private String title;
    private String detail;
    private String status;
    private String type;
}
