package com.netinfo.emp.core.db.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Project charley-web-09
 * Package com.netinfo.emp.core.db.entity
 * <p>
 * Created by Charley on 2017/3/22.
 */
public class SequenceGenerateDetailPK implements Serializable {
    private int sequenceId;
    private int intermediateValue;

    @Column(name = "SEQUENCE_ID")
    @Id
    public int getSequenceId() {
        return sequenceId;
    }

    public void setSequenceId(int sequenceId) {
        this.sequenceId = sequenceId;
    }

    @Column(name = "INTERMEDIATE_VALUE")
    @Id
    public int getIntermediateValue() {
        return intermediateValue;
    }

    public void setIntermediateValue(int intermediateValue) {
        this.intermediateValue = intermediateValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SequenceGenerateDetailPK that = (SequenceGenerateDetailPK) o;

        if (sequenceId != that.sequenceId) return false;
        if (intermediateValue != that.intermediateValue) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sequenceId;
        result = 31 * result + intermediateValue;
        return result;
    }
}
