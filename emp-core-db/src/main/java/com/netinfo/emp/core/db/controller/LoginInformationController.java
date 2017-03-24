package com.netinfo.emp.core.db.controller;

import com.netinfo.emp.common.Defines;
import com.netinfo.emp.common.WebReturn;
import com.netinfo.emp.core.db.entity.LoginInformation;
import com.netinfo.emp.core.db.repository.LoginInformationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Project emp-core-db
 * Package com.netinfo.emp.core.db.controller
 * <p>
 * Created by Charley on 2017/3/23.
 */
@RestController
@RequestMapping("/logins")
public class LoginInformationController {
    private static Logger logger = LoggerFactory.getLogger(LoginInformationController.class);

    @Autowired
    private LoginInformationRepository loginInformationRepository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public WebReturn list() {
        WebReturn webReturn = new WebReturn();
        List<LoginInformation> logins = loginInformationRepository.findAll(new Sort(Sort.Direction.DESC, "loginTime", "accountId"));
        int count = logins.size();
        webReturn.setMsg(String.format("%d", count));
        webReturn.setData(logins);
        return webReturn;
    }

    @RequestMapping(value = "/{login_id}", method = RequestMethod.GET)
    public WebReturn querySystemId(@PathVariable("login_id") Long systemId) {
        logger.info(String.format("LoginId:%s", systemId));
        WebReturn webReturn = new WebReturn();
        LoginInformation login = loginInformationRepository.findOne(systemId);
        webReturn.setData(login);
        return webReturn;
    }

    @RequestMapping(value = "/account_id/{account_id}", method = RequestMethod.GET)
    public WebReturn queryAccountId(@PathVariable("account_id") Long accountId) {
        logger.info(String.format("AccountId:%s", accountId));
        WebReturn webReturn = new WebReturn();
        List<LoginInformation> logins = loginInformationRepository.findByAccountId(accountId);
        int count = logins.size();
        webReturn.setMsg(String.format("%d", count));
        webReturn.setData(logins);
        return webReturn;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public WebReturn add(@RequestParam("login_id") long systemId,
                         @RequestParam("account_id") long accountId,
                         @RequestParam("login_time") long loginTime,
                         @RequestParam("login_result") String loginResult,
                         @RequestParam("token_key") String tokenKey,
                         @RequestParam(value = "login_host", required = false, defaultValue = "") String loginHost,
                         @RequestParam(value = "login_address", required = false, defaultValue = "") String loginAddress,
                         @RequestParam("exited") String isExited,
                         @RequestParam("exited_method") String exitedMethod,
                         @RequestParam(value = "exited_time", required = false, defaultValue = "0") long exitedTime,
                         @RequestParam(value = "last_interactive_time", required = false, defaultValue = "0") long lastInteractiveTime) {
        logger.info(String.format("LoginId:%s AccountId:%s LoginTime:%s", systemId, accountId, loginTime));
        WebReturn webReturn = new WebReturn();
        try {
            LoginInformation login = new LoginInformation();
            login.setSystemId(systemId);
            login.setAccountId(accountId);
            login.setLoginTime(loginTime);
            login.setLoginResult(loginResult);
            login.setTokenKey(tokenKey);
            login.setLoginHost(loginHost);
            login.setLoginAddress(loginAddress);
            login.setIsExited(isExited);
            login.setExitedMethod(exitedMethod);
            login.setExitedTime(exitedTime);
            login.setLastInteractionTime(lastInteractiveTime);
            loginInformationRepository.save(login);
            webReturn.setMsg(String.format("[%d][%d][%d]", systemId, accountId, loginTime));
            webReturn.setData(login);
        } catch (Exception ex) {
            webReturn.setResult(false);
            webReturn.setCode(Defines.RET_FAIL);
            webReturn.setMsg(ex.getMessage());
            ex.printStackTrace();
            return webReturn;
        }
        return webReturn;
    }
}
