package com.netinfo.emp.core.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Project emp-core
 * Package com.netinfo.emp.core.entity
 * <p>
 * Created by Charley on 2017/3/14.
 */
public class LangInfoTablePK implements Serializable {
    private short c001;
    private String c002;

    public short getC001() {
        return c001;
    }

    public void setC001(short c001) {
        this.c001 = c001;
    }

    public String getC002() {
        return c002;
    }

    public void setC002(String c002) {
        this.c002 = c002;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LangInfoTablePK that = (LangInfoTablePK) o;

        if (c001 != that.c001) return false;
        if (c002 != null ? !c002.equals(that.c002) : that.c002 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) c001;
        result = 31 * result + (c002 != null ? c002.hashCode() : 0);
        return result;
    }
}
