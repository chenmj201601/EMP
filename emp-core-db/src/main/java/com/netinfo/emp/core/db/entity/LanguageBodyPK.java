package com.netinfo.emp.core.db.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Project charley-web-09
 * Package com.netinfo.emp.core.db.entity
 * <p>
 * Created by Charley on 2017/3/24.
 */
public class LanguageBodyPK implements Serializable {
    private short languageId;
    private String messageCode;

    @Column(name = "LANGUAGE_ID")
    @Id
    public short getLanguageId() {
        return languageId;
    }

    public void setLanguageId(short languageId) {
        this.languageId = languageId;
    }

    @Column(name = "MESSAGE_CODE")
    @Id
    public String getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(String messageCode) {
        this.messageCode = messageCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LanguageBodyPK that = (LanguageBodyPK) o;

        if (languageId != that.languageId) return false;
        if (messageCode != null ? !messageCode.equals(that.messageCode) : that.messageCode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) languageId;
        result = 31 * result + (messageCode != null ? messageCode.hashCode() : 0);
        return result;
    }
}
