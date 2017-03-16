package com.netinfo.emp.core.entity;

import javax.persistence.*;

/**
 * Project emp-core
 * Package com.netinfo.emp.core.entity
 * <p>
 * Created by Charley on 2017/3/14.
 */
@Entity
@Table(name = "T_00_024")
public class LangTypeTable {
    private short c001;
    private String c002;
    private String c003;
    private String c004;
    private short c005;
    private String c006;
    private short c007;
    private String c008;
    private String c009;
    private String c010;
    private long c011;
    private String c012;
    private String c013;
    private String c014;

    @Id
    @Column(name = "C001")
    public short getC001() {
        return c001;
    }

    public void setC001(short c001) {
        this.c001 = c001;
    }

    @Basic
    @Column(name = "C002")
    public String getC002() {
        return c002;
    }

    public void setC002(String c002) {
        this.c002 = c002;
    }

    @Basic
    @Column(name = "C003")
    public String getC003() {
        return c003;
    }

    public void setC003(String c003) {
        this.c003 = c003;
    }

    @Basic
    @Column(name = "C004")
    public String getC004() {
        return c004;
    }

    public void setC004(String c004) {
        this.c004 = c004;
    }

    @Basic
    @Column(name = "C005")
    public short getC005() {
        return c005;
    }

    public void setC005(short c005) {
        this.c005 = c005;
    }

    @Basic
    @Column(name = "C006")
    public String getC006() {
        return c006;
    }

    public void setC006(String c006) {
        this.c006 = c006;
    }

    @Basic
    @Column(name = "C007")
    public short getC007() {
        return c007;
    }

    public void setC007(short c007) {
        this.c007 = c007;
    }

    @Basic
    @Column(name = "C008")
    public String getC008() {
        return c008;
    }

    public void setC008(String c008) {
        this.c008 = c008;
    }

    @Basic
    @Column(name = "C009")
    public String getC009() {
        return c009;
    }

    public void setC009(String c009) {
        this.c009 = c009;
    }

    @Basic
    @Column(name = "C010")
    public String getC010() {
        return c010;
    }

    public void setC010(String c010) {
        this.c010 = c010;
    }

    @Basic
    @Column(name = "C011")
    public long getC011() {
        return c011;
    }

    public void setC011(long c011) {
        this.c011 = c011;
    }

    @Basic
    @Column(name = "C012")
    public String getC012() {
        return c012;
    }

    public void setC012(String c012) {
        this.c012 = c012;
    }

    @Basic
    @Column(name = "C013")
    public String getC013() {
        return c013;
    }

    public void setC013(String c013) {
        this.c013 = c013;
    }

    @Basic
    @Column(name = "C014")
    public String getC014() {
        return c014;
    }

    public void setC014(String c014) {
        this.c014 = c014;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LangTypeTable that = (LangTypeTable) o;

        if (c001 != that.c001) return false;
        if (c005 != that.c005) return false;
        if (c007 != that.c007) return false;
        if (c011 != that.c011) return false;
        if (c002 != null ? !c002.equals(that.c002) : that.c002 != null) return false;
        if (c003 != null ? !c003.equals(that.c003) : that.c003 != null) return false;
        if (c004 != null ? !c004.equals(that.c004) : that.c004 != null) return false;
        if (c006 != null ? !c006.equals(that.c006) : that.c006 != null) return false;
        if (c008 != null ? !c008.equals(that.c008) : that.c008 != null) return false;
        if (c009 != null ? !c009.equals(that.c009) : that.c009 != null) return false;
        if (c010 != null ? !c010.equals(that.c010) : that.c010 != null) return false;
        if (c012 != null ? !c012.equals(that.c012) : that.c012 != null) return false;
        if (c013 != null ? !c013.equals(that.c013) : that.c013 != null) return false;
        if (c014 != null ? !c014.equals(that.c014) : that.c014 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) c001;
        result = 31 * result + (c002 != null ? c002.hashCode() : 0);
        result = 31 * result + (c003 != null ? c003.hashCode() : 0);
        result = 31 * result + (c004 != null ? c004.hashCode() : 0);
        result = 31 * result + (int) c005;
        result = 31 * result + (c006 != null ? c006.hashCode() : 0);
        result = 31 * result + (int) c007;
        result = 31 * result + (c008 != null ? c008.hashCode() : 0);
        result = 31 * result + (c009 != null ? c009.hashCode() : 0);
        result = 31 * result + (c010 != null ? c010.hashCode() : 0);
        result = 31 * result + (int) (c011 ^ (c011 >>> 32));
        result = 31 * result + (c012 != null ? c012.hashCode() : 0);
        result = 31 * result + (c013 != null ? c013.hashCode() : 0);
        result = 31 * result + (c014 != null ? c014.hashCode() : 0);
        return result;
    }

    public static LangTypeTable fromLangType(LangType langType) {
        LangTypeTable langTypeTable = new LangTypeTable();
        langTypeTable.setC001(langType.getId());
        langTypeTable.setC002(langType.getName());
        langTypeTable.setC003(langType.getIdentity());
        langTypeTable.setC004(langType.getShortName());
        langTypeTable.setC005(langType.getCode());
        langTypeTable.setC006("");
        langTypeTable.setC007((short) 0);
        langTypeTable.setC008("");
        langTypeTable.setC009("2.01.001");
        langTypeTable.setC010("0");
        langTypeTable.setC011(0L);
        langTypeTable.setC012("1");
        langTypeTable.setC013("0");
        langTypeTable.setC014("1");
        return langTypeTable;
    }

    public LangType ofLangType() {
        LangType langType = new LangType();
        langType.setId(c001);
        langType.setName(c002);
        langType.setIdentity(c003);
        langType.setShortName(c004);
        langType.setCode(c005);
        return langType;
    }
}
