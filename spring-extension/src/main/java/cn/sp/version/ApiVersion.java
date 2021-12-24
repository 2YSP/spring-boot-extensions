package cn.sp.version;

import java.lang.annotation.*;

/**
 * @Author: Ship
 * @Description: api版本注解
 * @Date: Created in 2021/12/23
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
public @interface ApiVersion {

    /**
     * 指定API版本,最多两位如1.0
     * @return
     */
    String value() default "";
}
