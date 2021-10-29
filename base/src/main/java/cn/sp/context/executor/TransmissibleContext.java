package cn.sp.context.executor;

/**
 * @author Ship
 * @version 1.0.0
 * @description
 * @date 2021/10/29 13:50
 */
public interface TransmissibleContext<T> {

    /**
     * 设置上下文
     *
     * @param t
     */
    void set(T t);

    /**
     * 获取上下文
     *
     * @return
     */
    T get();

    /**
     * 删除上下文
     */
    void remove();

}
