package com.turkcell.rentacar.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Entity // veri tabanı varlığı olduğunu belirtiyoruz
@Table(name = "brands")
public class Brand extends BaseEntity {

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "brand" ,  cascade = CascadeType.ALL)
    private List<Model> modelList;
}
