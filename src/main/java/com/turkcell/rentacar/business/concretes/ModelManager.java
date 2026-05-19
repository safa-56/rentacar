package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.ModelService;
import com.turkcell.rentacar.dataAccess.abstracts.ModelRepository;
import com.turkcell.rentacar.entities.concretes.Model;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class ModelManager implements ModelService {

    private ModelRepository modelRepository;

    @Transactional
    @Override
    public Model add(Model model) {
        return modelRepository.save(model);
    }

    @Transactional
    @Override
    public Model update(int id, Model model) {
        Model oldModel = getById(id);

        oldModel.setName(model.getName());
        oldModel.setUpdatedDate(model.getUpdatedDate());
        oldModel.setUpdatedDate(model.getUpdatedDate());
        oldModel.setFuelType(model.getFuelType());
        oldModel.setBrand(model.getBrand());

        return modelRepository.save(model);
    }

    @Override
    public Model getById(int id) {
        return modelRepository.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(int id) {
        modelRepository.deleteById(id);
    }
}
