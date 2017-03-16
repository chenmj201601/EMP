package com.netinfo.emp.core.entity;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

/**
 * Project emp-core
 * Package com.netinfo.emp.core.entity
 * <p>
 * Created by Charley on 2017/3/11.
 */
@Entity
@Table(name = "t_00_801")
public class LoginTable {
    private long c001;
    private Long c002;
    private long c003;
    private String c004;
    private String c005;
    private String c006;
    private String c007;
    private String c008;
    private String c009;
    private Long c010;
    private Long c011;

    @Id
    @Column(name = "C001")
    public long getC001() {
        return c001;
    }

    public void setC001(long c001) {
        this.c001 = c001;
    }

    @Basic
    @Column(name = "C002")
    public Long getC002() {
        return c002;
    }

    public void setC002(Long c002) {
        this.c002 = c002;
    }

    @Basic
    @Column(name = "C003")
    public long getC003() {
        return c003;
    }

    public void setC003(long c003) {
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
    public String getC009() {
        return c009;
    }

    public void setC009(String c009) {
        this.c009 = c009;
    }

    @Basic
    @Column(name = "C010")
    public Long getC010() {
        return c010;
    }

    public void setC010(Long c010) {
        this.c010 = c010;
    }

    @Basic
    @Column(name = "C011")
    public Long getC011() {
        return c011;
    }

    public void setC011(Long c011) {
        this.c011 = c011;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LoginTable that = (LoginTable) o;
        if (c001 != that.c001) return false;
        if (c002 != that.c002) return false;
        if (c003 != that.c003) return false;
        if (c010 != that.c010) return false;
        if (c011 != that.c011) return false;
        if (c004 != null ? !c004.equals(that.c004) : that.c004 != null) return false;
        if (c005 != null ? !c005.equals(that.c005) : that.c005 != null) return false;
        if (c006 != null ? !c006.equals(that.c006) : that.c006 != null) return false;
        if (c007 != null ? !c007.equals(that.c007) : that.c007 != null) return false;
        if (c008 != null ? !c008.equals(that.c008) : that.c008 != null) return false;
        if (c009 != null ? !c009.equals(that.c009) : that.c009 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (c001 ^ (c001 >>> 32));
        result = 31 * result + (int) (c002 ^ (c002 >>> 32));
        result = 31 * result + (int) (c003 ^ (c003 >>> 32));
        result = 31 * result + (c004 != null ? c004.hashCode() : 0);
        result = 31 * result + (c005 != null ? c005.hashCode() : 0);
        result = 31 * result + (c006 != null ? c006.hashCode() : 0);
        result = 31 * result + (c007 != null ? c007.hashCode() : 0);
        result = 31 * result + (c008 != null ? c008.hashCode() : 0);
        result = 31 * result + (c009 != null ? c009.hashCode() : 0);
        result = 31 * result + (int) (c010 ^ (c010 >>> 32));
        result = 31 * result + (int) (c011 ^ (c011 >>> 32));
        return result;
    }

    public Login ofLogin() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        format.setTimeZone(TimeZone.getTimeZone("GMT"));
        Login login = new Login();
        login.setId(c001);
        login.setUserId(c002);
        login.setLoginTime(format.parse(((Long) c003).toString()));
        login.setLoginResult(c004);
        login.setLoginToken(c005);
        login.setLoginHost(c006);
        login.setLoginIP(c007);
        login.setExited(c008.equals("1"));
        login.setExitedMethod(c009);
        login.setExitTime(format.parse(((Long) c010).toString()));
        login.setLastActiveTime(format.parse(((Long) c011).toString()));
        return login;
    }

    public static LoginTable fromLogin(Login login) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        format.setTimeZone(TimeZone.getTimeZone("GMT"));
        LoginTable loginTable = new LoginTable();
        loginTable.setC001(login.getId());
        loginTable.setC002(login.getUserId());
        loginTable.setC003(Long.parseLong(format.format(login.getLoginTime())));
        loginTable.setC004(login.getLoginResult());
        loginTable.setC005(login.getLoginToken());
        loginTable.setC006(login.getLoginHost());
        loginTable.setC007(login.getLoginIP());
        loginTable.setC008(login.isExited() ? "1" : "0");
        loginTable.setC009(login.getExitedMethod());
        loginTable.setC010(Long.parseLong(format.format(login.getExitTime())));
        loginTable.setC011(Long.parseLong(format.format(login.getLastActiveTime())));
        return loginTable;
    }
}
