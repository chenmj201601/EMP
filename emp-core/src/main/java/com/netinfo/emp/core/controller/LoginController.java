package com.netinfo.emp.core.controller;

import com.netinfo.emp.common.Defines;
import com.netinfo.emp.common.WebReturn;
import com.netinfo.emp.core.common.ApiDefine;
import com.netinfo.emp.core.service.LoginService;
import com.netinfo.emp.utils.WebHelper;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Project emp-core
 * Package com.netinfo.emp.core.controller
 * <p>
 * Created by Charley on 2017/3/11.
 */
@RestController
@RequestMapping("/" + ApiDefine.PATH_LOGINS)
public class LoginController {
    private static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/" + ApiDefine.PATH_LOGIN, method = RequestMethod.POST)
    @ApiOperation(value = "登录系统", notes = "api_id:" + 10100201)
    public WebReturn login(@RequestParam(Defines.FIELD_REQUEST_TOKEN) String requestToken,
                           @RequestParam(Defines.FIELD_TIMESTAMP) String timestamp,
                           @RequestParam(ApiDefine.FIELD_ACCOUNT) String account,
                           @RequestParam(ApiDefine.FIELD_PASSWORD) String password,
                           @RequestParam(value = ApiDefine.FIELD_HOST, required = false, defaultValue = "") String host,
                           @RequestParam(value = ApiDefine.FIELD_IP, required = false, defaultValue = "") String ip,
                           HttpServletRequest request) throws Exception {
        logger.info(String.format("request_token:%s timestamp:%s account:%s password:%s host:%s ip:%s",
                requestToken,
                timestamp,
                account,
                password,
                host,
                ip));
        String apiId = String.format("%02d%04d%02d", Defines.MODULE_CORE, ApiDefine.CTL_LOGIN, ApiDefine.FN_LOGIN_LOGIN);
        String userToken = "";
        List<String> listRequest = new ArrayList<>();
        listRequest.add(apiId);
        listRequest.add(userToken);
        listRequest.add(requestToken);
        listRequest.add(timestamp);
        Map<String, String> mapParam = new HashMap<>();
        mapParam.put(ApiDefine.FIELD_ACCOUNT, account);
        mapParam.put(ApiDefine.FIELD_PASSWORD, password);
        if ("".equals(host) || "".equals(ip)) {
            host = request.getRemoteHost();
            ip = request.getRemoteAddr();
            int port = request.getRemotePort();
            ip = String.format("%s:%d", ip, port);
        } else {
            mapParam.put(ApiDefine.FIELD_HOST, host);
            mapParam.put(ApiDefine.FIELD_IP, ip);
        }
        logger.info(String.format("RemoteHost:%s RemoteAddr:%s", host, ip));
        WebReturn webReturn = WebHelper.checkRequestToken(listRequest, mapParam);
        if (!webReturn.isResult()) {
            return webReturn;
        }
        return loginService.login(account, password, host, ip);
    }
}
