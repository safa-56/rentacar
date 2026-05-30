package com.turkcell.rentacar.business.dtos.responses.findexScore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class IndividualCustomerFindexScoreResponse {
    private String identityNumber;
    private int score;
}
