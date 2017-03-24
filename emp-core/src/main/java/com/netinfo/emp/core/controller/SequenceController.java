package com.netinfo.emp.core.controller;

import com.netinfo.emp.common.Defines;
import com.netinfo.emp.common.WebReturn;
import com.netinfo.emp.core.common.CoreDefine;
import com.netinfo.emp.core.service.SequenceService;
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
@RequestMapping("/" + CoreDefine.PATH_SEQUENCES)
public class SequenceController {
    private static Logger logger = LoggerFactory.getLogger(SequenceController.class);

    @Autowired
    private SequenceService sequenceService;

    @RequestMapping(value = "/" + CoreDefine.PATH_GEN, method = RequestMethod.GET)
    public WebReturn generate(@RequestParam(value = CoreDefine.FIELD_SEQ_ID) int sequenceId,
                              @RequestParam(value = CoreDefine.FIELD_INTR_VALUE, required = false, defaultValue = "") String intermediateValue) {
        logger.info(String.format("SequenceId:%d IntermediateValue:%s", sequenceId, intermediateValue));
        WebReturn webReturn = new WebReturn();
        String strId = sequenceService.generate(sequenceId, intermediateValue);
        if ("".equals(strId)) {
            webReturn.setResult(false);
            webReturn.setCode(Defines.RET_FAIL);
            webReturn.setMsg(String.format("Fail. Sequence id is empty."));
            return webReturn;
        }
        webReturn.setMsg(strId);
        webReturn.setData(strId);
        return webReturn;
    }
}
