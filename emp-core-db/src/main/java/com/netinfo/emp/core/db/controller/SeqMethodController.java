package com.netinfo.emp.core.db.controller;

import com.netinfo.emp.common.WebReturn;
import com.netinfo.emp.core.db.entity.SequenceGenerateMethod;
import com.netinfo.emp.core.db.repository.SequenceGenerateMethodRepository;
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
 * Created by Charley on 2017/3/22.
 */
@RestController
@RequestMapping("/seq_gen_method")
public class SeqMethodController {
    private static Logger logger = LoggerFactory.getLogger(SeqMethodController.class);

    @Autowired
    private SequenceGenerateMethodRepository sequenceGenerateMethodRepository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public WebReturn list() {
        WebReturn webReturn = new WebReturn();
        List<SequenceGenerateMethod> sequenceGenerateMethods = sequenceGenerateMethodRepository.findAll(new Sort(Sort.Direction.ASC, "sequenceId"));
        webReturn.setData(sequenceGenerateMethods);
        return webReturn;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public WebReturn querySequenceId(@PathVariable("id") int sequenceId) {
        logger.info(String.format("SeqId:%s", sequenceId));
        WebReturn webReturn = new WebReturn();
        SequenceGenerateMethod sequenceGenerateMethod = sequenceGenerateMethodRepository.findOne(sequenceId);
        webReturn.setData(sequenceGenerateMethod);
        return webReturn;
    }
}
