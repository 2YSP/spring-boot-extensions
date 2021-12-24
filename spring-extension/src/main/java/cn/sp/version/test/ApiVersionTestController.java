package cn.sp.version.test;

import cn.sp.version.ApiVersion;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Ship
 * @Description:
 * @Date: Created in 2021/12/23
 */
@RequestMapping("/apiVersion")
@RestController
public class ApiVersionTestController {

    @ApiVersion("1.0")
    @RequestMapping("/test")
    public String v1(){
        return "v1";
    }

    @ApiVersion("2.0")
    @RequestMapping("/test")
    public String v2(){
        return "v2";
    }

    @ApiVersion("3.0")
    @RequestMapping("/test")
    public String v3(){
        return "v3";
    }
}
