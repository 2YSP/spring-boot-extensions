package cn.sp.validation;


/**
 * @author Ship
 * @version 1.0.0
 * @description
 * @date 2021/11/02 11:25
 */
public enum ThirdPartyPlatformEnum implements StatusCode<String> {

    /**
     * 拼多多
     */
    PDD("PDD", "拼多多"),
    /**
     * 天猫
     */
    TIAN_MALL("TIAN_MALL", "天猫"),
    /**
     * 有赞
     */
    YOU_ZAN("YOU_ZAN", "有赞"),
    /**
     * 美团
     */
    MEI_TUAN("MEI_TUAN", "美团");


    private String code;

    private String desc;

    ThirdPartyPlatformEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @Override
    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }


    /**
     * 校验code是否合法
     *
     * @param code
     * @return true=正确
     */
    public static boolean checkCode(String code) {
        ThirdPartyPlatformEnum[] values = values();
        for (ThirdPartyPlatformEnum platformEnum : values) {
            if (platformEnum.getCode().equals(code)) {
                return true;
            }
        }
        return false;
    }


}
