package cn.sp.context;

import java.util.WeakHashMap;

/**
 * @author Ship
 * @version 1.0.0
 * @description
 * @date 2021/10/28 10:47
 */
public class TransmissibleThreadLocal<T> extends InheritableThreadLocal<T> {
    /**
     * 使用WeakHashMap防止内存泄漏
     */
    public static final ThreadLocal<WeakHashMap<TransmissibleThreadLocal<Object>, ?>> HOLDER = ThreadLocal.withInitial(() -> new WeakHashMap<>());

    @Override
    public void set(T value) {
        super.set(value);
        // 将当前的TransmissibleThreadLocal对象塞到HOLDER中
        addThisToHolder();
    }


    private void addThisToHolder() {
        WeakHashMap<TransmissibleThreadLocal<Object>, ?> map = HOLDER.get();
        if (!map.containsKey(this)) {
            map.put((TransmissibleThreadLocal<Object>) this, null);
        }
    }

    public Object copyValue() {
        return super.get();
    }

    @Override
    public void remove() {
        removeFormThisHolder();
        super.remove();
    }

    private void removeFormThisHolder() {
        HOLDER.get().remove(this);
    }
}
