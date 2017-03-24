package com.netinfo.emp.core.db.entity;

import javax.persistence.*;

/**
 * Project charley-web-09
 * Package com.netinfo.emp.core.db.entity
 * <p>
 * Created by Charley on 2017/3/22.
 */
@Entity
@Table(name = "ACCOUNT_BASIC")
public class AccountBasic {
    private long systemId;
    private short typeId;
    private long mainId;
    private String loginCode;
    private String fullName;
    private String loginPassword;
    private long belongOrg;
    private String fromSource;
    private String isLocked;
    private String lockedMethod;
    private String lockedTime;
    private String isActive;
    private String isDeleted;
    private String enabledTime;
    private String expirationTime;
    private String loginTime;
    private String loginHost;
    private String loginAddress;
    private short loginAttempt;
    private long loginCumulative;
    private long maximunLogin;
    private String isDeptManager;
    private String isNew;
    private String changePwdTime;
    private long creator;
    private long createrTime;
    private long reservedField1;
    private String reservedField2;
    private String reservedField3;
    private String reservedField4;
    private String itRemarks;

    @Id
    @Column(name = "SYSTEM_ID")
    public long getSystemId() {
        return systemId;
    }

    public void setSystemId(long systemId) {
        this.systemId = systemId;
    }

    @Basic
    @Column(name = "TYPE_ID")
    public short getTypeId() {
        return typeId;
    }

    public void setTypeId(short typeId) {
        this.typeId = typeId;
    }

    @Basic
    @Column(name = "MAIN_ID")
    public long getMainId() {
        return mainId;
    }

    public void setMainId(long mainId) {
        this.mainId = mainId;
    }

    @Basic
    @Column(name = "LOGIN_CODE")
    public String getLoginCode() {
        return loginCode;
    }

    public void setLoginCode(String loginCode) {
        this.loginCode = loginCode;
    }

    @Basic
    @Column(name = "FULL_NAME")
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Basic
    @Column(name = "LOGIN_PASSWORD")
    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    @Basic
    @Column(name = "BELONG_ORG")
    public long getBelongOrg() {
        return belongOrg;
    }

    public void setBelongOrg(long belongOrg) {
        this.belongOrg = belongOrg;
    }

    @Basic
    @Column(name = "FROM_SOURCE")
    public String getFromSource() {
        return fromSource;
    }

    public void setFromSource(String fromSource) {
        this.fromSource = fromSource;
    }

    @Basic
    @Column(name = "IS_LOCKED")
    public String getIsLocked() {
        return isLocked;
    }

    public void setIsLocked(String isLocked) {
        this.isLocked = isLocked;
    }

    @Basic
    @Column(name = "LOCKED_METHOD")
    public String getLockedMethod() {
        return lockedMethod;
    }

    public void setLockedMethod(String lockedMethod) {
        this.lockedMethod = lockedMethod;
    }

    @Basic
    @Column(name = "LOCKED_TIME")
    public String getLockedTime() {
        return lockedTime;
    }

    public void setLockedTime(String lockedTime) {
        this.lockedTime = lockedTime;
    }

    @Basic
    @Column(name = "IS_ACTIVE")
    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    @Basic
    @Column(name = "IS_DELETED")
    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Basic
    @Column(name = "ENABLED_TIME")
    public String getEnabledTime() {
        return enabledTime;
    }

    public void setEnabledTime(String enabledTime) {
        this.enabledTime = enabledTime;
    }

    @Basic
    @Column(name = "EXPIRATION_TIME")
    public String getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(String expirationTime) {
        this.expirationTime = expirationTime;
    }

    @Basic
    @Column(name = "LOGIN_TIME")
    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
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
    @Column(name = "LOGIN_ATTEMPT")
    public short getLoginAttempt() {
        return loginAttempt;
    }

    public void setLoginAttempt(short loginAttempt) {
        this.loginAttempt = loginAttempt;
    }

    @Basic
    @Column(name = "LOGIN_CUMULATIVE")
    public long getLoginCumulative() {
        return loginCumulative;
    }

