package com.netinfo.emp.core.db.entity;

import javax.persistence.*;

/**
 * Project charley-web-09
 * Package com.netinfo.emp.core.db.entity
 * <p>
 * Created by Charley on 2017/3/22.
 */
@Entity
@Table(name = "SEQUENCE_GENERATE_METHOD")
public class SequenceGenerateMethod {
    private int sequenceId;
    private short generateMethod;
    private String sequenceRemark;

    @Id
    @Column(name = "SEQUENCE_ID")
    public int getSequenceId() {
        return sequenceId;
    }

    public void setSequenceId(int sequenceId) {
        this.sequenceId = sequenceId;
    }

    @Basic
    @Column(name = "GENERATE_METHOD")
    public short getGenerateMethod() {
        return generateMethod;
    }

    public void setGenerateMethod(short generateMethod) {
        this.generateMethod = generateMethod;
    }

    @Basic
    @Column(name = "SEQUENCE_REMARK")
    public String getSequenceRemark() {
        return sequenceRemark;
    }

    public void setSequenceRemark(String sequenceRemark) {
        this.sequenceRemark = sequenceRemark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SequenceGenerateMethod that = (SequenceGenerateMethod) o;

        if (sequenceId != that.sequenceId) return false;
        if (generateMethod != that.generateMethod) return false;
        if (sequenceRemark != null ? !sequenceRemark.equals(that.sequenceRemark) : that.sequenceRemark != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sequenceId;
        result = 31 * result + (int) generateMethod;
        result = 31 * result + (sequenceRemark != null ? sequenceRemark.hashCode() : 0);
        return result;
    }
}
