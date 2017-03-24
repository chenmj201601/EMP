package com.netinfo.emp.core.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Map;

/**
 * Project emp-core
 * Package com.netinfo.emp.core.entity
 * <p>
 * Created by Charley on 2017/3/23.
 */
public class Account {
    private long id;
    private String name;
    private String fullname;
    private String password;
    @JsonIgnore
    private String originalPassword;
    private long orgId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOriginalPassword() {
        return originalPassword;
    }

    public void setOriginalPassword(String originalPassword) {
        this.originalPassword = originalPassword;
    }

    public long getOrgId() {
        return orgId;
    }

    public void setOrgId(long orgId) {
        this.orgId = orgId;
    }

    public static Account fromT(Map<String, Object> map) {
        Account account = new Account();
        account.setId((long) map.get("system_id"));
        account.setName(map.get("login_code").toString());
        account.setFullname(map.get("full_name").toString());
        account.setPassword(map.get("login_password").toString());
        account.setOrgId((long) map.get("belong_org"));
        return account;
    }
}
