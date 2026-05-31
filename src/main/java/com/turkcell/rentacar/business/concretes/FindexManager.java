package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.FindexService;
import com.turkcell.rentacar.business.dtos.requests.findexScore.CorporateCustomerFindexScoreRequest;
import com.turkcell.rentacar.business.dtos.requests.findexScore.IndividualCustomerFindexScoreRequest;
import com.turkcell.rentacar.business.dtos.responses.findexScore.CorporateCustomerFindexScoreResponse;
import com.turkcell.rentacar.business.dtos.responses.findexScore.IndividualCustomerFindexScoreResponse;
import com.turkcell.rentacar.business.dtos.responses.findexScore.ModelFindexScoreResponse;
import com.turkcell.rentacar.business.rules.FindexBusinessRules;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@AllArgsConstructor
@Service
public class FindexManager implements FindexService {
    private final RestTemplate restTemplate;
    private FindexBusinessRules findexBusinessRules;
    private static final String BASE_FINDEX_URL = "http://localhost:8081/api/findex";

    @Override
    public int getIndividualCustomerScore(String identityNumber) {
        String url = BASE_FINDEX_URL + "/individual";

        IndividualCustomerFindexScoreRequest request = new IndividualCustomerFindexScoreRequest();
        request.setIdentityNumber(identityNumber);

        IndividualCustomerFindexScoreResponse response = restTemplate.postForObject(
                url,
                request,
                IndividualCustomerFindexScoreResponse.class
        );

        findexBusinessRules.responseIsExists(response);

        int score = response.getScore();

        findexBusinessRules.scoreIsExist(score);

        return score;

    }

    @Override
    public int getCorporateCustomerScore(String taxNumber) {
        String url = BASE_FINDEX_URL + "/corporate";

        CorporateCustomerFindexScoreRequest request = new CorporateCustomerFindexScoreRequest();
        request.setTaxNumber(taxNumber);

        CorporateCustomerFindexScoreResponse response = restTemplate.postForObject(
                url,
                request,
                CorporateCustomerFindexScoreResponse.class
        );

        findexBusinessRules.responseIsExists(response);

        int score = response.getScore();

        findexBusinessRules.scoreIsExist(score);

        return score;
    }

    @Override
    public int getModelScore() {
        String url = BASE_FINDEX_URL + "/model";

        ModelFindexScoreResponse response = restTemplate.postForObject(url,null, ModelFindexScoreResponse.class);

        findexBusinessRules.responseIsExists(response);

        int score = response.getScore();

        findexBusinessRules.scoreIsExist(score);

        return score;
    }
}