    public void setLoginCumulative(long loginCumulative) {
        this.loginCumulative = loginCumulative;
    }

    @Basic
    @Column(name = "MAXIMUN_LOGIN")
    public long getMaximunLogin() {
        return maximunLogin;
    }

    public void setMaximunLogin(long maximunLogin) {
        this.maximunLogin = maximunLogin;
    }

    @Basic
    @Column(name = "IS_DEPT_MANAGER")
    public String getIsDeptManager() {
        return isDeptManager;
    }

    public void setIsDeptManager(String isDeptManager) {
        this.isDeptManager = isDeptManager;
    }

    @Basic
    @Column(name = "IS_NEW")
    public String getIsNew() {
        return isNew;
    }

    public void setIsNew(String isNew) {
        this.isNew = isNew;
    }

    @Basic
    @Column(name = "CHANGE_PWD_TIME")
    public String getChangePwdTime() {
        return changePwdTime;
    }

    public void setChangePwdTime(String changePwdTime) {
        this.changePwdTime = changePwdTime;
    }

    @Basic
    @Column(name = "CREATOR")
    public long getCreator() {
        return creator;
    }

    public void setCreator(long creator) {
        this.creator = creator;
    }

    @Basic
    @Column(name = "CREATER_TIME")
    public long getCreaterTime() {
        return createrTime;
    }

    public void setCreaterTime(long createrTime) {
        this.createrTime = createrTime;
    }

    @Basic
    @Column(name = "RESERVED_FIELD1")
    public long getReservedField1() {
        return reservedField1;
    }

    public void setReservedField1(long reservedField1) {
        this.reservedField1 = reservedField1;
    }

    @Basic
    @Column(name = "RESERVED_FIELD2")
    public String getReservedField2() {
        return reservedField2;
    }

    public void setReservedField2(String reservedField2) {
        this.reservedField2 = reservedField2;
    }

    @Basic
    @Column(name = "RESERVED_FIELD3")
    public String getReservedField3() {
        return reservedField3;
    }

    public void setReservedField3(String reservedField3) {
        this.reservedField3 = reservedField3;
    }

    @Basic
    @Column(name = "RESERVED_FIELD4")
    public String getReservedField4() {
        return reservedField4;
    }

    public void setReservedField4(String reservedField4) {
        this.reservedField4 = reservedField4;
    }

    @Basic
    @Column(name = "IT_REMARKS")
    public String getItRemarks() {
        return itRemarks;
    }

