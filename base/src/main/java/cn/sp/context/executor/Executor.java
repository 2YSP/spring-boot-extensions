package cn.sp.context.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/**
 * @author Ship
 * @version 1.0.0
 * @description
 * @date 2021/10/29 13:44
 */
public interface Executor {

    /**
     *
     * @param command
     */
    void execute(Runnable command);

    <T> Future<T> submit(Callable<T> task);
}
