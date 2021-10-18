package cn.sp.config;

import cn.sp.annotation.ConditionalOnAnyMatch;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Author: Ship
 * @Description:
 * @Date: Created in 2021/10/18
 */
@ConditionalOnAnyMatch(name = {"test.aa", "test.bb"}, value = {"1", "2"})
@Component
public class TestClassBean {

    @PostConstruct
    public void init(){
        System.out.println("Initialized bean:testClassBean...");
    }
}
