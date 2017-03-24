package com.netinfo.emp.core.entity;

import java.util.Map;

/**
 * Project emp-core
 * Package com.netinfo.emp.core.entity
 * <p>
 * Created by Charley on 2017/3/24.
 */
public class LangInfo {
    private int langId;
    private String key;
    private String display;
    private String tip;
    private String pageName;
    private String objName;
    private int moduleNumber;

    public int getLangId() {
        return langId;
    }

    public void setLangId(int langId) {
        this.langId = langId;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public String getObjName() {
        return objName;
    }

    public void setObjName(String objName) {
        this.objName = objName;
    }

    public int getModuleNumber() {
        return moduleNumber;
    }

    public void setModuleNumber(int moduleNumber) {
        this.moduleNumber = moduleNumber;
    }

    public static LangInfo fromT(Map<String, Object> map) {
        LangInfo langInfo = new LangInfo();
        langInfo.setLangId((int) map.get("language_id"));
        langInfo.setKey(map.get("message_code").toString());
        String display = "";
        if (map.get("display_content1") != null) {
            display += map.get("display_content1").toString();
        }
        if (map.get("display_content2") != null) {
            display += map.get("display_content2").toString();
        }
        langInfo.setDisplay(display);
        String tip = "";
        if (map.get("tip_content1") != null) {
            tip += map.get("tip_content1").toString();
        }
        if (map.get("tip_content2") != null) {
            tip += map.get("tip_content2").toString();
        }
        langInfo.setTip(tip);
        if (map.get("in_page") != null) {
            langInfo.setPageName(map.get("in_page").toString());
        }
        langInfo.setModuleNumber((int) map.get("module_number"));
        return langInfo;
    }
}
