package com.netinfo.emp.core.controller;

import com.netinfo.emp.common.Defines;
import com.netinfo.emp.common.WebReturn;
import com.netinfo.emp.core.common.ApiDefine;
import com.netinfo.emp.core.entity.SID;
import com.netinfo.emp.core.service.SIDService;
import com.netinfo.emp.utils.WebHelper;
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
 * Created by Charley on 2017/3/10.
 */
@RestController
@RequestMapping("/" + ApiDefine.PATH_SIDS)
public class SIDController {
    private static Logger logger = LoggerFactory.getLogger(SIDController.class);

    @Autowired
    private SIDService sidService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ApiOperation(value = "获取流水号规则列表", notes = "api_id:" + 10100101)
    public WebReturn all(@RequestParam(value = Defines.FIELD_USER_TOKEN, required = false, defaultValue = "") String userToken,
                         @RequestParam(Defines.FIELD_REQUEST_TOKEN) String requestToken,
                         @RequestParam(Defines.FIELD_TIMESTAMP) String timestamp) throws Exception {
        String apiId = String.format("%02d%04d%02d", Defines.MODULE_CORE, ApiDefine.CTL_SID, ApiDefine.FN_SID_ALL);
        List<String> listRequest = new ArrayList<>();
        listRequest.add(apiId);
        listRequest.add(userToken);
        listRequest.add(requestToken);
        listRequest.add(timestamp);
        Map<String, String> mapParam = new HashMap<>();
        WebReturn webReturn = WebHelper.checkRequestToken(listRequest, mapParam);
        if (!webReturn.isResult()) {
            return webReturn;
        }
        List<SID> sids = sidService.all();
        int count = sids.size();
        webReturn.setMsg(String.format("SID List, Count:%d", count));
        webReturn.setData(sids);
        return webReturn;
    }

    @RequestMapping(value = "/" + ApiDefine.PATH_GEN, method = RequestMethod.GET)
    @ApiOperation(value = "生成流水号", notes = "api_id:" + 10100102)
    public WebReturn gen(@RequestParam(value = Defines.FIELD_USER_TOKEN, required = false, defaultValue = "") String userToken,
                         @RequestParam(Defines.FIELD_REQUEST_TOKEN) String requestToken,
                         @RequestParam(Defines.FIELD_TIMESTAMP) String timestamp,
                         @RequestParam(ApiDefine.FIELD_RESOURCE) String resource,
                         @RequestParam(value = ApiDefine.FIELD_MIDDLE, required = false, defaultValue = "") String middle) throws Exception {
        logger.info(String.format("resource:%s middle:%s", resource, middle));
        String apiId = String.format("%02d%04d%02d", Defines.MODULE_CORE, ApiDefine.CTL_SID, ApiDefine.FN_SID_GEN);
        List<String> listRequest = new ArrayList<>();
        listRequest.add(apiId);
        listRequest.add(userToken);
        listRequest.add(requestToken);
        listRequest.add(timestamp);
        Map<String, String> mapParam = new HashMap<>();
        mapParam.put(ApiDefine.FIELD_RESOURCE, resource);
        if(!"".equals(middle)){
            mapParam.put(ApiDefine.FIELD_MIDDLE, middle);
        }
        WebReturn webReturn = WebHelper.checkRequestToken(listRequest, mapParam);
        if (!webReturn.isResult()) {
            return webReturn;
        }
        Integer intResource = Integer.parseInt(resource);
        String strId = sidService.gen(intResource, middle);
        webReturn.setMsg(strId);
        webReturn.setData(strId);
        return webReturn;
    }
}
