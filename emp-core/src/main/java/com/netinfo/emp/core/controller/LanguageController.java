package com.netinfo.emp.core.controller;

import com.netinfo.emp.common.WebReturn;
import com.netinfo.emp.core.common.CoreDefine;
import com.netinfo.emp.core.service.LanguageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Project emp-core
 * Package com.netinfo.emp.core.controller
 * <p>
 * Created by Charley on 2017/3/24.
 */
@RestController
@RequestMapping("/" + CoreDefine.PATH_LANGUAGES)
public class LanguageController {
    private static Logger logger = LoggerFactory.getLogger(LanguageController.class);

    @Autowired
    private LanguageService languageService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public WebReturn query(@RequestParam(value = "lang_id") short langId,
                           @RequestParam(value = "module_number", required = false, defaultValue = "-1") short moduleNumber,
                           @RequestParam(value = "page_name", required = false, defaultValue = "") String pageName) {
        logger.info(String.format("LangId:%d ModuleNumber:%d PageName:%s", langId, moduleNumber, pageName));
        WebReturn webReturn = new WebReturn();
        if (moduleNumber == -1
                && "".equals(pageName)) {
            webReturn = languageService.query(langId);
        } else if ("".equals(pageName)) {
            webReturn = languageService.query(langId, moduleNumber);
        } else if (moduleNumber == -1) {
            webReturn = languageService.query(langId, pageName);
        }
        return webReturn;
    }
}
