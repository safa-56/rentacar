package com.turkcell.rentacar.entities.concretes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "corporateCustomers")
public class CorporateCustomer extends Customer{
    @Column(name = "taxNumber")
    private String taxNumber;

    @Column(name = "companyName")
    private String companyName;
}
