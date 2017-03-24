package com.netinfo.emp.core.db.entity;

import javax.persistence.*;

/**
 * Project charley-web-09
 * Package com.netinfo.emp.core.db.entity
 * <p>
 * Created by Charley on 2017/3/24.
 */
@Entity
@Table(name = "LANGUAGE_BODY")
@IdClass(LanguageBodyPK.class)
public class LanguageBody {
    private short languageId;
    private String messageCode;
    private String displayContent1;
    private String displayContent2;
    private String tipsContent1;
    private String tipsContent2;
    private String inPage;
    private String usedControl;
    private short messageDegree;
    private short messageLevel;
    private short alarmAppend1;
    private short alarmAppend2;
    private short alarmAppend3;
    private long alarmAppend4;
    private String alarmAppend5;
    private short moduleNumber;

    @Id
    @Column(name = "LANGUAGE_ID")
    public short getLanguageId() {
        return languageId;
    }

    public void setLanguageId(short languageId) {
        this.languageId = languageId;
    }

    @Id
    @Column(name = "MESSAGE_CODE")
    public String getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(String messageCode) {
        this.messageCode = messageCode;
    }

    @Basic
    @Column(name = "DISPLAY_CONTENT1")
    public String getDisplayContent1() {
        return displayContent1;
    }

    public void setDisplayContent1(String displayContent1) {
        this.displayContent1 = displayContent1;
    }

    @Basic
    @Column(name = "DISPLAY_CONTENT2")
    public String getDisplayContent2() {
        return displayContent2;
    }

    public void setDisplayContent2(String displayContent2) {
        this.displayContent2 = displayContent2;
    }

    @Basic
    @Column(name = "TIPS_CONTENT1")
    public String getTipsContent1() {
        return tipsContent1;
    }

    public void setTipsContent1(String tipsContent1) {
        this.tipsContent1 = tipsContent1;
    }

    @Basic
    @Column(name = "TIPS_CONTENT2")
    public String getTipsContent2() {
        return tipsContent2;
    }

    public void setTipsContent2(String tipsContent2) {
        this.tipsContent2 = tipsContent2;
    }

    @Basic
    @Column(name = "IN_PAGE")
    public String getInPage() {
        return inPage;
    }

    public void setInPage(String inPage) {
        this.inPage = inPage;
    }

    @Basic
    @Column(name = "USED_CONTROL")
    public String getUsedControl() {
        return usedControl;
    }

    public void setUsedControl(String usedControl) {
        this.usedControl = usedControl;
    }

    @Basic
    @Column(name = "MESSAGE_DEGREE")
    public short getMessageDegree() {
        return messageDegree;
    }

    public void setMessageDegree(short messageDegree) {
        this.messageDegree = messageDegree;
    }

    @Basic
    @Column(name = "MESSAGE_LEVEL")
    public short getMessageLevel() {
        return messageLevel;
    }

    public void setMessageLevel(short messageLevel) {
        this.messageLevel = messageLevel;
    }

    @Basic
    @Column(name = "ALARM_APPEND1")
    public short getAlarmAppend1() {
        return alarmAppend1;
    }

    public void setAlarmAppend1(short alarmAppend1) {
        this.alarmAppend1 = alarmAppend1;
    }

    @Basic
    @Column(name = "ALARM_APPEND2")
    public short getAlarmAppend2() {
        return alarmAppend2;
    }

    public void setAlarmAppend2(short alarmAppend2) {
        this.alarmAppend2 = alarmAppend2;
    }

    @Basic
    @Column(name = "ALARM_APPEND3")
    public short getAlarmAppend3() {
        return alarmAppend3;
    }

    public void setAlarmAppend3(short alarmAppend3) {
        this.alarmAppend3 = alarmAppend3;
    }

    @Basic
    @Column(name = "ALARM_APPEND4")
    public long getAlarmAppend4() {
        return alarmAppend4;
    }

    public void setAlarmAppend4(long alarmAppend4) {
        this.alarmAppend4 = alarmAppend4;
    }

    @Basic
    @Column(name = "ALARM_APPEND5")
    public String getAlarmAppend5() {
        return alarmAppend5;
    }

    public void setAlarmAppend5(String alarmAppend5) {
        this.alarmAppend5 = alarmAppend5;
    }

    @Basic
    @Column(name = "MODULE_NUMBER")
    public short getModuleNumber() {
        return moduleNumber;
    }

    public void setModuleNumber(short moduleNumber) {
        this.moduleNumber = moduleNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LanguageBody that = (LanguageBody) o;

        if (languageId != that.languageId) return false;
        if (messageDegree != that.messageDegree) return false;
        if (messageLevel != that.messageLevel) return false;
        if (alarmAppend1 != that.alarmAppend1) return false;
        if (alarmAppend2 != that.alarmAppend2) return false;
        if (alarmAppend3 != that.alarmAppend3) return false;
        if (alarmAppend4 != that.alarmAppend4) return false;
        if (moduleNumber != that.moduleNumber) return false;
        if (messageCode != null ? !messageCode.equals(that.messageCode) : that.messageCode != null) return false;
        if (displayContent1 != null ? !displayContent1.equals(that.displayContent1) : that.displayContent1 != null)
            return false;
        if (displayContent2 != null ? !displayContent2.equals(that.displayContent2) : that.displayContent2 != null)
            return false;
        if (tipsContent1 != null ? !tipsContent1.equals(that.tipsContent1) : that.tipsContent1 != null) return false;
        if (tipsContent2 != null ? !tipsContent2.equals(that.tipsContent2) : that.tipsContent2 != null) return false;
        if (inPage != null ? !inPage.equals(that.inPage) : that.inPage != null) return false;
        if (usedControl != null ? !usedControl.equals(that.usedControl) : that.usedControl != null) return false;
        if (alarmAppend5 != null ? !alarmAppend5.equals(that.alarmAppend5) : that.alarmAppend5 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) languageId;
        result = 31 * result + (messageCode != null ? messageCode.hashCode() : 0);
        result = 31 * result + (displayContent1 != null ? displayContent1.hashCode() : 0);
        result = 31 * result + (displayContent2 != null ? displayContent2.hashCode() : 0);
        result = 31 * result + (tipsContent1 != null ? tipsContent1.hashCode() : 0);
        result = 31 * result + (tipsContent2 != null ? tipsContent2.hashCode() : 0);
        result = 31 * result + (inPage != null ? inPage.hashCode() : 0);
        result = 31 * result + (usedControl != null ? usedControl.hashCode() : 0);
        result = 31 * result + (int) messageDegree;
        result = 31 * result + (int) messageLevel;
        result = 31 * result + (int) alarmAppend1;
        result = 31 * result + (int) alarmAppend2;
        result = 31 * result + (int) alarmAppend3;
        result = 31 * result + (int) (alarmAppend4 ^ (alarmAppend4 >>> 32));
        result = 31 * result + (alarmAppend5 != null ? alarmAppend5.hashCode() : 0);
        result = 31 * result + (int) moduleNumber;
        return result;
    }
}
