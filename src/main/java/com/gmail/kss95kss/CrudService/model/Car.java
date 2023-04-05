package com.gmail.kss95kss.CrudService.model;


import lombok.ToString;

import javax.persistence.*;

@Entity
@ToString
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "model")
    private String model;

    @Column(name = "year")
    private int year;

    @Column(name = "mileage")
    private int mileage;

    @Column(name = "price")
    private int price;

    @Column(name = "equipment")
    private String equipment;

    @Column(name = "about")
    private String about;

    @Column(name = "rating")

    private Double rating;
    @ManyToOne(fetch = FetchType.EAGER)
    @ToString.Exclude
    private Company companyEntity;
}
