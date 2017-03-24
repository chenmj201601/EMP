package com.netinfo.emp.core.db.entity;

import javax.persistence.*;

/**
 * Project charley-web-09
 * Package com.netinfo.emp.core.db.entity
 * <p>
 * Created by Charley on 2017/3/22.
 */
@Entity
@Table(name = "ROLES_LIST")
public class RolesList {
    private long systemId;
    private long parentId;
    private String fullName;
    private String isActive;
    private String isDeleted;
    private String enableTime;
    private String expirationTime;
    private String allocationToUser;
    private long creator;
    private long createTime;
    private String roleRemarks;

    @Id
    @Column(name = "SYSTEM_ID")
    public long getSystemId() {
        return systemId;
    }

    public void setSystemId(long systemId) {
        this.systemId = systemId;
    }

    @Basic
    @Column(name = "PARENT_ID")
    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
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
    @Column(name = "ENABLE_TIME")
    public String getEnableTime() {
        return enableTime;
    }

    public void setEnableTime(String enableTime) {
        this.enableTime = enableTime;
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
    @Column(name = "ALLOCATION_TO_USER")
    public String getAllocationToUser() {
        return allocationToUser;
    }

    public void setAllocationToUser(String allocationToUser) {
        this.allocationToUser = allocationToUser;
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
    @Column(name = "CREATE_TIME")
    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "ROLE_REMARKS")
    public String getRoleRemarks() {
        return roleRemarks;
    }

    public void setRoleRemarks(String roleRemarks) {
        this.roleRemarks = roleRemarks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RolesList rolesList = (RolesList) o;

        if (systemId != rolesList.systemId) return false;
        if (parentId != rolesList.parentId) return false;
        if (creator != rolesList.creator) return false;
        if (createTime != rolesList.createTime) return false;
        if (fullName != null ? !fullName.equals(rolesList.fullName) : rolesList.fullName != null) return false;
        if (isActive != null ? !isActive.equals(rolesList.isActive) : rolesList.isActive != null) return false;
        if (isDeleted != null ? !isDeleted.equals(rolesList.isDeleted) : rolesList.isDeleted != null) return false;
        if (enableTime != null ? !enableTime.equals(rolesList.enableTime) : rolesList.enableTime != null) return false;
        if (expirationTime != null ? !expirationTime.equals(rolesList.expirationTime) : rolesList.expirationTime != null)
            return false;
        if (allocationToUser != null ? !allocationToUser.equals(rolesList.allocationToUser) : rolesList.allocationToUser != null)
            return false;
        if (roleRemarks != null ? !roleRemarks.equals(rolesList.roleRemarks) : rolesList.roleRemarks != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (systemId ^ (systemId >>> 32));
        result = 31 * result + (int) (parentId ^ (parentId >>> 32));
        result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
        result = 31 * result + (isActive != null ? isActive.hashCode() : 0);
        result = 31 * result + (isDeleted != null ? isDeleted.hashCode() : 0);
        result = 31 * result + (enableTime != null ? enableTime.hashCode() : 0);
        result = 31 * result + (expirationTime != null ? expirationTime.hashCode() : 0);
        result = 31 * result + (allocationToUser != null ? allocationToUser.hashCode() : 0);
        result = 31 * result + (int) (creator ^ (creator >>> 32));
        result = 31 * result + (int) (createTime ^ (createTime >>> 32));
        result = 31 * result + (roleRemarks != null ? roleRemarks.hashCode() : 0);
        return result;
    }
}
