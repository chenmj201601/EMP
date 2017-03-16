package com.netinfo.emp.core.controller;

import com.netinfo.emp.common.Defines;
import com.netinfo.emp.common.WebReturn;
import com.netinfo.emp.core.common.ApiDefine;
import com.netinfo.emp.core.service.LangInfoService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Project emp-core
 * Package com.netinfo.emp.core.controller
 * <p>
 * Created by Charley on 2017/3/14.
 */
@RestController
@RequestMapping("/" + ApiDefine.PATH_LANGS)
public class LangInfoController {
    private static Logger logger = LoggerFactory.getLogger(LangInfoController.class);

    @Autowired
    private LangInfoService langInfoService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ApiOperation(value = "获取语言包列表", notes = "api_id:" + 10100301)
    public WebReturn query(@RequestParam(value = Defines.FIELD_USER_TOKEN, required = false, defaultValue = "") String userToken,
                           @RequestParam(Defines.FIELD_REQUEST_TOKEN) String requestToken,
                           @RequestParam(Defines.FIELD_TIMESTAMP) String timestamp,
                           @RequestParam(ApiDefine.FIELD_LANG_ID) short langId,
                           @RequestParam(name = ApiDefine.FIELD_PAGE, required = false, defaultValue = "") String page) throws Exception {
        logger.info(String.format("lang_id:%s page:%s", langId, page));
        String apiId = String.format("%02d%04d%02d", Defines.MODULE_CORE, ApiDefine.CTL_LANG_INFO, ApiDefine.FN_LANG_INFO_QUERY);
        List<String> requests = new ArrayList<>();
        requests.add(apiId);
        requests.add(userToken);
        requests.add(requestToken);
        requests.add(timestamp);
        Map<String, String> mapParam = new HashMap<>();
        mapParam.put(ApiDefine.FIELD_LANG_ID, String.format("%d", langId));
        if (!page.equals("")) {
            mapParam.put(ApiDefine.FIELD_PAGE, page);
        }
       /* WebReturn webReturn = WebHelper.checkRequestToken(requests, mapParam);
        if (!webReturn.isResult()) {
            return webReturn;
        }*/
        if (page.equals("")) {
            return langInfoService.query(langId);
        } else {
            return langInfoService.query(langId, page);
        }
    }
}
