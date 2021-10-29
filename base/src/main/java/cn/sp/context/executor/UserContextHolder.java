package cn.sp.context.executor;

import org.springframework.stereotype.Component;

/**
 * @author Ship
 * @version 1.0.0
 * @description
 * @date 2021/10/29 13:53
 */
@Component
public class UserContextHolder implements TransmissibleContext<UserContext> {

    private static final ThreadLocal<UserContext> THREAD_LOCAL = InheritableThreadLocal.withInitial(() -> new UserContext());

    @Override
    public void set(UserContext userContext) {
        THREAD_LOCAL.set(userContext);
    }

    @Override
    public UserContext get() {
        return THREAD_LOCAL.get();
    }

    @Override
    public void remove() {
        THREAD_LOCAL.remove();
    }
}
