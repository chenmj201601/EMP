package com.netinfo.emp.web.service;

import com.netinfo.emp.common.WebReturn;
import com.netinfo.emp.core.common.CoreDefine;
import com.netinfo.emp.utils.WebHelper;
import com.netinfo.emp.web.WebDefine;
import com.netinfo.emp.web.feign.CoreClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
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

    private Map<Integer, Map<String, String>> langList = new HashMap<>();
    private Map<String, Integer> sessionLangIds = new HashMap<>();


    public void loadLangs(Integer langId) {
        try {
            Map<String, String> langs = new HashMap<>();
            String apiId = String.format("/%s", CoreDefine.PATH_LANGUAGES);
            String userToken = "";
            Long timestamp = System.currentTimeMillis();
            String strTimestamp = timestamp.toString();
            String strLangId = langId.toString();
            Map<String, String> params = new HashMap<>();
            params.put(CoreDefine.FIELD_LANG_ID, strLangId);
            String requestToken = WebHelper.genRequestToken(apiId, userToken, strTimestamp, params);
            if (coreClient != null) {
                WebReturn webReturn = coreClient.langQuery(userToken, requestToken, strTimestamp, strLangId);
                if (!webReturn.isResult()) {
                    logger.error(String.format("Get langs fail %d %s", webReturn.getCode(), webReturn.getMsg()));
                } else {
                    if (webReturn.getData() != null) {
                        List<Map<String, Object>> nodes = (List<Map<String, Object>>) webReturn.getData();
                        for (Map<String, Object> node : nodes) {
                            langs.put(node.get(WebDefine.FIELD_LANG_KEY).toString(), node.get(WebDefine.FIELD_LANG_DISPLAY).toString());
                        }
                    }
                }
            }
            langList.put(langId, langs);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            ex.printStackTrace();
        }
    }

    public Map<String, String> getLangs(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String sessionId = session.getId();
        Integer langId = sessionLangIds.get(sessionId);
        if (langId == null) {
            langId = 1033;
            if (request.getHeader("Accept-Language") != null) {
                String defaultLang = request.getHeader("Accept-Language");
                if (defaultLang.startsWith("en-US")) {
                    langId = 1033;
                }
                if (defaultLang.startsWith("zh-CN")
                        || defaultLang.startsWith("zh-Hans-CN")) {
                    langId = 2052;
                }
            }
            Map<String, String> langs = langList.get(langId);
            if (langs == null) {
                loadLangs(langId);
            }
            sessionLangIds.put(sessionId, langId);
        }
        return langList.get(langId);
    }

    public void changeLang(Integer langId, HttpServletRequest request) {
        loadLangs(langId);
        HttpSession session = request.getSession();
        String sessionId = session.getId();
        sessionLangIds.put(sessionId, langId);
    }
}
