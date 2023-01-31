package cn.sp.condition.test;

import cn.sp.condition.annotation.ConditionalOnAnyMatch;
import cn.sp.condition.annotation.ConditionalOnWindowsOrMac;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Ship
 * @Description:
 * @Date: Created in 2021/10/18
 */
@Configuration
public class TestConfiguration {

    @Bean
    @ConditionalOnAnyMatch(name = {"test.aa", "test.bb"}, value = {"1", "2"})
    public TestBean testBean() {
        System.out.println("Initialized bean:testBean...");
        return new TestBean();
    }

    //    @ConditionalOnWindowsAndMac
    @ConditionalOnWindowsOrMac
//    @ConditionalOnNotWindows
    @Bean
    public MyBean myBean() {
        System.out.println("Initialized bean:myBean...");
        return new MyBean();
    }
}
