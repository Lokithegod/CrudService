package com.gmail.kss95kss.CrudService.model;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "company")
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@DynamicUpdate
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "about")
    private String about;

    @Column(name = "rating")
    private Double rating;

    @OneToMany(fetch = FetchType.EAGER,orphanRemoval = true,cascade = CascadeType.REMOVE,mappedBy = "companyEntity")
    private List<Car> cars = new LinkedList<>();

}


