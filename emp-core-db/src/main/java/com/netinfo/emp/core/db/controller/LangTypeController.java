package com.netinfo.emp.core.db.controller;

import com.netinfo.emp.common.WebReturn;
import com.netinfo.emp.core.db.entity.SupportLanguage;
import com.netinfo.emp.core.db.repository.SupportLanguageRepository;
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
@RequestMapping("/lang_types")
public class LangTypeController {
    private static Logger logger = LoggerFactory.getLogger(LangTypeController.class);

    @Autowired
    private SupportLanguageRepository supportLanguageRepository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public WebReturn list() {
        WebReturn webReturn = new WebReturn();
        List<SupportLanguage> langTypes = supportLanguageRepository.findAll(new Sort(Sort.Direction.ASC, "languageId"));
        webReturn.setData(langTypes);
        return webReturn;
    }

    @RequestMapping(value = "/lang_id/{lang_id}", method = RequestMethod.GET)
    public WebReturn queryLangId(@PathVariable("lang_id") int langId) {
        logger.info(String.format("LangId:%d", langId));
        WebReturn webReturn = new WebReturn();
        SupportLanguage langType = supportLanguageRepository.findOne(langId);
        webReturn.setData(langType);
        return webReturn;
    }
}
