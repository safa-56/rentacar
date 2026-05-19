package com.turkcell.rentacar.business.abstracts;

import com.turkcell.rentacar.entities.concretes.Transmission;

public interface TransmissionService {
    Transmission getById(int id);
    Transmission update(int id,Transmission transmission);
    Transmission add(Transmission transmission);
    void delete(int id);
}
