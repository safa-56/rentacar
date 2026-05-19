package com.turkcell.rentacar.business.abstracts;

import com.turkcell.rentacar.entities.concretes.Model;

public interface ModelService {
    Model add(Model model);
    Model update(int id,Model model);
    Model getById(int id);
    void delete(int id);
}
