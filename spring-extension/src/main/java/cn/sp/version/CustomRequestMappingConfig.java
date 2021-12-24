package cn.sp.version;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * @Author: Ship
 * @Description: 覆盖Spring原生的RequestMappingHandlerMapping
 * @Date: Created in 2021/12/23
 */
@Configuration
public class CustomRequestMappingConfig implements WebMvcRegistrations {

    @Override
    public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
        CustomRequestMappingHandlerMapping customRequestMappingHandlerMapping = new CustomRequestMappingHandlerMapping();
        customRequestMappingHandlerMapping.setOrder(0);
        return customRequestMappingHandlerMapping;
    }
}
