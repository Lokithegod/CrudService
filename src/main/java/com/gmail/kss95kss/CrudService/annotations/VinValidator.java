package com.gmail.kss95kss.CrudService.annotations;

import com.gmail.kss95kss.CrudService.exception.IncorrectVinCodeException;
import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Slf4j
public class VinValidator implements ConstraintValidator<VinValidation, String> {

    final String regex = "\\b[(A-H|J-N|P|R-Z|0-9)]{17}\\b";

    @Override
    public void initialize(VinValidation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String vin, ConstraintValidatorContext context) {
        var response = vin.matches(regex);
        if (response) {
            return vin != null && vin.matches(regex);
        } else {
            String message = "The VIN number on a vehicle is a 17 alpha-numeric characters and must NOT contain the letters I, O or Q (to avoid confusion with the similar looking digits). \n" +
                    "So, for example, SALVA2AE4EH877322 is valid, but "+vin+"} is not.\n";
            throw new IncorrectVinCodeException(message);
        }
    }
}
