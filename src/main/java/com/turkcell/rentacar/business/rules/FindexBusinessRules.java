package com.turkcell.rentacar.business.rules;

import com.turkcell.rentacar.core.utilities.exceptions.types.BusinessException;
import org.springframework.stereotype.Service;

@Service
public class FindexBusinessRules {
    public void scoreIsExist(Integer score) {
        if (score == null) {
            throw new BusinessException("Score is null");
        }
    }

    public void responseIsExists(Object response) {
        if (response == null) {
            throw new BusinessException("Findex service response is null");
        }
    }
}
