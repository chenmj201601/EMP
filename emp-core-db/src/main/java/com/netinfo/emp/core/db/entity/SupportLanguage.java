package com.netinfo.emp.core.db.entity;

import javax.persistence.*;

/**
 * Project charley-web-09
 * Package com.netinfo.emp.core.db.entity
 * <p>
 * Created by Charley on 2017/3/24.
 */
@Entity
@Table(name = "SUPPORT_LANGUAGE")
public class SupportLanguage {
    private short languageId;
    private String languageName;
    private String languageCulture;
    private String shortName;
    private short referenceId;
    private String codePage;
    private short orderId;
    private String displayPicture;
    private String languageVersion;
    private String isModified;
    private long lastModifiedTime;
    private String isActive;
    private String isDeleted;
    private String isSupport;

    @Id
    @Column(name = "LANGUAGE_ID")
    public short getLanguageId() {
        return languageId;
    }

    public void setLanguageId(short languageId) {
        this.languageId = languageId;
    }

    @Basic
    @Column(name = "LANGUAGE_NAME")
    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    @Basic
    @Column(name = "LANGUAGE_CULTURE")
    public String getLanguageCulture() {
        return languageCulture;
    }

    public void setLanguageCulture(String languageCulture) {
        this.languageCulture = languageCulture;
    }

    @Basic
    @Column(name = "SHORT_NAME")
    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    @Basic
    @Column(name = "REFERENCE_ID")
    public short getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(short referenceId) {
        this.referenceId = referenceId;
    }

    @Basic
    @Column(name = "CODE_PAGE")
    public String getCodePage() {
        return codePage;
    }

    public void setCodePage(String codePage) {
        this.codePage = codePage;
    }

    @Basic
    @Column(name = "ORDER_ID")
    public short getOrderId() {
        return orderId;
    }

    public void setOrderId(short orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "DISPLAY_PICTURE")
    public String getDisplayPicture() {
        return displayPicture;
    }

    public void setDisplayPicture(String displayPicture) {
        this.displayPicture = displayPicture;
    }

    @Basic
    @Column(name = "LANGUAGE_VERSION")
    public String getLanguageVersion() {
        return languageVersion;
    }

    public void setLanguageVersion(String languageVersion) {
        this.languageVersion = languageVersion;
    }

    @Basic
    @Column(name = "IS_MODIFIED")
    public String getIsModified() {
        return isModified;
    }

    public void setIsModified(String isModified) {
        this.isModified = isModified;
    }

    @Basic
    @Column(name = "LAST_MODIFIED_TIME")
    public long getLastModifiedTime() {
        return lastModifiedTime;
    }

    public void setLastModifiedTime(long lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
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
    @Column(name = "IS_SUPPORT")
    public String getIsSupport() {
        return isSupport;
    }

    public void setIsSupport(String isSupport) {
        this.isSupport = isSupport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SupportLanguage that = (SupportLanguage) o;

        if (languageId != that.languageId) return false;
        if (referenceId != that.referenceId) return false;
        if (orderId != that.orderId) return false;
        if (lastModifiedTime != that.lastModifiedTime) return false;
        if (languageName != null ? !languageName.equals(that.languageName) : that.languageName != null) return false;
        if (languageCulture != null ? !languageCulture.equals(that.languageCulture) : that.languageCulture != null)
            return false;
        if (shortName != null ? !shortName.equals(that.shortName) : that.shortName != null) return false;
        if (codePage != null ? !codePage.equals(that.codePage) : that.codePage != null) return false;
        if (displayPicture != null ? !displayPicture.equals(that.displayPicture) : that.displayPicture != null)
            return false;
        if (languageVersion != null ? !languageVersion.equals(that.languageVersion) : that.languageVersion != null)
            return false;
        if (isModified != null ? !isModified.equals(that.isModified) : that.isModified != null) return false;
        if (isActive != null ? !isActive.equals(that.isActive) : that.isActive != null) return false;
        if (isDeleted != null ? !isDeleted.equals(that.isDeleted) : that.isDeleted != null) return false;
        if (isSupport != null ? !isSupport.equals(that.isSupport) : that.isSupport != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) languageId;
        result = 31 * result + (languageName != null ? languageName.hashCode() : 0);
        result = 31 * result + (languageCulture != null ? languageCulture.hashCode() : 0);
        result = 31 * result + (shortName != null ? shortName.hashCode() : 0);
        result = 31 * result + (int) referenceId;
        result = 31 * result + (codePage != null ? codePage.hashCode() : 0);
        result = 31 * result + (int) orderId;
        result = 31 * result + (displayPicture != null ? displayPicture.hashCode() : 0);
        result = 31 * result + (languageVersion != null ? languageVersion.hashCode() : 0);
        result = 31 * result + (isModified != null ? isModified.hashCode() : 0);
        result = 31 * result + (int) (lastModifiedTime ^ (lastModifiedTime >>> 32));
        result = 31 * result + (isActive != null ? isActive.hashCode() : 0);
        result = 31 * result + (isDeleted != null ? isDeleted.hashCode() : 0);
        result = 31 * result + (isSupport != null ? isSupport.hashCode() : 0);
        return result;
    }
}
