package com.netinfo.emp.web.service;

import com.netinfo.emp.common.Defines;
import com.netinfo.emp.common.WebReturn;
import com.netinfo.emp.core.common.ApiDefine;
import com.netinfo.emp.utils.WebHelper;
import com.netinfo.emp.web.entity.SessionLang;
import com.netinfo.emp.web.feign.CoreClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Project emp-web
 * Package com.netinfo.emp.web.service
 * <p>
 * Created by Charley on 2017/3/15.
 */
@Service
public class LangService {
    private static Logger logger = LoggerFactory.getLogger(LangService.class);

    @Autowired
    private CoreClient coreClient;

    private Map<String, SessionLang> sessionLangs = new HashMap<>();


    public void loadLangs(SessionLang sessionLang) {
        try {
            Map<String, String> langs = sessionLang.getLangs();
            Integer langId = sessionLang.getLangId();
            langs.clear();
            String apiId = String.format("%02d%04d%02d", Defines.MODULE_CORE, ApiDefine.CTL_LANG_INFO, ApiDefine.FN_LANG_INFO_QUERY);
            String userToken = "";
            Long timestamp = System.currentTimeMillis();
            String strTimestamp = timestamp.toString();
            String strLangId = langId.toString();
            String page = "100001";
            Map<String, String> params = new HashMap<>();
            params.put(ApiDefine.FIELD_LANG_ID, strLangId);
            params.put(ApiDefine.FIELD_PAGE, page);
            String requestToken = WebHelper.genRequestToken(apiId, userToken, strTimestamp, params);
            if (coreClient != null) {
                WebReturn webReturn = coreClient.langQuery(userToken, requestToken, strTimestamp, strLangId, page);
                if (!webReturn.isResult()) {
                    logger.error(String.format("Get langs fail %d %s", webReturn.getCode(), webReturn.getMsg()));
                } else {
                    if (webReturn.getData() != null) {
                        List<LinkedHashMap<String, String>> nodes = (List<LinkedHashMap<String, String>>) webReturn.getData();
                        for (LinkedHashMap<String, String> node : nodes) {
                            langs.put(node.get("name"), node.get("display"));
                        }
                    }
                }
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            ex.printStackTrace();
        }
    }

    public Map<String, String> getLangs(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String sessionId = session.getId();
        SessionLang sessionLang = sessionLangs.get(sessionId);
        if (sessionLang == null) {
            Integer langId = 1033;
            if (request.getHeader("Accept-Language") != null) {
                String defaultLang = request.getHeader("Accept-Language");
                if (defaultLang.startsWith("en-US")) {
                    langId = 1033;
                }
                if (defaultLang.startsWith("zh-CN")) {
                    langId = 2052;
                }
            }
            sessionLang = new SessionLang();
            sessionLang.setLangId(langId);
            loadLangs(sessionLang);
        }
        return sessionLang.getLangs();
    }

    public void changeLang(Integer langId, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String sessionId = session.getId();
        SessionLang sessionLang = new SessionLang();
        sessionLang.setLangId(langId);
        loadLangs(sessionLang);
        sessionLangs.put(sessionId, sessionLang);
    }
}
