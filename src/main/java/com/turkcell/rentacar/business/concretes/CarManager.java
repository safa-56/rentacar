package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.CarService;
import com.turkcell.rentacar.business.abstracts.ModelService;
import com.turkcell.rentacar.business.dtos.requests.car.CreateCarRequest;
import com.turkcell.rentacar.business.dtos.requests.car.UpdateCarRequest;
import com.turkcell.rentacar.business.dtos.responses.car.CreatedCarResponse;
import com.turkcell.rentacar.business.dtos.responses.car.GetCarResponse;
import com.turkcell.rentacar.business.dtos.responses.car.UpdatedCarResponse;
import com.turkcell.rentacar.business.rules.CarBusinessRules;
import com.turkcell.rentacar.core.utilities.mapping.ModelMapperService;
import com.turkcell.rentacar.dataAccess.abstracts.CarRepository;
import com.turkcell.rentacar.entities.concretes.Car;
import com.turkcell.rentacar.entities.concretes.Model;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class CarManager implements CarService {
    private CarRepository carRepository;
    private ModelMapperService modelMapperService;
    private CarBusinessRules  carBusinessRules;
    private ModelService modelService;

    @Transactional
    @Override
    public CreatedCarResponse add(CreateCarRequest createCarRequest) {
        Car car = modelMapperService.forRequest().map(createCarRequest, Car.class);
        Model model = modelService.getModel(createCarRequest.getModelId());

        car.setCreatedDate(LocalDateTime.now());
        car.setModel(model);

        Car createCar = carRepository.save(car);

        CreatedCarResponse createdCarResponse = modelMapperService.forResponse().map(createCar, CreatedCarResponse.class);

        return createdCarResponse;
    }

    @Override
    public GetCarResponse getById(int id) {
        Car existCar = carBusinessRules.carIsExist(id);

        GetCarResponse getCarResponse = modelMapperService.forResponse().map(existCar, GetCarResponse.class);

        return getCarResponse;
    }

    @Transactional
    @Override
    public UpdatedCarResponse update(int id, UpdateCarRequest updateCarRequest) {
        Car existCar = carBusinessRules.carIsExist(id);
        Model model = modelService.getModel(updateCarRequest.getModelId());

        modelMapperService.forRequest().map(updateCarRequest, existCar);

        existCar.setModel(model);
        existCar.setUpdatedDate(LocalDateTime.now());

        Car updatedCar =  carRepository.save(existCar);

        UpdatedCarResponse updatedCarResponse = modelMapperService.forResponse().map(updatedCar, UpdatedCarResponse.class);

        return updatedCarResponse;
    }

    @Transactional
    @Override
    public void delete(int id) {
        Car existCar = carBusinessRules.carIsExist(id);
        carRepository.delete(existCar);
    }
}
