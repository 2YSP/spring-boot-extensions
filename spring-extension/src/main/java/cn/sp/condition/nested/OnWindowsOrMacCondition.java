package cn.sp.condition.nested;

import cn.sp.condition.OnMacCondition;
import cn.sp.condition.OnWindowsCondition;
import org.springframework.boot.autoconfigure.condition.AnyNestedCondition;
import org.springframework.context.annotation.Conditional;

/**
 * @author Ship
 * @version 1.0.0
 * @description: 只要有一个条件满足时，bean就会被加载
 * @date 2023/01/31 10:27
 */
public class OnWindowsOrMacCondition extends AnyNestedCondition {

    public OnWindowsOrMacCondition() {
        super(ConfigurationPhase.REGISTER_BEAN);
    }

    @Conditional(OnWindowsCondition.class)
    static class OnWindows{

    }

    @Conditional(OnMacCondition.class)
    static class OnMac{

    }
}
