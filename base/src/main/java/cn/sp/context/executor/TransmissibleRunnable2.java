package cn.sp.context.executor;


/**
 * @author Ship
 * @version 1.0.0
 * @description
 * @date 2021/10/29 15:54
 */
public final class TransmissibleRunnable2 implements Runnable {

    private Runnable delegate;

    private ContextManager contextManager;

    public TransmissibleRunnable2(Runnable runnable) {
        this.delegate = runnable;
        this.contextManager = new ContextManager();
    }

    @Override
    public void run() {
        try {
            contextManager.set();
            delegate.run();
        } finally {
            contextManager.remove();
        }
    }
}
