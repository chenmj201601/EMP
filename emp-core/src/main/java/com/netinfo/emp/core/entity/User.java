package com.netinfo.emp.core.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.netinfo.emp.common.EncryptionMode;
import com.netinfo.emp.encryptions.AESEncryption;
import com.netinfo.emp.encryptions.SHAEncryption;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Project emp-core
 * Package com.netinfo.emp.core.entity
 * <p>
 * Created by Charley on 2017/3/11.
 */
public class User {
    private Long id;
    private short type;
    private Long master;
    private String account;
    private String fullname;
    private String password;
    @JsonIgnore
    private String originalPassword;
    private Long orgId;

    private String sourceType;
    private String lock;
    private Date lockTime;
    private String active;
    private String delete;
    private Date enableFrom;
    private Date enableTo;
    private Long creator;
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public short getType() {
        return type;
    }

    public void setType(short type) {
        this.type = type;
    }

    public Long getMaster() {
        return master;
    }

    public void setMaster(Long master) {
        this.master = master;
    }

    public String getAccount() throws Exception {
        return account;
    }

    public void setAccount(String account) throws Exception {
        this.account = account;
    }

    public String getFullname() throws Exception {
        return fullname;
    }

    public void setFullname(String fullname) throws Exception {
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

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getLock() {
        return lock;
    }

    public void setLock(String lock) {
        this.lock = lock;
    }

    public Date getLockTime() {
        return lockTime;
    }

    public void setLockTime(Date lockTime) {
        this.lockTime = lockTime;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getDelete() {
        return delete;
    }

    public void setDelete(String delete) {
        this.delete = delete;
    }

    public Date getEnableFrom() {
        return enableFrom;
    }

    public void setEnableFrom(Date enableFrom) {
        this.enableFrom = enableFrom;
    }

    public Date getEnableTo() {
        return enableTo;
    }

    public void setEnableTo(Date enableTo) {
        this.enableTo = enableTo;
    }

    public Long getCreator() {
        return creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
