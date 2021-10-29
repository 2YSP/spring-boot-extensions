package cn.sp.context.executor;

import cn.sp.utils.ApplicationContextHolder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ship
 * @version 1.0.0
 * @description
 * @date 2021/10/29 13:49
 */
public class ContextManager {

    private static List<? extends TransmissibleContext> contextList = ApplicationContextHolder.getBeansByType(TransmissibleContext.class);

    private Map<Class<? extends TransmissibleContext>, Object> contextValueMap;

    public ContextManager() {
        // 主线程
        initContextValueMap();
    }

    private void initContextValueMap() {
        this.contextValueMap = new HashMap<>(64);
        for (TransmissibleContext context : contextList) {
            this.contextValueMap.put(context.getClass(), context.get());
        }
    }

    public void set() {
        // 子线程
        for (TransmissibleContext context : contextList) {
            context.set(contextValueMap.get(context.getClass()));
        }
    }

    public void remove() {
        for (TransmissibleContext context : contextList) {
            context.remove();
        }
    }
}
