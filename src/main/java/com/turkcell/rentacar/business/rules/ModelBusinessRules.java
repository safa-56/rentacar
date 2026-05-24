package com.turkcell.rentacar.business.rules;

import com.turkcell.rentacar.dataAccess.abstracts.ModelRepository;
import com.turkcell.rentacar.entities.concretes.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class ModelBusinessRules {
    private ModelRepository modelRepository;

    public Model modelIsExist(int modelId) {
        return modelRepository.findById(modelId).orElseThrow(() -> new RuntimeException("Model with id " + modelId + " does not exist"));
    }
}
