package cn.sp.version;

import org.springframework.web.servlet.mvc.condition.RequestCondition;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: Ship
 * @Description:
 * @Date: Created in 2021/12/23
 */
public class ApiVersionCondition implements RequestCondition<ApiVersionCondition> {

    public ApiVersion apiVersion;

    public ApiVersionCondition(ApiVersion apiVersion) {
        this.apiVersion = apiVersion;
    }

    @Override
    public ApiVersionCondition combine(ApiVersionCondition other) {
        return new ApiVersionCondition(other.apiVersion);
    }

    /**
     * 用于判断当前匹配条件和请求是否匹配；如果不匹配返回null
     *
     * @param request
     * @return
     */
    @Override
    public ApiVersionCondition getMatchingCondition(HttpServletRequest request) {
        String version = request.getHeader("Api-Version");
        Double thisVersion = Double.valueOf(apiVersion.value());
        Double requestVersion = Double.valueOf(version);
        if (requestVersion.compareTo(thisVersion) >= 0) {
            // 如果请求的版本号小于等于 配置的版本则满足
            return this;
        }
        return null;
    }

    /**
     * 优先级
     *
     * @param other
     * @param request
     * @return
     */
    @Override
    public int compareTo(ApiVersionCondition other, HttpServletRequest request) {
        Double otherVersion = Double.valueOf(other.apiVersion.value());
        Double version = Double.valueOf(apiVersion.value());
        if (otherVersion > version) {
            return 1;
        } else if (otherVersion < version) {
            return -1;
        } else {
            return 0;
        }
    }
}
