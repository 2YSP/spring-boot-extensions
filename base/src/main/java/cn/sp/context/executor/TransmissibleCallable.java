package cn.sp.context.executor;

import java.util.concurrent.Callable;

/**
 * @author Ship
 * @version 1.0.0
 * @description
 * @date 2021/10/29 16:27
 */
public final class TransmissibleCallable<T> implements Callable<T> {

    private ContextManager contextManager;

    private Callable<T> task;

    public TransmissibleCallable(Callable<T> callable) {
        this.contextManager = new ContextManager();
        this.task = callable;
    }

    @Override
    public T call() throws Exception {
        try {
            contextManager.set();
            return task.call();
        } finally {
            contextManager.remove();
        }
    }
}