    public void setItRemarks(String itRemarks) {
        this.itRemarks = itRemarks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountBasic that = (AccountBasic) o;

        if (systemId != that.systemId) return false;
        if (typeId != that.typeId) return false;
        if (mainId != that.mainId) return false;
        if (belongOrg != that.belongOrg) return false;
        if (loginAttempt != that.loginAttempt) return false;
        if (loginCumulative != that.loginCumulative) return false;
        if (maximunLogin != that.maximunLogin) return false;
        if (creator != that.creator) return false;
        if (createrTime != that.createrTime) return false;
        if (reservedField1 != that.reservedField1) return false;
        if (loginCode != null ? !loginCode.equals(that.loginCode) : that.loginCode != null) return false;
        if (fullName != null ? !fullName.equals(that.fullName) : that.fullName != null) return false;
        if (loginPassword != null ? !loginPassword.equals(that.loginPassword) : that.loginPassword != null)
            return false;
        if (fromSource != null ? !fromSource.equals(that.fromSource) : that.fromSource != null) return false;
        if (isLocked != null ? !isLocked.equals(that.isLocked) : that.isLocked != null) return false;
        if (lockedMethod != null ? !lockedMethod.equals(that.lockedMethod) : that.lockedMethod != null) return false;
        if (lockedTime != null ? !lockedTime.equals(that.lockedTime) : that.lockedTime != null) return false;
        if (isActive != null ? !isActive.equals(that.isActive) : that.isActive != null) return false;
        if (isDeleted != null ? !isDeleted.equals(that.isDeleted) : that.isDeleted != null) return false;
        if (enabledTime != null ? !enabledTime.equals(that.enabledTime) : that.enabledTime != null) return false;
        if (expirationTime != null ? !expirationTime.equals(that.expirationTime) : that.expirationTime != null)
            return false;
        if (loginTime != null ? !loginTime.equals(that.loginTime) : that.loginTime != null) return false;
        if (loginHost != null ? !loginHost.equals(that.loginHost) : that.loginHost != null) return false;
        if (loginAddress != null ? !loginAddress.equals(that.loginAddress) : that.loginAddress != null) return false;
        if (isDeptManager != null ? !isDeptManager.equals(that.isDeptManager) : that.isDeptManager != null)
            return false;
        if (isNew != null ? !isNew.equals(that.isNew) : that.isNew != null) return false;
        if (changePwdTime != null ? !changePwdTime.equals(that.changePwdTime) : that.changePwdTime != null)
            return false;
        if (reservedField2 != null ? !reservedField2.equals(that.reservedField2) : that.reservedField2 != null)
            return false;
        if (reservedField3 != null ? !reservedField3.equals(that.reservedField3) : that.reservedField3 != null)
            return false;
        if (reservedField4 != null ? !reservedField4.equals(that.reservedField4) : that.reservedField4 != null)
            return false;
        if (itRemarks != null ? !itRemarks.equals(that.itRemarks) : that.itRemarks != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (systemId ^ (systemId >>> 32));
        result = 31 * result + (int) typeId;
        result = 31 * result + (int) (mainId ^ (mainId >>> 32));
        result = 31 * result + (loginCode != null ? loginCode.hashCode() : 0);
        result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
        result = 31 * result + (loginPassword != null ? loginPassword.hashCode() : 0);
        result = 31 * result + (int) (belongOrg ^ (belongOrg >>> 32));
        result = 31 * result + (fromSource != null ? fromSource.hashCode() : 0);
        result = 31 * result + (isLocked != null ? isLocked.hashCode() : 0);
        result = 31 * result + (lockedMethod != null ? lockedMethod.hashCode() : 0);
        result = 31 * result + (lockedTime != null ? lockedTime.hashCode() : 0);
        result = 31 * result + (isActive != null ? isActive.hashCode() : 0);
        result = 31 * result + (isDeleted != null ? isDeleted.hashCode() : 0);
        result = 31 * result + (enabledTime != null ? enabledTime.hashCode() : 0);
        result = 31 * result + (expirationTime != null ? expirationTime.hashCode() : 0);
        result = 31 * result + (loginTime != null ? loginTime.hashCode() : 0);
        result = 31 * result + (loginHost != null ? loginHost.hashCode() : 0);
        result = 31 * result + (loginAddress != null ? loginAddress.hashCode() : 0);
        result = 31 * result + (int) loginAttempt;
        result = 31 * result + (int) (loginCumulative ^ (loginCumulative >>> 32));
        result = 31 * result + (int) (maximunLogin ^ (maximunLogin >>> 32));
        result = 31 * result + (isDeptManager != null ? isDeptManager.hashCode() : 0);
        result = 31 * result + (isNew != null ? isNew.hashCode() : 0);
        result = 31 * result + (changePwdTime != null ? changePwdTime.hashCode() : 0);
        result = 31 * result + (int) (creator ^ (creator >>> 32));
        result = 31 * result + (int) (createrTime ^ (createrTime >>> 32));
        result = 31 * result + (int) (reservedField1 ^ (reservedField1 >>> 32));
        result = 31 * result + (reservedField2 != null ? reservedField2.hashCode() : 0);
        result = 31 * result + (reservedField3 != null ? reservedField3.hashCode() : 0);
        result = 31 * result + (reservedField4 != null ? reservedField4.hashCode() : 0);
        result = 31 * result + (itRemarks != null ? itRemarks.hashCode() : 0);
        return result;
    }
}
