package cn.sp.condition.annotation;

import cn.sp.condition.nested.OnWindowsAndMacCondition;
import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/**
 * @author Ship
 * @version 1.0.0
 * @description: 条件之是windows且mac系统
 * @date 2023/01/31 10:19
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Conditional(value = OnWindowsAndMacCondition.class)
public @interface ConditionalOnWindowsAndMac {

}
