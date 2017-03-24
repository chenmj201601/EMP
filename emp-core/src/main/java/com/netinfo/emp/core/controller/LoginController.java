package com.netinfo.emp.core.controller;

import com.netinfo.emp.common.WebReturn;
import com.netinfo.emp.core.common.CoreDefine;
import com.netinfo.emp.core.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Project emp-core
 * Package com.netinfo.emp.core.controller
 * <p>
 * Created by Charley on 2017/3/23.
 */
@RestController
@RequestMapping("/" + CoreDefine.PATH_LOGINS)
public class LoginController {
    private static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public WebReturn login(@RequestParam(value = CoreDefine.FIELD_ACCOUNT) String account,
                           @RequestParam(value = CoreDefine.FIELD_PASSWORD) String password,
                           @RequestParam(value = CoreDefine.FIELD_HOST, required = false, defaultValue = "") String host,
                           @RequestParam(value = CoreDefine.FIELD_IP, required = false, defaultValue = "") String address,
                           HttpServletRequest request) {
        logger.info(String.format("Account:%s Password:%s", account, password));
        if ("".equals(host)
                || "".equals(address)) {
            host = request.getRemoteHost();
            address = request.getRemoteAddr();
            int port = request.getRemotePort();
            address = String.format("%s:%d", address, port);
            logger.info(String.format("Host:%s Address:%s", host, address));
        }
        WebReturn webReturn = loginService.login(account, password, host, address);
        return webReturn;
    }
}
