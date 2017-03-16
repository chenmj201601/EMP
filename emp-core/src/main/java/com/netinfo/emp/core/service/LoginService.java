package com.netinfo.emp.core.service;

import com.netinfo.emp.common.Defines;
import com.netinfo.emp.common.EncryptionMode;
import com.netinfo.emp.common.WebReturn;
import com.netinfo.emp.core.common.ApiDefine;
import com.netinfo.emp.core.dao.LoginTableRepository;
import com.netinfo.emp.core.entity.Login;
import com.netinfo.emp.core.entity.LoginTable;
import com.netinfo.emp.core.entity.User;
import com.netinfo.emp.encryptions.AESEncryption;
import com.netinfo.emp.encryptions.SHAEncryption;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/**
 * Project emp-core
 * Package com.netinfo.emp.core.service
 * <p>
 * Created by Charley on 2017/3/11.
 */
@Service
public class LoginService {
    private static final Logger log = LoggerFactory.getLogger(LoginService.class);

    @Autowired
    private SIDService sidService;
    @Autowired
    private UserService userService;
    @Autowired
    private LoginTableRepository loginTableRepository;

    public WebReturn login(String account, String password, String host, String ip) throws Exception {
        log.info(String.format("Login account:%s password:%s", account, password));
        WebReturn webReturn = new WebReturn();
        webReturn.setResult(true);
        webReturn.setCode(0);
        webReturn.setMsg("");
        password = AESEncryption.decryptString(password, EncryptionMode.AES256_01_HEX_UNICODE);
        //找到对应的用户信息
        User user = userService.findByAccount(account);
        if (user == null) {
            webReturn.setResult(false);
            webReturn.setCode(ApiDefine.RET_USER_NOT_EXIST);
            webReturn.setMsg(String.format("User not exist %s", account));
            return webReturn;
        }
        //获取UserId，生成密码，然后比较密码是否正确
        Long userId = user.getId();
        String idAndPassword = SHAEncryption.encryptString(AESEncryption.encryptString(String.format("%d%s", userId, password), EncryptionMode.AES256_02_HEX_UNICODE), EncryptionMode.SHA512_00_HEX_UNICODE);
        if (!user.getPassword().equals(idAndPassword)) {
            webReturn.setResult(false);
            webReturn.setCode(ApiDefine.RET_PASSWORD_ERROR);
            webReturn.setMsg(String.format("Password error %s", account));
            return webReturn;
        }
        user.setOriginalPassword(password);
        List<LoginTable> loginTables = loginTableRepository.findByC004(userId);
        if (loginTables.size() > 0) {
            //用户已经登录系统，返回已经登录信息，此处简单处理，没有考虑多登录
            List<Login> logins = new ArrayList<>();
            for (LoginTable loginTable : loginTables) {
                Login login = loginTable.ofLogin();
                logins.add(login);
            }
            webReturn.setResult(false);
            webReturn.setCode(ApiDefine.RET_ALREADY_LOGINED);
            webReturn.setMsg(String.format("User already logined %s", account));
            webReturn.setData(logins);
            return webReturn;
        }
        //生成登录流水号
        String strId = sidService.gen(Defines.RESOURCE_LOGIN, "");
        if ("".equals(strId)) {
            webReturn.setResult(false);
            webReturn.setCode(ApiDefine.RET_GEN_ID_FAIL);
            webReturn.setMsg(String.format("Generator serial id fail"));
            return webReturn;
        }
        Long id = Long.parseLong(strId);
        LoginTable loginTable = loginTableRepository.findOne(id);
        Date now = new Date();
        Login login;
        if (loginTable == null) {
            login = new Login();
            login.setId(id);
            login.setUserId(userId);
            login.setLoginTime(now);
        } else {
            login = loginTable.ofLogin();
        }
        login.setLoginResult("0000000000000000");
        login.setLoginHost(host);
        login.setLoginIP(ip);
        login.setExited(false);
        login.setExitedMethod("N");
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        format.setTimeZone(TimeZone.getTimeZone("GMT"));
        login.setExitTime(format.parse("19000101000000"));
        login.setLastActiveTime(now);
        loginTable = LoginTable.fromLogin(login);
        loginTableRepository.save(loginTable);
        log.info(String.format("%s logined LoginId:%d", account, id));
        webReturn.setData(login);
        return webReturn;
    }
}
