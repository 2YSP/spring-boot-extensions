package cn.sp.validation;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Method;

/**
 * @author Ship
 * @version 1.0.0
 * @description:
 * @date 2021/11/10 17:06
 */
public class StatusCodeCheckValidator implements ConstraintValidator<StatusCodeCheck, Object> {

    private Class<? extends StatusCode> enumClass;

    @Override
    public void initialize(StatusCodeCheck constraintAnnotation) {
        this.enumClass = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext constraintValidatorContext) {
        if (object == null) {
            return false;
        }
        if (!enumClass.isEnum()) {
            throw new RuntimeException("StatusCode 的实现类必须是枚举类型");
        }
        try {
            Method method = enumClass.getDeclaredMethod("values");
            StatusCode[] statusCodes = (StatusCode[]) method.invoke(null);
            for (StatusCode statusCode : statusCodes) {
                if (statusCode.getCode().equals(object)) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }
}
