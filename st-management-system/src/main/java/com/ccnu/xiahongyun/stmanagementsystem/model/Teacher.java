package com.ccnu.xiahongyun.stmanagementsystem.model;

public class Teacher {
    private Integer id ;
    private String name ;
    private Long starttime;
    private Long endtime ;
    private Boolean isInvigilator;
    private Integer numInvigilator ;
    private Boolean accInvigilator;

    public Teacher(Integer id, String name, Long starttime, Long endtime,
                   Boolean isInvigilator, Integer numInvigilator, Boolean accInvigilator) {
        this.id = id;
        this.name = name;
        this.starttime = starttime;
        this.endtime = endtime;
        this.isInvigilator = isInvigilator;
        this.numInvigilator = numInvigilator;
        this.accInvigilator = accInvigilator;
    }

    public Teacher() {
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

    public Long getStarttime() {
        return starttime;
    }

    public void setStarttime(Long starttime) {
        this.starttime = starttime;
    }

    public Long getEndtime() {
        return endtime;
    }

    public void setEndtime(Long endtime) {
        this.endtime = endtime;
    }

    public Boolean getIsInvigilator() {
        return isInvigilator;
    }

    public void setIsInvigilator(Boolean invigilator) {
        this.isInvigilator = invigilator;
    }

    public Integer getNumInvigilator() {
        return numInvigilator;
    }

    public void setNumInvigilator(Integer numInvigilator) {
        this.numInvigilator = numInvigilator;
    }

    public Boolean getAccInvigilator() {
        return accInvigilator;
    }

    public void setAccInvigilator(Boolean accInvigilator) {
        this.accInvigilator = accInvigilator;
    }

}
