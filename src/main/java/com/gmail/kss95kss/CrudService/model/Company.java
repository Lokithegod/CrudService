package com.gmail.kss95kss.CrudService.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "about")
    private String about;

    @Column(name = "rating")
    private Double rating;

    @OneToMany(fetch = FetchType.EAGER,orphanRemoval = true,cascade = CascadeType.ALL,mappedBy = "companyEntity")
    private List<Car> cars = new LinkedList<>();

}


