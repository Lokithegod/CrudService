package com.gmail.kss95kss.CrudService.annotations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;

@Target({FIELD, PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = VinValidator.class)
@Documented
public @interface  VinValidation {

    String message() default  "The VIN number on a vehicle is a 17 alpha-numeric characters and must NOT contain the letters I, O or Q (to avoid confusion with the similar looking digits). \n" +
            "So, for example, SALVA2AE4EH877322 is valid, but SALVO2AE4EH877322 is not.\n" +
            "By using the \\\\b word boundary token, we can match in quotes \"SALVA2AE4EH877482\", brackets (SALVA2AE4EH877998) or other boundaries that people may use <SALVA2AE4EH877002>";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
