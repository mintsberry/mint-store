package com.mint.store.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author MintsBerry
 * @date 2020/8/24
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
@Constraint(validatedBy = {TokenValidator.class})
public @interface TokenPassword {
  String message() default "字段不符合";
  int min() default 6;
  int max() default 32;
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};
}
