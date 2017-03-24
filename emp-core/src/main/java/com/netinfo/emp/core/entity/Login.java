package com.netinfo.emp.core.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.TimeZone;

/**
 * Project emp-core
 * Package com.netinfo.emp.core.entity
 * <p>
 * Created by Charley on 2017/3/23.
 */
public class Login {
    private long id;
    private long userId;
    private Date loginTime;
    private String result;
    private String token;
    private String host;
    private String address;
    private boolean isExited;
    private String exitedMethod;
    private Date exitedTime;
    private Date lastActiveTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isExited() {
        return isExited;
    }

    public void setExited(boolean exited) {
        isExited = exited;
    }

    public String getExitedMethod() {
        return exitedMethod;
    }

    public void setExitedMethod(String exitedMethod) {
        this.exitedMethod = exitedMethod;
    }

    public Date getExitedTime() {
        return exitedTime;
    }

    public void setExitedTime(Date exitedTime) {
        this.exitedTime = exitedTime;
    }

    public Date getLastActiveTime() {
        return lastActiveTime;
    }

    public void setLastActiveTime(Date lastActiveTime) {
        this.lastActiveTime = lastActiveTime;
    }

    public static Login fromT(Map<String, Object> map) throws ParseException {
        Login login = new Login();
        login.setId((long) map.get("system_id"));
        login.setUserId((long) map.get("account_id"));
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        format.setTimeZone(TimeZone.getTimeZone("GMT"));
        login.setLoginTime(format.parse(map.get("login_time").toString()));
        login.setResult(map.get("login_result").toString());
        login.setToken(map.get("login_token").toString());
        if (map.get("login_host") != null) {
            login.setHost(map.get("login_host").toString());
        }
        if (map.get("login_address") != null) {
            login.setAddress(map.get("login_address").toString());
        }
        if (map.get("is_exited") != null && map.get("is_exited").toString() == "1") {
            login.setExited(true);
        } else {
            login.setExited(false);
        }
        if (map.get("exited_method") != null) {
            login.setExitedMethod(map.get("exited_method").toString());
        }
        if (map.get("exited_time") != null) {
            login.setExitedTime(format.parse(map.get("exited_method").toString()));
        }
        if (map.get("last_interactive_time") != null) {
            login.setLastActiveTime(format.parse(map.get("last_interactive_time").toString()));
        }
        return login;
    }
}
