package cn.sp.condition.annotation;

import cn.sp.condition.OnAnyMatchCondition;
import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/**
 * @Author: Ship
 * @Description: 任意name-value匹配即可
 * @Date: Created in 2021/10/18
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Conditional(value = OnAnyMatchCondition.class)
public @interface ConditionalOnAnyMatch {

    String[] name() default {};

    String[] value() default {};
}
