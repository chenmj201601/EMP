package com.netinfo.emp.core.entity;

import java.util.Map;

/**
 * Project emp-core
 * Package com.netinfo.emp.core.entity
 * <p>
 * Created by Charley on 2017/3/23.
 */
public class SeqMethod {
    private int sequenceId;
    private int method;
    private String description;

    public int getSequenceId() {
        return sequenceId;
    }

    public void setSequenceId(int sequenceId) {
        this.sequenceId = sequenceId;
    }

    public int getMethod() {
        return method;
    }

    public void setMethod(int method) {
        this.method = method;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static SeqMethod fromT(Map<String, Object> map) {
        SeqMethod seqMethod = new SeqMethod();
        seqMethod.setSequenceId((int) map.get("sequence_id"));
        seqMethod.setMethod((int) map.get("generate_method"));
        seqMethod.setDescription(map.get("sequence_remark") == null ? "" : map.get("sequence_remark").toString());
        return seqMethod;
    }
}
