package com.netinfo.emp.web.controller;

import com.netinfo.emp.common.Defines;
import com.netinfo.emp.common.EncryptionMode;
import com.netinfo.emp.common.WebReturn;
import com.netinfo.emp.core.common.ApiDefine;
import com.netinfo.emp.encryptions.AESEncryption;
import com.netinfo.emp.utils.WebHelper;
import com.netinfo.emp.web.feign.CoreClient;
import com.netinfo.emp.web.service.LangService;
import com.netinfo.emp.web.util.CheckCodeHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Project emp-web
 * Package com.netinfo.emp.web.controller
 * <p>
 * Created by Charley on 2017/3/10.
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    private static final String VIEW_LOGIN = "login";
    private static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private LangService langService;

    @Autowired
    private CoreClient coreClient;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String login(@RequestParam(value = "lang_id", required = false, defaultValue = "") String langId,
                        HttpServletRequest request) {
        if (!langId.equals("")) {
            try {
                Integer intLangId = Integer.parseInt(langId);
                langService.changeLang(intLangId, request);
            } catch (Exception ex) {
                logger.error(ex.getMessage());
                ex.printStackTrace();
            }
        }
        return VIEW_LOGIN;
    }

    @RequestMapping(value = "/dologin", method = RequestMethod.POST)
    public String doLogin(@RequestParam("account") String account,
                          @RequestParam("password") String password,
                          @RequestParam("checkcode") String checkCode,
                          HttpServletRequest request,
                          Model model) throws Exception {
        logger.info(String.format("Account:%s Password:%s CheckCode:%s", account, password, checkCode));
        String apiId = String.format("%02d%04d%02d", Defines.MODULE_CORE, ApiDefine.CTL_LOGIN, ApiDefine.FN_LOGIN_LOGIN);
        String userToken = "";
        Long timestamp = System.currentTimeMillis();
        String strTimestamp = timestamp.toString();
        String host = request.getRemoteHost();
        String ip = request.getRemoteAddr();
        Integer port = request.getRemotePort();
        ip = String.format("%s:%d", ip, port);
        password = AESEncryption.encryptString(password, EncryptionMode.AES256_01_HEX_UNICODE);
        Map<String, String> params = new HashMap<>();
        params.put(ApiDefine.FIELD_ACCOUNT, account);
        params.put(ApiDefine.FIELD_PASSWORD, password);
        params.put(ApiDefine.FIELD_HOST, host);
        params.put(ApiDefine.FIELD_IP, ip);
        String requestToken = WebHelper.genRequestToken(apiId, userToken, strTimestamp, params);
        WebReturn webReturn = coreClient.login(requestToken, strTimestamp, account, password, host, ip);
        if (!webReturn.isResult()) {
            logger.error(String.format("Login fail. %d %s", webReturn.getCode(), webReturn.getMsg()));
            model.addAttribute("err", webReturn.getMsg());
            return VIEW_LOGIN;
        }
        logger.info(String.format("Login successful. %s", account));
        return VIEW_LOGIN;
    }

    @RequestMapping(value = "getcheckcode", method = RequestMethod.GET)
    public void getCheckCode(HttpServletResponse response, HttpSession session) {
        response.setContentType("image/jpeg");
        try {
            OutputStream os = response.getOutputStream();
            CheckCodeHelper checkCodeHelper = new CheckCodeHelper();
            //获取生成的验证码，并写入Session中
            String strCode = checkCodeHelper.getCodePic(0, 0, os);
            logger.info(String.format("CheckCode is %s", strCode));
            session.setAttribute("CheckCode", strCode);
            os.flush();
            os.close();
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
    }

}
