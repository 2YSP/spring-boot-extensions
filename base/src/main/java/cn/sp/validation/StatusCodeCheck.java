package cn.sp.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author Ship
 * @version 1.0.0
 * @description:
 * @date 2021/11/10 16:52
 */
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = StatusCodeCheckValidator.class)
@Documented
public @interface StatusCodeCheck {

    String message() default "{cn.sp.validation.StatusCode.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    Class<? extends StatusCode> value();
}
