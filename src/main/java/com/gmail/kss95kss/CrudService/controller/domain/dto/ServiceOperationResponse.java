package com.gmail.kss95kss.CrudService.controller.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.gmail.kss95kss.CrudService.model.Car;
import com.gmail.kss95kss.CrudService.model.Company;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@DynamicUpdate
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServiceOperationResponse {
    @JsonProperty("car")
    private List<Car> car;

    @JsonProperty("company")
    private Company company;

    @JsonProperty("error")
    private ErrorResponse errorResponse;

    public ServiceOperationResponse(List<Car> car) {
        this.car = car;
    }

    public ServiceOperationResponse(Company company) {
        this.company = company;
    }

    public ServiceOperationResponse(ErrorResponse errorResponse) {
        this.errorResponse = errorResponse;
    }
}
