package com.turkcell.rentacar.entities.concretes;

import com.turkcell.rentacar.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "cars")
public class Car extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "modelId")
    private Model model;

    @OneToMany(mappedBy = "car" ,  cascade = CascadeType.ALL)
    private List<Maintenance> maintenanceList;

    @OneToMany(mappedBy = "car" , cascade = CascadeType.ALL)
    private List<Rental> rentalList;
}
