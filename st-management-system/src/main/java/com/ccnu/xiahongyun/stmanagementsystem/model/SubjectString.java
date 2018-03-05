package com.ccnu.xiahongyun.stmanagementsystem.model;

import java.util.Date;

public class SubjectString {
    private  Integer id ;
    private String name ;
    private String starttime ;
    private String endtime ;
    private String bmstarttime;
    private String bmendtime ;
    private Integer maxnumber;
    private Integer minnumber ;

    public SubjectString() {
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

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getBmstarttime() {
        return bmstarttime;
    }

    public void setBmstarttime(String bmstarttime) {
        this.bmstarttime = bmstarttime;
    }

    public String getBmendtime() {
        return bmendtime;
    }

    public void setBmendtime(String bmendtime) {
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
