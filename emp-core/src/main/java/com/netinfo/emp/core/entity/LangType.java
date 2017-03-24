package com.netinfo.emp.core.entity;

import java.util.Map;

/**
 * Project emp-core
 * Package com.netinfo.emp.core.entity
 * <p>
 * Created by Charley on 2017/3/24.
 */
public class LangType {
    private int id;
    private String name;
    private String culture;
    private String shortName;
    private int referenceId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCulture() {
        return culture;
    }

    public void setCulture(String culture) {
        this.culture = culture;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public int getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(int referenceId) {
        this.referenceId = referenceId;
    }

    public static LangType fromT(Map<String, Object> map) {
        LangType langType = new LangType();
        langType.setId((int) map.get("language_id"));
        langType.setName(map.get("language_name").toString());
        if (map.get("language_culture") != null) {
            langType.setCulture(map.get("language_culture").toString());
        }
        if (map.get("short_name") != null) {
            langType.setCulture(map.get("short_name").toString());
        }
        langType.setReferenceId((int) map.get("reference_id"));
        return langType;
    }
}
