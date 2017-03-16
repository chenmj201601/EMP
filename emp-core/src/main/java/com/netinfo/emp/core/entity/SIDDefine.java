package com.netinfo.emp.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Project emp-core
 * Package com.netinfo.emp.core.entity
 * <p>
 * Created by Charley on 2017/3/10.
 */
@Entity
@Table(name = "T_00_011")
public class SIDDefine {
    @Id
    @Column(name = "C001")
    private int resource;
    @Column(name = "C002")
    private int type;
    @Column(name = "C003")
    private String description;

    public int getResource() {
        return resource;
    }

    public void setResource(int resource) {
        this.resource = resource;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
