package com.turkcell.rentacar.business.rules;

import com.turkcell.rentacar.dataAccess.abstracts.TransmissionsRepository;
import com.turkcell.rentacar.entities.concretes.Transmission;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class TransmissionBusinessRules {
    private TransmissionsRepository transmissionsRepository;

    public void transmissionNameCanNotBeDuplicated(String transmissionName) {
        Optional<Transmission> transmission = transmissionsRepository.findByNameIgnoreCase(transmissionName);
        if (transmission.isPresent()) {
            throw new RuntimeException("Transmission with name " + transmissionName + " already exists");
        }
    }

    public Transmission transmissionIsExist(int transmissionId) {
        return this.transmissionsRepository.findById(transmissionId).orElseThrow(() -> new RuntimeException("Transmission with id " + transmissionId + " does not exist"));
    }

    public void transmissionNameCanNotBeDuplicatedForUpdate(String transmissionName,int transmissionId) {
        if (transmissionsRepository.existsByNameIgnoreCaseAndIdNot(transmissionName,transmissionId)) {
            throw new RuntimeException("Transmission with name " + transmissionName + " already exists");
        }
    }
}
