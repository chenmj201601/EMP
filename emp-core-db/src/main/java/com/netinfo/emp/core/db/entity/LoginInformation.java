package com.netinfo.emp.core.db.entity;

import javax.persistence.*;

/**
 * Project charley-web-09
 * Package com.netinfo.emp.core.db.entity
 * <p>
 * Created by Charley on 2017/3/22.
 */
@Entity
@Table(name = "LOGIN_INFORMATION")
public class LoginInformation {
    private long systemId;
    private long accountId;
    private long loginTime;
    private String loginResult;
    private String tokenKey;
    private String loginHost;
    private String loginAddress;
    private String isExited;
    private String exitedMethod;
    private long exitedTime;
    private long lastInteractionTime;

    @Id
    @Column(name = "SYSTEM_ID")
    public long getSystemId() {
        return systemId;
    }

    public void setSystemId(long systemId) {
        this.systemId = systemId;
    }

    @Basic
    @Column(name = "ACCOUNT_ID")
    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    @Basic
    @Column(name = "LOGIN_TIME")
    public long getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(long loginTime) {
        this.loginTime = loginTime;
    }

    @Basic
    @Column(name = "LOGIN_RESULT")
    public String getLoginResult() {
        return loginResult;
    }

    public void setLoginResult(String loginResult) {
        this.loginResult = loginResult;
    }

    @Basic
    @Column(name = "TOKEN_KEY")
    public String getTokenKey() {
        return tokenKey;
    }

    public void setTokenKey(String tokenKey) {
        this.tokenKey = tokenKey;
    }

    @Basic
    @Column(name = "LOGIN_HOST")
    public String getLoginHost() {
        return loginHost;
    }

    public void setLoginHost(String loginHost) {
        this.loginHost = loginHost;
    }

    @Basic
    @Column(name = "LOGIN_ADDRESS")
    public String getLoginAddress() {
        return loginAddress;
    }

    public void setLoginAddress(String loginAddress) {
        this.loginAddress = loginAddress;
    }

    @Basic
    @Column(name = "IS_EXITED")
    public String getIsExited() {
        return isExited;
    }

    public void setIsExited(String isExited) {
        this.isExited = isExited;
    }

    @Basic
    @Column(name = "EXITED_METHOD")
    public String getExitedMethod() {
        return exitedMethod;
    }

    public void setExitedMethod(String exitedMethod) {
        this.exitedMethod = exitedMethod;
    }

    @Basic
    @Column(name = "EXITED_TIME")
    public long getExitedTime() {
        return exitedTime;
    }

    public void setExitedTime(long exitedTime) {
        this.exitedTime = exitedTime;
    }

    @Basic
    @Column(name = "LAST_INTERACTION_TIME")
    public long getLastInteractionTime() {
        return lastInteractionTime;
    }

    public void setLastInteractionTime(long lastInteractionTime) {
        this.lastInteractionTime = lastInteractionTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LoginInformation that = (LoginInformation) o;

        if (systemId != that.systemId) return false;
        if (accountId != that.accountId) return false;
        if (loginTime != that.loginTime) return false;
        if (exitedTime != that.exitedTime) return false;
        if (lastInteractionTime != that.lastInteractionTime) return false;
        if (loginResult != null ? !loginResult.equals(that.loginResult) : that.loginResult != null) return false;
        if (tokenKey != null ? !tokenKey.equals(that.tokenKey) : that.tokenKey != null) return false;
        if (loginHost != null ? !loginHost.equals(that.loginHost) : that.loginHost != null) return false;
        if (loginAddress != null ? !loginAddress.equals(that.loginAddress) : that.loginAddress != null) return false;
        if (isExited != null ? !isExited.equals(that.isExited) : that.isExited != null) return false;
        if (exitedMethod != null ? !exitedMethod.equals(that.exitedMethod) : that.exitedMethod != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (systemId ^ (systemId >>> 32));
        result = 31 * result + (int) (accountId ^ (accountId >>> 32));
        result = 31 * result + (int) (loginTime ^ (loginTime >>> 32));
        result = 31 * result + (loginResult != null ? loginResult.hashCode() : 0);
        result = 31 * result + (tokenKey != null ? tokenKey.hashCode() : 0);
        result = 31 * result + (loginHost != null ? loginHost.hashCode() : 0);
        result = 31 * result + (loginAddress != null ? loginAddress.hashCode() : 0);
        result = 31 * result + (isExited != null ? isExited.hashCode() : 0);
        result = 31 * result + (exitedMethod != null ? exitedMethod.hashCode() : 0);
        result = 31 * result + (int) (exitedTime ^ (exitedTime >>> 32));
        result = 31 * result + (int) (lastInteractionTime ^ (lastInteractionTime >>> 32));
        return result;
    }
}
