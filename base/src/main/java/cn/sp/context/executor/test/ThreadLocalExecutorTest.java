package cn.sp.context.executor.test;

import cn.sp.context.executor.ThreadLocalExecutor;
import cn.sp.context.executor.UserContext;
import cn.sp.context.executor.UserContextHolder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Ship
 * @version 1.0.0
 * @description
 * @date 2021/10/29 16:34
 */
@Component
public class ThreadLocalExecutorTest implements CommandLineRunner {

    public static final ThreadPoolExecutor POOL = new
            ThreadPoolExecutor(4, 8, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<>(512));

    final ThreadLocalExecutor executor = new ThreadLocalExecutor(POOL);

    @Resource
    private UserContextHolder userContextHolder;

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 100; i++) {
            userContextHolder.set(new UserContext("userId" + i));
            int a = i;
            executor.execute(() -> {
                System.out.println(Thread.currentThread().getName() + ", userId:" + userContextHolder.get().getUserId() + " ,i:" + a);
                try {
                    // 模拟执行业务逻辑
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        Thread.sleep(10000);
    }


}
