package com.netinfo.emp.core.service;

import com.netinfo.emp.common.Defines;
import com.netinfo.emp.common.WebReturn;
import com.netinfo.emp.core.entity.LangInfo;
import com.netinfo.emp.core.feign.CoreDbClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Project emp-core
 * Package com.netinfo.emp.core.service
 * <p>
 * Created by Charley on 2017/3/24.
 */
@Service
public class LanguageService {
    private static Logger logger = LoggerFactory.getLogger(LanguageService.class);

    @Autowired
    private CoreDbClient coreDbClient;

    public WebReturn query(short langId) {
        logger.info(String.format("LangId:%d", langId));
        WebReturn webReturn = coreDbClient.langInfoQueryLangId(langId);
        if (!webReturn.isResult()) {
            return webReturn;
        }
        List<Map<String, Object>> datas = (List<Map<String, Object>>) webReturn.getData();
        if (datas == null) {
            webReturn.setResult(false);
            webReturn.setCode(Defines.RET_OBJECT_NULL);
            webReturn.setMsg(String.format("WebReturn data is null"));
            return webReturn;
        }
        List<LangInfo> langInfos = new ArrayList<>();
        for (Map<String, Object> data : datas) {
            langInfos.add(LangInfo.fromT(data));
        }
        webReturn.setData(langInfos);
        return webReturn;
    }

    public WebReturn query(short langId, short moduleNumber) {
        logger.info(String.format("LangId:%d ModuleNumber:%d", langId, moduleNumber));
        WebReturn webReturn = coreDbClient.langInfoQueryLangIdModuleNumber(langId, moduleNumber);
        if (!webReturn.isResult()) {
            return webReturn;
        }
        List<Map<String, Object>> datas = (List<Map<String, Object>>) webReturn.getData();
        if (datas == null) {
            webReturn.setResult(false);
            webReturn.setCode(Defines.RET_OBJECT_NULL);
            webReturn.setMsg(String.format("WebReturn data is null"));
            return webReturn;
        }
        List<LangInfo> langInfos = new ArrayList<>();
        for (Map<String, Object> data : datas) {
            langInfos.add(LangInfo.fromT(data));
        }
        webReturn.setData(langInfos);
        return webReturn;
    }

    public WebReturn query(short langId, String pageName) {
        logger.info(String.format("LangId:%d PageName:%s", langId, pageName));
        WebReturn webReturn = coreDbClient.langInfoQueryLangIdPageName(langId, pageName);
        if (!webReturn.isResult()) {
            return webReturn;
        }
        List<Map<String, Object>> datas = (List<Map<String, Object>>) webReturn.getData();
        if (datas == null) {
            webReturn.setResult(false);
            webReturn.setCode(Defines.RET_OBJECT_NULL);
            webReturn.setMsg(String.format("WebReturn data is null"));
            return webReturn;
        }
        List<LangInfo> langInfos = new ArrayList<>();
        for (Map<String, Object> data : datas) {
            langInfos.add(LangInfo.fromT(data));
        }
        webReturn.setData(langInfos);
        return webReturn;
    }
}
