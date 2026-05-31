package com.turkcell.rentacar.entities.concretes;

import com.turkcell.rentacar.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "models")
public class Model extends BaseEntity {
    @Column(name = "name")
    private String name;

    @Column(name = "findexScore")
    private int findexScore;

    @ManyToOne
    @JoinColumn(name = "transmissionId")
    private Transmission transmission;

    @ManyToOne
    @JoinColumn(name = "fuelTypeId")
    private FuelType fuelType;

    @ManyToOne
    @JoinColumn(name = "brandId")
    private Brand brand;

    @OneToMany(mappedBy = "model" , cascade = CascadeType.ALL)
    private List<Car> carList;
}
