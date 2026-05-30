package com.turkcell.rentacar.business.dtos.requests.findexScore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CorporateCustomerFindexScoreRequest {
    private String taxNumber;
}
