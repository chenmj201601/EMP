package com.netinfo.emp.core.entity;

import javax.persistence.*;

/**
 * Project emp-core
 * Package com.netinfo.emp.core.entity
 * <p>
 * Created by Charley on 2017/3/14.
 */
@Entity
@Table(name = "T_00_025")
@IdClass(LangInfoTablePK.class)
public class LangInfoTable {
    private short c001;
    private String c002;
    private String c003;
    private String c004;
    private String c005;
    private String c006;
    private String c007;
    private String c008;
    private short c009;
    private short c010;
    private short c011;
    private short c012;
    private short c013;
    private long c014;
    private String c015;

    @Id
    @Column(name = "C001")
    public short getC001() {
        return c001;
    }

    public void setC001(short c001) {
        this.c001 = c001;
    }

    @Id
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
    public String getC005() {
        return c005;
    }

    public void setC005(String c005) {
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
    public String getC007() {
        return c007;
    }

    public void setC007(String c007) {
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
    public short getC009() {
        return c009;
    }

    public void setC009(short c009) {
        this.c009 = c009;
    }

    @Basic
    @Column(name = "C010")
    public short getC010() {
        return c010;
    }

    public void setC010(short c010) {
        this.c010 = c010;
    }

    @Basic
    @Column(name = "C011")
    public short getC011() {
        return c011;
    }

    public void setC011(short c011) {
        this.c011 = c011;
    }

    @Basic
    @Column(name = "C012")
    public short getC012() {
        return c012;
    }

    public void setC012(short c012) {
        this.c012 = c012;
    }

    @Basic
    @Column(name = "C013")
    public short getC013() {
        return c013;
    }

    public void setC013(short c013) {
        this.c013 = c013;
    }

    @Basic
    @Column(name = "C014")
    public long getC014() {
        return c014;
    }

    public void setC014(long c014) {
        this.c014 = c014;
    }

    @Basic
    @Column(name = "C015")
    public String getC015() {
        return c015;
    }

    public void setC015(String c015) {
        this.c015 = c015;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LangInfoTable that = (LangInfoTable) o;

        if (c001 != that.c001) return false;
        if (c009 != that.c009) return false;
        if (c010 != that.c010) return false;
        if (c011 != that.c011) return false;
        if (c012 != that.c012) return false;
        if (c013 != that.c013) return false;
        if (c014 != that.c014) return false;
        if (c002 != null ? !c002.equals(that.c002) : that.c002 != null) return false;
        if (c003 != null ? !c003.equals(that.c003) : that.c003 != null) return false;
        if (c004 != null ? !c004.equals(that.c004) : that.c004 != null) return false;
        if (c005 != null ? !c005.equals(that.c005) : that.c005 != null) return false;
        if (c006 != null ? !c006.equals(that.c006) : that.c006 != null) return false;
        if (c007 != null ? !c007.equals(that.c007) : that.c007 != null) return false;
        if (c008 != null ? !c008.equals(that.c008) : that.c008 != null) return false;
        if (c015 != null ? !c015.equals(that.c015) : that.c015 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) c001;
        result = 31 * result + (c002 != null ? c002.hashCode() : 0);
        result = 31 * result + (c003 != null ? c003.hashCode() : 0);
        result = 31 * result + (c004 != null ? c004.hashCode() : 0);
        result = 31 * result + (c005 != null ? c005.hashCode() : 0);
        result = 31 * result + (c006 != null ? c006.hashCode() : 0);
        result = 31 * result + (c007 != null ? c007.hashCode() : 0);
        result = 31 * result + (c008 != null ? c008.hashCode() : 0);
        result = 31 * result + (int) c009;
        result = 31 * result + (int) c010;
        result = 31 * result + (int) c011;
        result = 31 * result + (int) c012;
        result = 31 * result + (int) c013;
        result = 31 * result + (int) (c014 ^ (c014 >>> 32));
        result = 31 * result + (c015 != null ? c015.hashCode() : 0);
        return result;
    }

    public static LangInfoTable fromLangInfo(LangInfo langInfo) {
        LangInfoTable langInfoTable = new LangInfoTable();
        langInfoTable.setC001(langInfo.getLangId());
        langInfoTable.setC002(langInfo.getName());
        langInfoTable.setC003(langInfo.getDisplay());
        langInfoTable.setC004("");
        langInfoTable.setC005(langInfo.getTip());
        langInfoTable.setC006("");
        langInfoTable.setC007(langInfo.getPage());
        langInfoTable.setC008(langInfo.getObject());
        langInfoTable.setC009((short) 0);
        langInfoTable.setC010((short) 0);
        langInfoTable.setC011((short) 0);
        langInfoTable.setC012((short) 0);
        langInfoTable.setC013((short) 0);
        langInfoTable.setC014(0L);
        langInfoTable.setC015("");
        return langInfoTable;
    }

    public LangInfo ofLangInfo(){
        LangInfo langInfo=new LangInfo();
        langInfo.setLangId(c001);
        langInfo.setName(c002);
        langInfo.setDisplay(c003);
        langInfo.setTip(c005);
        langInfo.setPage(c007);
        langInfo.setObject(c008);
        return langInfo;
    }
}
