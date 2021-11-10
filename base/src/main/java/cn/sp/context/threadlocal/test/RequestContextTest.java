package cn.sp.context.threadlocal.test;

import cn.sp.context.threadlocal.RequestContext;
import cn.sp.context.threadlocal.RequestContextHolder;
import cn.sp.context.threadlocal.TransmissibleRunnable;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
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
@ConditionalOnProperty(value = "test.request-context.enable", havingValue = "true")
@Component
public class RequestContextTest implements CommandLineRunner {

    public static final ThreadPoolExecutor POOL = new
            ThreadPoolExecutor(4, 8, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<>(512),
            new ThreadFactoryBuilder().setNameFormat("RequestContextTest-%d").build());

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
        Thread.sleep(10000);
        System.out.println("RequestContextTest over");
    }
}
