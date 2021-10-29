package cn.sp.context.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Ship
 * @version 1.0.0
 * @description
 * @date 2021/10/29 13:47
 */
public class ThreadLocalExecutor implements Executor {

    private ThreadPoolExecutor delegate;

    public ThreadLocalExecutor(ThreadPoolExecutor threadPoolExecutor) {
        this.delegate = threadPoolExecutor;
    }

    @Override
    public void execute(Runnable command) {
        this.delegate.execute(new TransmissibleRunnable2(command));
    }

    @Override
    public <T> Future<T> submit(Callable<T> task) {
        return this.delegate.submit(new TransmissibleCallable(task));
    }


}
