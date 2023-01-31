package cn.sp.condition.nested;

import cn.sp.condition.OnWindowsCondition;
import org.springframework.boot.autoconfigure.condition.NoneNestedConditions;
import org.springframework.context.annotation.Conditional;

/**
 * @author Ship
 * @version 1.0.0
 * @description: 只有当所有条件都不满足时，bean才会被加载
 * @date 2023/01/31 10:27
 */
public class OnNotWindowsCondition extends NoneNestedConditions {

    public OnNotWindowsCondition() {
        super(ConfigurationPhase.REGISTER_BEAN);
    }

    @Conditional(OnWindowsCondition.class)
    static class OnWindows {

    }
}
