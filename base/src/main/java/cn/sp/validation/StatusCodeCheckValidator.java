package cn.sp.validation;


import com.google.common.collect.Lists;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Ship
 * @version 1.0.0
 * @description:
 * @date 2021/11/10 17:06
 */
public class StatusCodeCheckValidator implements ConstraintValidator<StatusCodeCheck, Object> {

    private Class<? extends StatusCode> enumClass;
    /**
     * 枚举缓存
     */
    private static final Map<Class<? extends StatusCode>, List<StatusCode>> CACHE_MAP = new ConcurrentHashMap<>(64);

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
        List<StatusCode> statusCodeList = CACHE_MAP.computeIfAbsent(enumClass, (key) -> {
            try {
                Method method = key.getDeclaredMethod("values");
                StatusCode[] statusCodes = (StatusCode[]) method.invoke(null);
                return Stream.of(statusCodes).collect(Collectors.toList());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return Lists.newArrayList();
        });
        for (StatusCode statusCode : statusCodeList) {
            if (statusCode.getCode().equals(object)) {
                return true;
            }
        }
        return false;
    }
}
