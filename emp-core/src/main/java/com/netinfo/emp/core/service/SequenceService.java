package com.netinfo.emp.core.service;

import com.netinfo.emp.common.WebReturn;
import com.netinfo.emp.core.entity.SeqMethod;
import com.netinfo.emp.core.entity.Sequence;
import com.netinfo.emp.core.feign.CoreDbClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.TimeZone;

/**
 * Project emp-core
 * Package com.netinfo.emp.core.service
 * <p>
 * Created by Charley on 2017/3/23.
 */
@Service
public class SequenceService {
    private static Logger logger = LoggerFactory.getLogger(SequenceService.class);

    @Autowired
    private CoreDbClient coreDbClient;
    @Autowired
    private SeqMethodService seqMethodService;

    public String generate(int sequenceId, String intermediateValue) {
        try {
            if (sequenceId < 100 || sequenceId > 999) {
                logger.error(String.format("SequenceId invalid, must between 100 to 999"));
                return "";
            }
            SeqMethod seqMethod = seqMethodService.querySeqId(sequenceId);
            if (seqMethod == null) {
                logger.error(String.format("SeqMethod is null."));
                return "";
            }
            int method = seqMethod.getMethod();
            int intIntermediateValue;
            LocalDateTime local = LocalDateTime.now();
            ZonedDateTime utc = ZonedDateTime.now(ZoneOffset.UTC);
            DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyMMdd00");
            DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyMMddHH");
            switch (method) {
                case 100:
                    intIntermediateValue = Integer.parseInt("17010100");
                    break;
                case 101:
                    intIntermediateValue = Integer.parseInt(local.format(formatter1));
                    break;
                case 102:
                    intIntermediateValue = Integer.parseInt(local.format(formatter2));
                    break;
                case 201:
                    intIntermediateValue = Integer.parseInt(utc.format(formatter1));
                    break;
                case 202:
                    intIntermediateValue = Integer.parseInt(utc.format(formatter2));
                    break;
                case 301:
                case 302:
                    intIntermediateValue = Integer.parseInt(intermediateValue);
                    break;
                default:
                    logger.error(String.format("Generate method invalid. %d for %d", method, sequenceId));
                    return "";
            }
            WebReturn webReturn = coreDbClient.seqDetailQuerySeqIdAndInterValue(String.format("%d", sequenceId), String.format("%d", intIntermediateValue));
            if (!webReturn.isResult()) {
                logger.error(String.format("Fail. %d %s", webReturn.getCode(), webReturn.getMsg()));
                return "";
            }
            LinkedHashMap<String, Object> data = (LinkedHashMap<String, Object>) webReturn.getData();
            Date now = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
            format.setTimeZone(TimeZone.getTimeZone("GMT"));
            Sequence sequence = new Sequence();
            long currentValue = 1L;
            if (data != null) {
                currentValue = Long.parseLong(data.get("current_value").toString());
                currentValue++;
            }
            sequence.setSequenceId(sequenceId);
            sequence.setIntermediateValue(intIntermediateValue);
            sequence.setCurrentValue(currentValue);
            sequence.setLastAcquisitionTime(now);
            long lastTime = Long.parseLong(format.format(sequence.getLastAcquisitionTime()));
            webReturn = coreDbClient.seqDetailAdd(String.format("%d", sequence.getSequenceId()),
                    String.format("%d", sequence.getIntermediateValue()),
                    String.format("%d", sequence.getCurrentValue()),
                    String.format("%d", lastTime));
            if (!webReturn.isResult()) {
                logger.error(String.format("Fail. %d %s", webReturn.getCode(), webReturn.getMsg()));
                return "";
            }
            String strId = String.format("%03d%08d%08d", sequenceId, intIntermediateValue, currentValue);
            logger.info(String.format("Generate sequence id %s", strId));
            return strId;
        } catch (Exception ex) {
            logger.error(String.format("Fail. %s", ex.getMessage()));
            return "";
        }
    }
}
