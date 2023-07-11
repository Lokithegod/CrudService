package com.gmail.kss95kss.CrudService.controller.domain.validation;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public enum CarType {
    SEDAN("SEDAN"),
    HATCHBACK("HATCHBACK"),
    CROSSOVER("CROSSOVER");

    private String value;

    CarType(String value) {
        this.value = value;
    }
}
