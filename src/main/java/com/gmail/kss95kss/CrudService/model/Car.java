package com.gmail.kss95kss.CrudService.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gmail.kss95kss.CrudService.controller.domain.validation.CarName;
import com.gmail.kss95kss.CrudService.controller.domain.validation.CarType;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
@ToString
@Table(name = "car")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@DynamicUpdate
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotNull
    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    private CarName name;
    @NotNull
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private CarType type;
    @NotBlank
    @Column(name = "model")
    private String model;
    @NotBlank
    @Column(name = "year")
    private String year;
    @Positive
    @Column(name = "mileage")
    private int mileage;
    @Positive
    @Column(name = "price")
    private int price;
    @NotBlank
    @Column(name = "equipment")
    private String equipment;
    @NotBlank
    @Column(name = "about")
    private String about;
    @NotNull
    @Positive
    @Column(name = "rating")
    private Double rating;
    @NotBlank
    @Column(name = "vin")
    private String vin_code;

    @ManyToOne(fetch = FetchType.EAGER)
    @ToString.Exclude
    @JsonIgnore
    private Company companyEntity;
}
