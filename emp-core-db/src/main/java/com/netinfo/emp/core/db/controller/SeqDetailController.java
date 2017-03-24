package com.netinfo.emp.core.db.controller;

import com.netinfo.emp.common.Defines;
import com.netinfo.emp.common.WebReturn;
import com.netinfo.emp.core.db.entity.SequenceGenerateDetail;
import com.netinfo.emp.core.db.repository.SequenceGenerateDetailRepository;
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
 * Created by Charley on 2017/3/22.
 */
@RestController
@RequestMapping("/seq_gen_detail")
public class SeqDetailController {
    private static Logger logger = LoggerFactory.getLogger(SeqDetailController.class);

    @Autowired
    private SequenceGenerateDetailRepository sequenceGenerateDetailRepository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public WebReturn list() {
        WebReturn webReturn = new WebReturn();
        List<SequenceGenerateDetail> sequenceGenerateDetails = sequenceGenerateDetailRepository.findAll(new Sort(Sort.Direction.ASC, "sequenceId", "IntermediateValue"));
        webReturn.setData(sequenceGenerateDetails);
        return webReturn;
    }

    @RequestMapping(value = "/{sequence_id}/{intermediate_value}", method = RequestMethod.GET)
    public WebReturn withSequenceIdAndIntermediateValue(@PathVariable("sequence_id") int sequenceId,
                                                        @PathVariable("intermediate_value") int intermediateValue) {
        logger.info(String.format("SeqId:%s InterValue:%s", sequenceId, intermediateValue));
        WebReturn webReturn = new WebReturn();
        SequenceGenerateDetail sequenceGenerateDetail = sequenceGenerateDetailRepository.findOneBySequenceIdAndIntermediateValue(sequenceId, intermediateValue);
        webReturn.setData(sequenceGenerateDetail);
        return webReturn;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public WebReturn add(@RequestParam("sequence_id") int sequenceId,
                         @RequestParam("intermediate_value") int intermediateValue,
                         @RequestParam("current_value") long currentValue,
                         @RequestParam(value = "final_acquisition_time", required = false, defaultValue = "0") long finalAcquisitionTime) {
        logger.info(String.format("SeqId:%s InterValue:%s CurrentValue:%s FinalTime:%s", sequenceId, intermediateValue, currentValue, finalAcquisitionTime));
        WebReturn webReturn = new WebReturn();
        try {
            SequenceGenerateDetail sequenceGenerateDetail = new SequenceGenerateDetail();
            sequenceGenerateDetail.setSequenceId(sequenceId);
            sequenceGenerateDetail.setIntermediateValue(intermediateValue);
            sequenceGenerateDetail.setCurrentValue(currentValue);
            sequenceGenerateDetail.setFinalAcquisitionTime(finalAcquisitionTime);
            sequenceGenerateDetailRepository.save(sequenceGenerateDetail);
            webReturn.setData(sequenceGenerateDetail);
        } catch (Exception ex) {
            webReturn.setResult(false);
            webReturn.setCode(Defines.RET_FAIL);
            webReturn.setMsg(String.format("Fail. %s", ex.getMessage()));
            ex.printStackTrace();
        }
        return webReturn;
    }
}
