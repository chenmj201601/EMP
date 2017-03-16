package com.netinfo.emp.web.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * Project emp-web
 * Package com.netinfo.emp.web.entity
 * <p>
 * Created by Charley on 2017/3/16.
 */
public class SessionLang {
    private Integer langId;
    private Map<String, String> langs = new HashMap<>();

    public Integer getLangId() {
        return langId;
    }

    public void setLangId(Integer langId) {
        this.langId = langId;
    }

    public Map<String, String> getLangs() {
        return langs;
    }

    public void setLangs(Map<String, String> langs) {
        this.langs = langs;
    }
}
