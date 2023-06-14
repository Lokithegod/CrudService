package com.gmail.kss95kss.CrudService.controller.domain.validation;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public enum CarName {
    AUDI("AUDI"),
    ACURA("ACURA"),
    BMW("BMW"),
    CHEVROLET("CHEVROLET"),
    GMC("GMC"),
    HONDA("HONDA"),
    JEEP("JEEP"),
    MERCEDES("MERCEDES"),
    NISSAN("NISSAN"),
    OPEL("OPEL"),
    PEUGEOT("PEUGEOT"),
    RENAULT("RENAULT"),
    SEAT("SEAT"),
    SKODA("SKODA"),
    SUBARU("SUBARU"),
    VOLKSWAGEN("VOLKSWAGEN"),
    VOLVO("VOLVO");

    private String value;

    CarName(String value) {
        this.value = value;
    }
}
