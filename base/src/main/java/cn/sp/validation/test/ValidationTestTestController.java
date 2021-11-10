package cn.sp.validation.test;

import cn.sp.validation.ValidationTest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author Ship
 * @version 1.0.0
 * @description:
 * @date 2021/11/10 17:42
 */
@RequestMapping("/validation")
@RestController
public class ValidationTestTestController {


    @PostMapping("/test")
    public void test(@RequestBody @Validated ValidationTest validationTest) {
        System.out.println("validation test");
    }
}
