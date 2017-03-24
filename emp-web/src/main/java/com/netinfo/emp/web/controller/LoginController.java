package com.netinfo.emp.web.controller;

import com.netinfo.emp.common.EncryptionMode;
import com.netinfo.emp.common.WebReturn;
import com.netinfo.emp.core.common.CoreDefine;
import com.netinfo.emp.encryptions.AESEncryption;
import com.netinfo.emp.utils.WebHelper;
import com.netinfo.emp.web.WebDefine;
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
@RequestMapping("/" + WebDefine.PATH_LOGIN)
public class LoginController {
    private static final String VIEW_LOGIN = "login";
    private static final String VIEW_INDEX = "index";
    private static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private LangService langService;

    @Autowired
    private CoreClient coreClient;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String login(@RequestParam(value = WebDefine.FIELD_LANG_ID, required = false, defaultValue = "") String langId,
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

    @RequestMapping(value = "/" + WebDefine.PATH_DO_LOGIN, method = RequestMethod.POST)
    public String doLogin(@RequestParam(WebDefine.FIELD_ACCOUNT) String account,
                          @RequestParam(WebDefine.FIELD_PASSWORD) String password,
                          @RequestParam(WebDefine.FIELD_CHECK_CODE) String checkCode,
                          HttpServletRequest request,
                          Model model) throws Exception {
        logger.info(String.format("Account:%s Password:%s CheckCode:%s", account, password, checkCode));
        Map<String, String> langs = langService.getLangs(request);
        if (langs == null) {
            model.addAttribute(WebDefine.FIELD_ERROR, String.format("Langs is null"));
            return VIEW_LOGIN;
        }
        if (request.getSession().getAttribute(WebDefine.FIELD_CHECK_CODE) == null) {
            model.addAttribute(WebDefine.FIELD_ERROR, String.format("Check code is null"));
            return VIEW_LOGIN;
        }
        String _checkCode = request.getSession().getAttribute(WebDefine.FIELD_CHECK_CODE).toString();
        if (!_checkCode.equals(checkCode)) {
            model.addAttribute(WebDefine.FIELD_ERROR,
                    langs.get(WebDefine.LANG_NAME_CHECK_CODE_ERROR) != null ?
                            langs.get(WebDefine.LANG_NAME_CHECK_CODE_ERROR) :
                            String.format("Check code error"));
            return VIEW_LOGIN;
        }
        String apiId = String.format("/%s", CoreDefine.PATH_LOGINS);
        String userToken = "";
        Long timestamp = System.currentTimeMillis();
        String strTimestamp = timestamp.toString();
        String host = request.getRemoteHost();
        String ip = request.getRemoteAddr();
        Integer port = request.getRemotePort();
        ip = String.format("%s:%d", ip, port);
        password = AESEncryption.encryptString(password, EncryptionMode.AES256_01_HEX_UNICODE);
        Map<String, String> params = new HashMap<>();
        params.put(CoreDefine.FIELD_ACCOUNT, account);
        params.put(CoreDefine.FIELD_PASSWORD, password);
        params.put(CoreDefine.FIELD_HOST, host);
        params.put(CoreDefine.FIELD_IP, ip);
        String requestToken = WebHelper.genRequestToken(apiId, userToken, strTimestamp, params);
        WebReturn webReturn = coreClient.login(requestToken, strTimestamp, account, password, host, ip);
        if (!webReturn.isResult()) {
            logger.error(String.format("Login fail. %d %s", webReturn.getCode(), webReturn.getMsg()));
            switch (webReturn.getCode()) {
                case CoreDefine.RET_USER_NOT_EXIST:
                    model.addAttribute(WebDefine.FIELD_ERROR,
                            langs.get(WebDefine.LANG_NAME_USER_NOT_EXIST) != null ?
                                    langs.get(WebDefine.LANG_NAME_USER_NOT_EXIST) :
                                    String.format("User not exist!"));
                    break;
                case CoreDefine.RET_PASSWORD_ERROR:
                    model.addAttribute(WebDefine.FIELD_ERROR,
                            langs.get(WebDefine.LANG_NAME_PASSWORD_ERROR) != null ?
                                    langs.get(WebDefine.LANG_NAME_PASSWORD_ERROR) :
                                    String.format("Password error!"));
                    break;
                case CoreDefine.RET_ALREADY_LOGINED:
                    model.addAttribute(WebDefine.FIELD_ERROR,
                            langs.get(WebDefine.LANG_NAME_ALREADY_LOGGINED) != null ?
                                    langs.get(WebDefine.LANG_NAME_ALREADY_LOGGINED) :
                                    String.format("Account already logined!"));
                    break;
                default:
                    model.addAttribute(WebDefine.FIELD_ERROR, webReturn.getMsg());
                    break;
            }
            return VIEW_LOGIN;
        }
        logger.info(String.format("Login successful. %s", account));
        model.addAttribute(WebDefine.FIELD_ACCOUNT, account);
        return VIEW_INDEX;
    }

    @RequestMapping(value = "/" + WebDefine.PATH_GET_CHECK_CODE, method = RequestMethod.GET)
    public void getCheckCode(HttpServletResponse response, HttpSession session) {
        response.setContentType("image/jpeg");
        try {
            OutputStream os = response.getOutputStream();
            CheckCodeHelper checkCodeHelper = new CheckCodeHelper();
            //获取生成的验证码，并写入Session中
            String strCode = checkCodeHelper.getCodePic(0, 0, os);
            logger.info(String.format("CheckCode is %s", strCode));
            session.setAttribute(WebDefine.FIELD_CHECK_CODE, strCode);
            os.flush();
            os.close();
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
    }

}
