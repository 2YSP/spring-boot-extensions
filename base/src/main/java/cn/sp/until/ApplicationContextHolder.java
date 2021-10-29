package cn.sp.until;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Ship
 * @version 1.0.0
 * @description
 * @date 2021/10/29 13:59
 */
@Component
public class ApplicationContextHolder implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ApplicationContextHolder.applicationContext = applicationContext;
    }

    /**
     * 根据类型获取bean
     *
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> clazz) {
        checkApplicationContext();
        return applicationContext.getBean(clazz);
    }

    /**
     * 根据名称获取bean
     *
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName) {
        checkApplicationContext();
        return applicationContext.getBean(beanName);
    }

    /**
     * 根据类型获取bean
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> List<T> getBeansByType(Class<T> clazz) {
        checkApplicationContext();
        Map<String, T> beanMap = applicationContext.getBeansOfType(clazz);
        if (beanMap == null) {
            return null;
        }
        return beanMap.values().stream().collect(Collectors.toList());
    }


    private static void checkApplicationContext() {
        if (applicationContext == null) {
            throw new IllegalArgumentException("applicationContext is null!");
        }
    }
}
