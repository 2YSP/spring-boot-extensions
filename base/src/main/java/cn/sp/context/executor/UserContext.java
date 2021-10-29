package cn.sp.context.executor;

/**
 * @author Ship
 * @version 1.0.0
 * @description
 * @date 2021/10/29 13:52
 */
public class UserContext {

    private String userId;


    public UserContext() {
    }

    public UserContext(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
