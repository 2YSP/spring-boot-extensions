package cn.sp.context.test;

import cn.sp.context.RequestContext;
import cn.sp.context.RequestContextHolder;
import cn.sp.context.TransmissibleRunnable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Ship
 * @version 1.0.0
 * @description
 * @date 2021/10/28 11:24
 */
@Component
public class RequestContextTest implements CommandLineRunner {

    private static final ThreadPoolExecutor POOL = new
            ThreadPoolExecutor(4, 8, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<>(512));

    @Override
    public void run(String... args) throws Exception {
        RequestContext requestContext = new RequestContext();
        requestContext.setUserId("1234");
        RequestContextHolder.set(requestContext);
        TransmissibleRunnable runnable = new TransmissibleRunnable(() -> {
            System.out.println("=========" + Thread.currentThread().getName() + ", userId:" + RequestContextHolder.get().getUserId());
            try {
                // 模拟执行业务逻辑
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        for (int i = 0; i < 100; i++) {
            POOL.execute(runnable);
        }
        while (!POOL.awaitTermination(1L, TimeUnit.SECONDS)) {

        }
        System.out.println("RequestContextTest over");
    }
}
