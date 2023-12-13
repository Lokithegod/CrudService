package com.gmail.kss95kss.CrudService.controller.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.gmail.kss95kss.CrudService.annotations.VinValidation;
import com.gmail.kss95kss.CrudService.controller.domain.validation.CarName;
import com.gmail.kss95kss.CrudService.controller.domain.validation.CarType;
import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarDto {
    private int id;
    @NotNull
    private CarName name;
    @NotNull(message = "")
    private CarType type;
    private String model;
    @NotNull
    @Min(value = 1800, message = "Value must have a minimum of 4 digits")
    @Max(value = 2023, message = "Value can have a maximum of 4 digits")
    private Integer year;
    private Integer mileage;
    @Positive
    private Integer price;
    private String equipment;
    private String about;
    private Double rating;
    @JsonProperty("vin_code")
    @VinValidation
    private String vin;
}
