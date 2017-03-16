package com.netinfo.emp.core.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Project emp-core
 * Package com.netinfo.emp.core.entity
 * <p>
 * Created by Charley on 2017/3/10.
 */
@Entity
@Table(name = "T_00_012")
@IdClass(value = SIDPK.class)
public class SID {
    @Id
    @Column(name = "C001")
    private int resource;
    @Id
    @Column(name = "C002")
    private int middle;
    @Column(name = "C003")
    private Long current;
    @Column(name = "C004")
    @JsonIgnore
    private Long lastTimeLong;
    @Transient
    private Date lastTime;

    public int getResource() {
        return resource;
    }

    public void setResource(int resource) {
        this.resource = resource;
    }

    public int getMiddle() {
        return middle;
    }

    public void setMiddle(int middle) {
        this.middle = middle;
    }

    public Long getCurrent() {
        return current;
    }

    public void setCurrent(Long current) {
        this.current = current;
    }

    public Long getLastTimeLong() {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        format.setTimeZone(TimeZone.getTimeZone("GMT"));
        return Long.parseLong(format.format(lastTime));
    }

    public void setLastTimeLong(Long lastTimeLong) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        format.setTimeZone(TimeZone.getTimeZone("GMT"));
        this.lastTime = format.parse(lastTimeLong.toString());
    }

    public Date getLastTime() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        format.setTimeZone(TimeZone.getTimeZone("GMT"));
        return format.parse(lastTimeLong.toString());
    }

    public void setLastTime(Date lastTime) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        format.setTimeZone(TimeZone.getTimeZone("GMT"));
        this.lastTimeLong = Long.parseLong(format.format(lastTime));
    }
}
