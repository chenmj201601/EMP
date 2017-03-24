package com.netinfo.emp.core.db.controller;

import com.netinfo.emp.common.WebReturn;
import com.netinfo.emp.core.db.entity.LanguageBody;
import com.netinfo.emp.core.db.repository.LanguageBodyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Project emp-core-db
 * Package com.netinfo.emp.core.db.controller
 * <p>
 * Created by Charley on 2017/3/24.
 */
@RestController
@RequestMapping("/lang_infos")
public class LangInfoController {
    private static Logger logger = LoggerFactory.getLogger(LangInfoController.class);

    @Autowired
    private LanguageBodyRepository languageBodyRepository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public WebReturn list() {
        WebReturn webReturn = new WebReturn();
        List<LanguageBody> langInfos = languageBodyRepository.findAll(new Sort(Sort.Direction.ASC, "languageId", "messageCode"));
        webReturn.setData(langInfos);
        return webReturn;
    }

    @RequestMapping(value = "/lang_id/{lang_id}", method = RequestMethod.GET)
    public WebReturn queryLangId(@PathVariable(value = "lang_id") short langId) {
        logger.info(String.format("LangId:%d", langId));
        WebReturn webReturn = new WebReturn();
        List<LanguageBody> langInfos = languageBodyRepository.findByLanguageId(langId,
                new Sort(Sort.Direction.ASC, "languageId", "messageCode"));
        webReturn.setData(langInfos);
        return webReturn;
    }

    @RequestMapping(value = "/lang_id/{lang_id}/module_number/{module_number}", method = RequestMethod.GET)
    public WebReturn queryLangIdModuleNumber(@PathVariable(value = "lang_id") short langId,
                                             @PathVariable(value = "module_number") short moduleNumber) {
        logger.info(String.format("LangId:%d ModuleNumber:%d", langId, moduleNumber));
        WebReturn webReturn = new WebReturn();
        List<LanguageBody> langInfos = languageBodyRepository.findByLanguageIdAndModuleNumber(langId, moduleNumber,
                new Sort(Sort.Direction.ASC, "languageId", "messageCode"));
        webReturn.setData(langInfos);
        return webReturn;
    }

    @RequestMapping(value = "/lang_id/{lang_id}/page_name/{page_name}", method = RequestMethod.GET)
    public WebReturn queryLangIdInPage(@PathVariable(value = "lang_id") short langId,
                                       @PathVariable(value = "page_name") String pageName) {
        logger.info(String.format("LangId:%d PageName:%s", langId, pageName));
        WebReturn webReturn = new WebReturn();
        List<LanguageBody> langInfos = languageBodyRepository.findByLanguageIdAndInPage(langId, pageName,
                new Sort(Sort.Direction.ASC, "languageId", "messageCode"));
        webReturn.setData(langInfos);
        return webReturn;
    }
}
