package com.gmail.kss95kss.CrudService.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "model")
    private String model;

    @Column(name = "year")
    private Date year;

    @Column(name = "mileage")
    private int mileage;

    @Column(name = "price")
    private int price;

    @Column(name = "equipment")
    private String equipment;

    @Column(name = "company")
    private int company;

    @Column(name = "about")
    private String about;

    @Column(name = "rating")
    private Double rating;
}
