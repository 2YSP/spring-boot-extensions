package cn.sp.validation;

/**
 * @author Ship
 * @version 1.0.0
 * @description:
 * @date 2021/11/10 16:50
 */
public class ValidationTest {

    @StatusCodeCheck(message = "无效的第三方平台类型", value = ThirdPartyPlatformEnum.class)
    private String thirdPartyPlatform;


    public String getThirdPartyPlatform() {
        return thirdPartyPlatform;
    }

    public void setThirdPartyPlatform(String thirdPartyPlatform) {
        this.thirdPartyPlatform = thirdPartyPlatform;
    }
}
