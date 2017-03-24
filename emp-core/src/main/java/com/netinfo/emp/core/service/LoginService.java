package com.netinfo.emp.core.service;

import com.netinfo.emp.common.Defines;
import com.netinfo.emp.common.EncryptionMode;
import com.netinfo.emp.common.WebReturn;
import com.netinfo.emp.core.common.CoreDefine;
import com.netinfo.emp.core.entity.Account;
import com.netinfo.emp.core.entity.Login;
import com.netinfo.emp.core.feign.CoreDbClient;
import com.netinfo.emp.encryptions.AESEncryption;
import com.netinfo.emp.encryptions.SHAEncryption;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

/**
 * Project emp-core
 * Package com.netinfo.emp.core.service
 * <p>
 * Created by Charley on 2017/3/23.
 */
@Service
public class LoginService {
    private static Logger log = LoggerFactory.getLogger(LoginService.class);

    @Autowired
    private AccountService accountService;
    @Autowired
    private CoreDbClient coreDbClient;
    @Autowired
    private SequenceService sequenceService;

    public WebReturn login(String account, String password, String host, String ip) {
        WebReturn webReturn = new WebReturn();
        try {
            log.info(String.format("Login account:%s password:%s", account, password));
            password = AESEncryption.decryptString(password, EncryptionMode.AES256_01_HEX_UNICODE);
            Account loginAccount = accountService.queryAccount(account);
            if (loginAccount == null) {
                webReturn.setResult(false);
                webReturn.setCode(CoreDefine.RET_USER_NOT_EXIST);
                webReturn.setMsg(String.format("Account not exist."));
                return webReturn;
            }
            long userId = loginAccount.getId();
            String strIdPassword = SHAEncryption.encryptString(AESEncryption.encryptString(String.format("%d%s", userId, password), EncryptionMode.AES256_02_HEX_UNICODE), EncryptionMode.SHA512_00_HEX_UNICODE);
            if (!strIdPassword.equals(loginAccount.getPassword())) {
                webReturn.setResult(false);
                webReturn.setCode(CoreDefine.RET_PASSWORD_ERROR);
                webReturn.setMsg(String.format("Password error."));
                return webReturn;
            }
            webReturn = coreDbClient.loginQueryAccountId(String.format("%d", userId));
            if (!webReturn.isResult()) {
                return webReturn;
            }
            List<Map<String, Object>> datas = (List<Map<String, Object>>) webReturn.getData();
            if (datas == null) {
                webReturn.setResult(false);
                webReturn.setCode(Defines.RET_OBJECT_NULL);
                webReturn.setMsg(String.format("WebReturn datas is null."));
                return webReturn;
            }
            if (datas.size() > 0) {
                webReturn.setResult(false);
                webReturn.setCode(CoreDefine.RET_ALREADY_LOGINED);
                webReturn.setMsg(String.format("Account already logined."));
                return webReturn;
            }
            String strId = sequenceService.generate(Defines.RESOURCE_LOGIN, "");
            if ("".equals(strId)) {
                webReturn.setResult(false);
                webReturn.setCode(CoreDefine.RET_ALREADY_LOGINED);
                webReturn.setMsg(String.format("Login id is empty."));
                return webReturn;
            }
            long loginId = Long.parseLong(strId);
            Date now = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
            format.setTimeZone(TimeZone.getTimeZone("GMT"));
            Login login = new Login();
            login.setId(loginId);
            login.setUserId(userId);
            login.setLoginTime(now);
            login.setResult("0000000000000000");
            login.setToken("000");
            login.setHost(host);
            login.setAddress(ip);
            login.setExited(false);
            login.setExitedMethod("N");
            login.setExitedTime(format.parse("19000101000000"));
            login.setLastActiveTime(now);
            webReturn = coreDbClient.loginAdd(String.format("%d", login.getId()),
                    String.format("%d", login.getUserId()),
                    format.format(login.getLoginTime()),
                    login.getResult(),
                    login.getToken(),
                    login.getHost(),
                    login.getAddress(),
                    login.isExited() ? "1" : "0",
                    login.getExitedMethod(),
                    format.format(login.getExitedTime()),
                    format.format(login.getLastActiveTime()));
            if (!webReturn.isResult()) {
                return webReturn;
            }
            webReturn.setMsg(strId);
            webReturn.setData(login);
        } catch (Exception ex) {
            webReturn.setResult(false);
            webReturn.setCode(Defines.RET_FAIL);
            webReturn.setMsg(String.format(ex.getMessage()));
            ex.printStackTrace();
        }
        return webReturn;
    }
}
