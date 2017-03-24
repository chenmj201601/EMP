package com.netinfo.emp.core.db.entity;

import javax.persistence.*;

/**
 * Project charley-web-09
 * Package com.netinfo.emp.core.db.entity
 * <p>
 * Created by Charley on 2017/3/22.
 */
@Entity
@Table(name = "SEQUENCE_GENERATE_DETAIL")
@IdClass(SequenceGenerateDetailPK.class)
public class SequenceGenerateDetail {
    private int sequenceId;
    private int intermediateValue;
    private long currentValue;
    private Long finalAcquisitionTime;

    @Id
    @Column(name = "SEQUENCE_ID")
    public int getSequenceId() {
        return sequenceId;
    }

    public void setSequenceId(int sequenceId) {
        this.sequenceId = sequenceId;
    }

    @Id
    @Column(name = "INTERMEDIATE_VALUE")
    public int getIntermediateValue() {
        return intermediateValue;
    }

    public void setIntermediateValue(int intermediateValue) {
        this.intermediateValue = intermediateValue;
    }

    @Basic
    @Column(name = "CURRENT_VALUE")
    public long getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(long currentValue) {
        this.currentValue = currentValue;
    }

    @Basic
    @Column(name = "FINAL_ACQUISITION_TIME")
    public Long getFinalAcquisitionTime() {
        return finalAcquisitionTime;
    }

    public void setFinalAcquisitionTime(Long finalAcquisitionTime) {
        this.finalAcquisitionTime = finalAcquisitionTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SequenceGenerateDetail that = (SequenceGenerateDetail) o;

        if (sequenceId != that.sequenceId) return false;
        if (intermediateValue != that.intermediateValue) return false;
        if (currentValue != that.currentValue) return false;
        if (finalAcquisitionTime != null ? !finalAcquisitionTime.equals(that.finalAcquisitionTime) : that.finalAcquisitionTime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sequenceId;
        result = 31 * result + intermediateValue;
        result = 31 * result + (int) (currentValue ^ (currentValue >>> 32));
        result = 31 * result + (finalAcquisitionTime != null ? finalAcquisitionTime.hashCode() : 0);
        return result;
    }
}
