package cn.sp.context.threadlocal;

import java.util.HashMap;

/**
 * @author Ship
 * @version 1.0.0
 * @description
 * @date 2021/10/28 10:45
 */
public class TransmissibleRunnable implements Runnable {

    private Runnable runnable;

    private HashMap<TransmissibleThreadLocal<Object>, Object> threadLocalCopy;


    public TransmissibleRunnable(Runnable runnable) {
        this.runnable = runnable;
        this.threadLocalCopy = copyFatherThreadLocal();
    }

    @Override
    public void run() {
        // 塞入父threadlocal，并返回当前线程原先threadlocal的value
        Object backup = setThreadLocal(threadLocalCopy);
        try {
            runnable.run();
        } finally {
            restore(backup);
        }
    }

    /**
     * 复原当前线程的上下文
     * @param backup
     */
    private void restore(Object backup) {
        TransmissibleThreadLocal threadLocal = new TransmissibleThreadLocal();
        threadLocal.set(backup);
    }

    private Object setThreadLocal(HashMap<TransmissibleThreadLocal<Object>, Object> threadLocalCopy) {
        TransmissibleThreadLocal threadLocal = new TransmissibleThreadLocal();
        Object obj = threadLocal.get();
//        threadLocalCopy.put(threadLocal, obj);
        return obj;
    }


    private static HashMap<TransmissibleThreadLocal<Object>, Object> copyFatherThreadLocal() {
        HashMap<TransmissibleThreadLocal<Object>, Object> fatherMap = new HashMap<>(64);
        for (TransmissibleThreadLocal<Object> threadLocal : TransmissibleThreadLocal.HOLDER.get().keySet()) {
            fatherMap.put(threadLocal, threadLocal.copyValue());
        }
        return fatherMap;
    }
}
