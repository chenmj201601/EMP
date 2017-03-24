package com.netinfo.emp.core.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.TimeZone;

/**
 * Project emp-core
 * Package com.netinfo.emp.core.entity
 * <p>
 * Created by Charley on 2017/3/23.
 */
public class Sequence {
    private int sequenceId;
    private int intermediateValue;
    private long currentValue;
    private Date lastAcquisitionTime;

    public int getSequenceId() {
        return sequenceId;
    }

    public void setSequenceId(int sequenceId) {
        this.sequenceId = sequenceId;
    }

    public int getIntermediateValue() {
        return intermediateValue;
    }

    public void setIntermediateValue(int intermediateValue) {
        this.intermediateValue = intermediateValue;
    }

    public long getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(long currentValue) {
        this.currentValue = currentValue;
    }

    public Date getLastAcquisitionTime() {
        return lastAcquisitionTime;
    }

    public void setLastAcquisitionTime(Date lastAcquisitionTime) {
        this.lastAcquisitionTime = lastAcquisitionTime;
    }

    public static Sequence fromT(Map<String, Object> map) throws ParseException {
        Sequence sequence = new Sequence();
        sequence.setSequenceId((int) map.get("sequence_id"));
        sequence.setIntermediateValue((int) map.get("intermediate_value"));
        sequence.setCurrentValue((long) map.get("current_value"));
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        format.setTimeZone(TimeZone.getTimeZone("GMT"));
        if (map.get("last_acquisition_time") != null) {
            sequence.setLastAcquisitionTime(format.parse(String.format("%d", map.get("last_acquisition_time"))));
        }
        return sequence;
    }
}
