package com.netinfo.emp.core.entity;

import java.io.Serializable;

/**
 * Project emp-core
 * Package com.netinfo.emp.core.entity
 * <p>
 * Created by Charley on 2017/3/10.
 */
public class SIDPK implements Serializable {
    private int resource;
    private int middle;

    public int getResource() {
        return resource;
    }

    public void setResource(int resource) {
        this.resource = resource;
    }

    public int getMiddle() {
        return middle;
    }

    public void setMiddle(int middle) {
        this.middle = middle;
    }
}
