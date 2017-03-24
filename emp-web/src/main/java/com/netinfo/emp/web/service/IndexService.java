package com.netinfo.emp.web.service;

import com.netinfo.emp.common.WebReturn;
import com.netinfo.emp.core.common.CoreDefine;
import com.netinfo.emp.utils.WebHelper;
import com.netinfo.emp.web.feign.CoreClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Project emp-web
 * Package com.netinfo.emp.web.service
 * <p>
 * Created by Charley on 2017/3/10.
 */
@Service
public class IndexService {
    private static Logger logger = LoggerFactory.getLogger(IndexService.class);
    @Autowired
    private CoreClient coreClient;

    private Integer count = 0;

    public void addCount() {
        count++;
    }

    public Integer getCount() {
        return count;
    }

    public String genUserId() throws Exception {
        String apiId = String.format("/%s", CoreDefine.PATH_LOGINS);
        String userToken = "abc";
        String resource = "105";
        String middle = "";
        Long timestamp = System.currentTimeMillis();
        String strTimestamp = timestamp.toString();
        Map<String, String> mapParam = new HashMap<>();
        mapParam.put("resource", resource);
        mapParam.put("middle", middle);
        String requestToken = WebHelper.genRequestToken(apiId, userToken, strTimestamp, mapParam);
        WebReturn webReturn = coreClient.sidGen(userToken, requestToken, strTimestamp, resource, middle);
        if (!webReturn.isResult()) {
            logger.error(String.format("Gen fail. %d %s", webReturn.getCode(), webReturn.getMsg()));
            return "";
        }
        String strId = webReturn.getData().toString();
        logger.info(String.format("Gen ID %s", strId));
        return strId;
    }
}
