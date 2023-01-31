package cn.sp.condition;

import org.apache.commons.lang3.SystemUtils;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author Ship
 * @version 1.0.0
 * @description:
 * @date 2023/01/31 10:20
 */
public class OnWindowsCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return SystemUtils.IS_OS_WINDOWS;
    }
}
