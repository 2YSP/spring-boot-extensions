package cn.sp.context.threadlocal;

/**
 * @author Ship
 * @version 1.0.0
 * @description
 * @date 2021/10/28 11:21
 */
public class RequestContextHolder {

    private static TransmissibleThreadLocal<RequestContext> threadLocal = new TransmissibleThreadLocal<>();

    public static RequestContext get() {
        return threadLocal.get();
    }

    public static void set(RequestContext requestContext) {
        threadLocal.set(requestContext);
    }

    public static void remove() {
        threadLocal.remove();
    }
}
