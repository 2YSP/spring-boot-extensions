package cn.sp.condition;

import cn.sp.annotation.ConditionalOnAnyMatch;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.annotation.MergedAnnotation;
import org.springframework.core.annotation.MergedAnnotations;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @Author: Ship
 * @Description:
 * @Date: Created in 2021/10/18
 */
public class OnAnyMatchCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Environment environment = context.getEnvironment();
        MergedAnnotations annotations = metadata.getAnnotations();
        if (!annotations.isPresent(ConditionalOnAnyMatch.class)) {
            return true;
        }
        MergedAnnotation<ConditionalOnAnyMatch> annotation = annotations.get(ConditionalOnAnyMatch.class);
        String[] names = annotation.getValue("name", String[].class).orElse(new String[]{});
        String[] values = annotation.getValue("value", String[].class).orElse(new String[]{});
        for (int i = 0; i < names.length; i++) {
            String property = environment.getProperty(names[i]);
            String value = values[i];
            if (value != null && value.equals(property)) {
                return true;
            }
        }
        return false;
    }
}
