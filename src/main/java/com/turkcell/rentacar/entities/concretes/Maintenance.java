package com.turkcell.rentacar.entities.concretes;

import com.turkcell.rentacar.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "maintenances")
public class Maintenance extends BaseEntity {
    @Column(name = "isMaintenance")
    private boolean isMaintenance;

    @ManyToOne
    @JoinColumn(name = "carId")
    private Car car;
}
