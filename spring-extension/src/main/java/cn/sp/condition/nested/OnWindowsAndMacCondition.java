package cn.sp.condition.nested;

import cn.sp.condition.OnMacCondition;
import cn.sp.condition.OnWindowsCondition;
import org.springframework.boot.autoconfigure.condition.AllNestedConditions;
import org.springframework.context.annotation.Conditional;

/**
 * @author Ship
 * @version 1.0.0
 * @description: 只有当所有条件都满足时，bean才会被加载
 * @date 2023/01/31 10:27
 */
public class OnWindowsAndMacCondition extends AllNestedConditions {

    public OnWindowsAndMacCondition() {
        super(ConfigurationPhase.REGISTER_BEAN);
    }

    @Conditional(OnWindowsCondition.class)
    static class OnWindows{

    }

    @Conditional(OnMacCondition.class)
    static class OnMac{

    }
}
