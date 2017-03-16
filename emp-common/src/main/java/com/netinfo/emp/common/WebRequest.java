package com.netinfo.emp.common;

/**
 * Web 请求的参数类型
 * <p>
 * Project emp-common
 * Package com.netinfo.emp.common
 * <p>
 * Created by Charley on 2017/3/9.
 */
public class WebRequest {
    private String appId;
    private String userToken;
    private String requestToken;
    private String timestamp;

    /**
     * 获取AppId
     *
     * @return AppId
     */
    public String getAppId() {
        return appId;
    }

    /**
     * 设置AppId
     *
     * @param appId AppId
     */
    public void setAppId(String appId) {
        this.appId = appId;
    }

    /**
     * 获取UserToken
     *
     * @return UserToken
     */
    public String getUserToken() {
        return userToken;
    }

    /**
     * 设置UserToken
     *
     * @param userToken UserToken
     */
    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    /**
     * 获取RequestToken
     *
     * @return RequestToken
     */
    public String getRequestToken() {
        return requestToken;
    }

    /**
     * 设置RequestToken
     *
     * @param requestToken RequestToken
     */
    public void setRequestToken(String requestToken) {
        this.requestToken = requestToken;
    }

    /**
     * 获取Timestamp
     *
     * @return Timestamp
     */
    public String getTimestamp() {
        return timestamp;
    }

    /**
     * 设置Timestamp
     *
     * @param timestamp Timestamp
     */
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
