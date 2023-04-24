package com.example.SpringBootDemoApplication.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target( { ElementType.METHOD, ElementType.FIELD } )
@Retention( RetentionPolicy.RUNTIME )
@Constraint( validatedBy = PasswordRuleValidator.class )
public @interface Password {
    /**
     * Defines the message that needs to be displayed if the input data validation fails.
     */
    String message() default "Password does not adhere to the specified rule";

    /**
     * Allow the developer to select to split the annotations into different groups to apply
     * different validations to each group. We haven't defined any groups in this example.
     */
    Class<?>[] groups() default {};

    /**
     * Used to carry metadata information consumed by a validation client. We haven't defined any
     * payload in this example.
     */
    Class <? extends Payload>[] payload() default {};
}
