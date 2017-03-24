package com.netinfo.emp.core.service;

import com.netinfo.emp.common.WebReturn;
import com.netinfo.emp.core.entity.SeqMethod;
import com.netinfo.emp.core.feign.CoreDbClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

/**
 * Project emp-core
 * Package com.netinfo.emp.core.service
 * <p>
 * Created by Charley on 2017/3/23.
 */
@Service
public class SeqMethodService {
    private static Logger logger = LoggerFactory.getLogger(SeqMethodService.class);

    @Autowired
    private CoreDbClient coreDbClient;

    public SeqMethod querySeqId(int seqId) {
        WebReturn webReturn = coreDbClient.seqMethodQuerySeqId(String.format("%d", seqId));
        if (!webReturn.isResult()) {
            logger.error(String.format("Fail. %d %s", webReturn.getCode(), webReturn.getMsg()));
            return null;
        }
        LinkedHashMap<String, Object> data = (LinkedHashMap<String, Object>) webReturn.getData();
        if (data == null) {
            logger.error(String.format("WebReturn data is null"));
            return null;
        }
        SeqMethod seqMethod = SeqMethod.fromT(data);
        return seqMethod;
    }
}
