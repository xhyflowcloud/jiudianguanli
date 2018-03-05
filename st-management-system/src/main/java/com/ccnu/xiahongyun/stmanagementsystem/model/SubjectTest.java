package com.ccnu.xiahongyun.stmanagementsystem.model;

import java.util.Date;

public class SubjectTest {
    private  Integer id ;
    private String name ;
    private Date starttime ;
    private Date endtime ;
    private Date bmstarttime;
    private Date bmendtime ;
    private Integer maxnumber;
    private Integer minnumber ;

    public SubjectTest() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Date getBmstarttime() {
        return bmstarttime;
    }

    public void setBmstarttime(Date bmstarttime) {
        this.bmstarttime = bmstarttime;
    }

    public Date getBmendtime() {
        return bmendtime;
    }

    public void setBmendtime(Date bmendtime) {
        this.bmendtime = bmendtime;
    }

    public Integer getMaxnumber() {
        return maxnumber;
    }

    public void setMaxnumber(Integer maxnumber) {
        this.maxnumber = maxnumber;
    }

    public Integer getMinnumber() {
        return minnumber;
    }

    public void setMinnumber(Integer minnumber) {
        this.minnumber = minnumber;
    }
}
