package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.TransmissionService;
import com.turkcell.rentacar.dataAccess.abstracts.TransmissionsRepository;
import com.turkcell.rentacar.entities.concretes.Transmission;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class TransmissionManager implements TransmissionService {

    private TransmissionsRepository transmissionsRepository;
    @Override
    public Transmission getById(int id) {
        return  transmissionsRepository.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public Transmission update(int id, Transmission transmission) {
        Transmission oldTransmission = getById(id);

        oldTransmission.setName(transmission.getName());
        oldTransmission.setUpdatedDate(transmission.getUpdatedDate());
        oldTransmission.setModelList(transmission.getModelList());

        return transmissionsRepository.save(oldTransmission);
    }

    @Transactional
    @Override
    public Transmission add(Transmission transmission) {
        return transmissionsRepository.save(transmission);
    }

    @Transactional
    @Override
    public void delete(int id) {
        transmissionsRepository.deleteById(id);
    }
}
