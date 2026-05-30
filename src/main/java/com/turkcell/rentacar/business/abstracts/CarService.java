package com.turkcell.rentacar.business.abstracts;

import com.turkcell.rentacar.business.dtos.requests.car.CreateCarRequest;
import com.turkcell.rentacar.business.dtos.requests.car.UpdateCarRequest;
import com.turkcell.rentacar.business.dtos.responses.car.CreatedCarResponse;
import com.turkcell.rentacar.business.dtos.responses.car.GetCarResponse;
import com.turkcell.rentacar.business.dtos.responses.car.UpdatedCarResponse;

public interface CarService {
    // TODO: maintenance, rental alanları için de dto ve servisleri yaz
    CreatedCarResponse add(CreateCarRequest createCarRequest);
    GetCarResponse getById(int id);
    UpdatedCarResponse update(int id,UpdateCarRequest updateCarRequest);
    void delete(int id);
}
