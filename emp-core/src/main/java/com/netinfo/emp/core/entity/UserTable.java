package com.netinfo.emp.core.entity;

import com.netinfo.emp.common.EncryptionMode;
import com.netinfo.emp.encryptions.AESEncryption;
import com.netinfo.emp.encryptions.SHAEncryption;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

/**
 * Project emp-core
 * Package com.netinfo.emp.core.entity
 * <p>
 * Created by Charley on 2017/3/11.
 */
@Entity
@Table(name = "t_00_105")
public class UserTable {
    private long c001;
    private short c002;
    private long c003;
    private String c004;
    private String c005;
    private String c006;
    private long c007;
    private String c008;
    private String c009;
    private String c010;
    private String c011;
    private String c012;
    private String c013;
    private String c014;
    private String c015;
    private String c016;
    private String c017;
    private String c018;
    private short c019;
    private long c020;
    private long c021;
    private String c022;
    private String c023;
    private String c024;
    private long c025;
    private long c026;
    private long c027;
    private String c028;
    private String c029;
    private String c030;
    private String c999;

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
    public short getC002() {
        return c002;
    }

    public void setC002(short c002) {
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
    public long getC007() {
        return c007;
    }

    public void setC007(long c007) {
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
    public String getC011() {
        return c011;
    }

    public void setC011(String c011) {
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

    @Basic
    @Column(name = "C015")
    public String getC015() {
        return c015;
    }

    public void setC015(String c015) {
        this.c015 = c015;
    }

    @Basic
    @Column(name = "C016")
    public String getC016() {
        return c016;
    }

    public void setC016(String c016) {
        this.c016 = c016;
    }

    @Basic
    @Column(name = "C017")
    public String getC017() {
        return c017;
    }

    public void setC017(String c017) {
        this.c017 = c017;
    }

    @Basic
    @Column(name = "C018")
    public String getC018() {
        return c018;
    }

    public void setC018(String c018) {
        this.c018 = c018;
    }

    @Basic
    @Column(name = "C019")
    public short getC019() {
        return c019;
    }

    public void setC019(short c019) {
        this.c019 = c019;
    }

    @Basic
    @Column(name = "C020")
    public long getC020() {
        return c020;
    }

    public void setC020(long c020) {
        this.c020 = c020;
    }

    @Basic
    @Column(name = "C021")
    public long getC021() {
        return c021;
    }

    public void setC021(long c021) {
        this.c021 = c021;
    }

    @Basic
    @Column(name = "C022")
    public String getC022() {
        return c022;
    }

    public void setC022(String c022) {
        this.c022 = c022;
    }

    @Basic
    @Column(name = "C023")
    public String getC023() {
        return c023;
    }

    public void setC023(String c023) {
        this.c023 = c023;
    }

    @Basic
    @Column(name = "C024")
    public String getC024() {
        return c024;
    }

    public void setC024(String c024) {
        this.c024 = c024;
    }

    @Basic
    @Column(name = "C025")
    public long getC025() {
        return c025;
    }

    public void setC025(long c025) {
        this.c025 = c025;
    }

    @Basic
    @Column(name = "C026")
    public long getC026() {
        return c026;
    }

    public void setC026(long c026) {
        this.c026 = c026;
    }

    @Basic
    @Column(name = "C027")
    public long getC027() {
        return c027;
    }

    public void setC027(long c027) {
        this.c027 = c027;
    }

    @Basic
    @Column(name = "C028")
    public String getC028() {
        return c028;
    }

    public void setC028(String c028) {
        this.c028 = c028;
    }

    @Basic
    @Column(name = "C029")
    public String getC029() {
        return c029;
    }

    public void setC029(String c029) {
        this.c029 = c029;
    }

    @Basic
    @Column(name = "C030")
    public String getC030() {
        return c030;
    }

    public void setC030(String c030) {
        this.c030 = c030;
    }

    @Basic
    @Column(name = "C999")
    public String getC999() {
        return c999;
    }

    public void setC999(String c999) {
        this.c999 = c999;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserTable that = (UserTable) o;

        if (c001 != that.c001) return false;
        if (c002 != that.c002) return false;
        if (c003 != that.c003) return false;
        if (c007 != that.c007) return false;
        if (c019 != that.c019) return false;
        if (c020 != that.c020) return false;
        if (c021 != that.c021) return false;
        if (c025 != that.c025) return false;
        if (c026 != that.c026) return false;
        if (c027 != that.c027) return false;
        if (c004 != null ? !c004.equals(that.c004) : that.c004 != null) return false;
        if (c005 != null ? !c005.equals(that.c005) : that.c005 != null) return false;
        if (c006 != null ? !c006.equals(that.c006) : that.c006 != null) return false;
        if (c008 != null ? !c008.equals(that.c008) : that.c008 != null) return false;
        if (c009 != null ? !c009.equals(that.c009) : that.c009 != null) return false;
        if (c010 != null ? !c010.equals(that.c010) : that.c010 != null) return false;
        if (c011 != null ? !c011.equals(that.c011) : that.c011 != null) return false;
        if (c012 != null ? !c012.equals(that.c012) : that.c012 != null) return false;
        if (c013 != null ? !c013.equals(that.c013) : that.c013 != null) return false;
        if (c014 != null ? !c014.equals(that.c014) : that.c014 != null) return false;
        if (c015 != null ? !c015.equals(that.c015) : that.c015 != null) return false;
        if (c016 != null ? !c016.equals(that.c016) : that.c016 != null) return false;
        if (c017 != null ? !c017.equals(that.c017) : that.c017 != null) return false;
        if (c018 != null ? !c018.equals(that.c018) : that.c018 != null) return false;
        if (c022 != null ? !c022.equals(that.c022) : that.c022 != null) return false;
        if (c023 != null ? !c023.equals(that.c023) : that.c023 != null) return false;
        if (c024 != null ? !c024.equals(that.c024) : that.c024 != null) return false;
        if (c028 != null ? !c028.equals(that.c028) : that.c028 != null) return false;
        if (c029 != null ? !c029.equals(that.c029) : that.c029 != null) return false;
        if (c030 != null ? !c030.equals(that.c030) : that.c030 != null) return false;
        if (c999 != null ? !c999.equals(that.c999) : that.c999 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (c001 ^ (c001 >>> 32));
        result = 31 * result + (int) c002;
        result = 31 * result + (int) (c003 ^ (c003 >>> 32));
        result = 31 * result + (c004 != null ? c004.hashCode() : 0);
        result = 31 * result + (c005 != null ? c005.hashCode() : 0);
        result = 31 * result + (c006 != null ? c006.hashCode() : 0);
        result = 31 * result + (int) (c007 ^ (c007 >>> 32));
        result = 31 * result + (c008 != null ? c008.hashCode() : 0);
        result = 31 * result + (c009 != null ? c009.hashCode() : 0);
        result = 31 * result + (c010 != null ? c010.hashCode() : 0);
        result = 31 * result + (c011 != null ? c011.hashCode() : 0);
        result = 31 * result + (c012 != null ? c012.hashCode() : 0);
        result = 31 * result + (c013 != null ? c013.hashCode() : 0);
        result = 31 * result + (c014 != null ? c014.hashCode() : 0);
        result = 31 * result + (c015 != null ? c015.hashCode() : 0);
        result = 31 * result + (c016 != null ? c016.hashCode() : 0);
        result = 31 * result + (c017 != null ? c017.hashCode() : 0);
        result = 31 * result + (c018 != null ? c018.hashCode() : 0);
        result = 31 * result + (int) c019;
        result = 31 * result + (int) (c020 ^ (c020 >>> 32));
        result = 31 * result + (int) (c021 ^ (c021 >>> 32));
        result = 31 * result + (c022 != null ? c022.hashCode() : 0);
        result = 31 * result + (c023 != null ? c023.hashCode() : 0);
        result = 31 * result + (c024 != null ? c024.hashCode() : 0);
        result = 31 * result + (int) (c025 ^ (c025 >>> 32));
        result = 31 * result + (int) (c026 ^ (c026 >>> 32));
        result = 31 * result + (int) (c027 ^ (c027 >>> 32));
        result = 31 * result + (c028 != null ? c028.hashCode() : 0);
        result = 31 * result + (c029 != null ? c029.hashCode() : 0);
        result = 31 * result + (c030 != null ? c030.hashCode() : 0);
        result = 31 * result + (c999 != null ? c999.hashCode() : 0);
        return result;
    }

    public User ofUser() throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        format.setTimeZone(TimeZone.getTimeZone("GMT"));
        User user = new User();
        user.setId(c001);
        user.setType(c002);
        user.setMaster(c003);
        user.setAccount(AESEncryption.decryptString(c004, EncryptionMode.AES256_02_HEX_UNICODE).substring(19));
        user.setFullname(AESEncryption.decryptString(c005, EncryptionMode.AES256_02_HEX_UNICODE).substring(19));
        user.setPassword(c006);
        user.setOrgId(c007);
        user.setSourceType(c008);
        String isLocked = c009;
        String lockMethod = c010;
        if (isLocked.equals("0")) {
            user.setLock("N");
        } else {
            user.setLock(lockMethod);
        }
        if (c011 == null) {
            user.setLockTime(format.parse("19000101000000"));
        } else {
            String strTime = AESEncryption.decryptString(c011, EncryptionMode.AES256_02_HEX_UNICODE).substring(19);
            user.setLockTime(format.parse(strTime));
        }
        user.setActive(c012);
        user.setDelete(c013);
        if (c014 == null) {
            user.setLockTime(format.parse("19000101000000"));
        } else {
            String strTime = AESEncryption.decryptString(c014, EncryptionMode.AES256_02_HEX_UNICODE).substring(19);
            user.setLockTime(format.parse(strTime));
        }
        if (c015 == null) {
            user.setLockTime(format.parse("19000101000000"));
        } else {
            String strTime = AESEncryption.decryptString(c015, EncryptionMode.AES256_02_HEX_UNICODE).substring(19);
            user.setLockTime(format.parse(strTime));
        }
        user.setCreator(c025);
        String strTime = ((Long) c026).toString();
        user.setCreateTime(format.parse(strTime));
        return user;
    }

    public static UserTable fromUser(User user) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        format.setTimeZone(TimeZone.getTimeZone("GMT"));
        UserTable userTable = new UserTable();
        userTable.setC001(user.getId());
        userTable.setC002(user.getType());
        userTable.setC003(user.getMaster());
        userTable.setC004(AESEncryption.encryptString(String.format("%s%s", user.getId(), user.getAccount()), EncryptionMode.AES256_02_HEX_UNICODE));
        userTable.setC005(AESEncryption.encryptString(String.format("%s%s", user.getId(), user.getFullname()), EncryptionMode.AES256_02_HEX_UNICODE));
        if (!"".equals(user.getOriginalPassword())) {
            userTable.setC006(SHAEncryption.encryptString(AESEncryption.encryptString(String.format("%s%s", user.getId(), user.getOriginalPassword()), EncryptionMode.AES256_01_HEX_UNICODE), EncryptionMode.SHA512_00_HEX_UNICODE));
        }
        userTable.setC007(user.getOrgId());
        userTable.setC008(user.getSourceType());
        userTable.setC009(user.getLock().equals("N") ? "0" : "1");
        userTable.setC010(user.getLock());
        userTable.setC011(AESEncryption.encryptString(String.format("%s%s", user.getId(), format.format(user.getLockTime())), EncryptionMode.AES256_02_HEX_UNICODE));
        userTable.setC012(user.getActive());
        userTable.setC013(user.getDelete());
        userTable.setC014(AESEncryption.encryptString(String.format("%s%s", user.getId(), format.format(user.getEnableFrom())), EncryptionMode.AES256_02_HEX_UNICODE));
        userTable.setC015(AESEncryption.encryptString(String.format("%s%s", user.getId(), format.format(user.getEnableTo())), EncryptionMode.AES256_02_HEX_UNICODE));
        userTable.setC016(AESEncryption.encryptString("19000101000000", EncryptionMode.AES256_01_HEX_UNICODE));
        userTable.setC017(AESEncryption.encryptString("", EncryptionMode.AES256_01_HEX_UNICODE));
        userTable.setC018(AESEncryption.encryptString("", EncryptionMode.AES256_01_HEX_UNICODE));
        userTable.setC019((short) 0);
        userTable.setC020(0L);
        userTable.setC021(0L);
        userTable.setC022("0");
        userTable.setC023("1");
        userTable.setC024(AESEncryption.encryptString("", EncryptionMode.AES256_01_HEX_UNICODE));
        userTable.setC025(user.getCreator());
        userTable.setC026(Long.parseLong(format.format(user.getCreateTime())));
        userTable.setC027(0L);
        userTable.setC028("");
        userTable.setC029("");
        userTable.setC030("");
        userTable.setC999("");
        return userTable;
    }
}
