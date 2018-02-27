package com.ccnu.xiahongyun.stmanagementsystem.model;

public class Subject {
    private  Integer id ;
    private String name ;
    private Long starttime ;
    private Long endtime ;
    private Long bmstarttime;
    private Long bmendtime ;
    private Integer maxnumber;
    private Integer minnumber ;

    public Subject() {
    }

    public Subject(Integer id, String name, Long starttime,
                   Long endtime, Long bmstarttime, Long bmendtime, Integer maxnumber,
                   Integer minnumber) {
        this.id = id;
        this.name = name;
        this.starttime = starttime;
        this.endtime = endtime;
        this.bmstarttime = bmstarttime;
        this.bmendtime = bmendtime;
        this.maxnumber = maxnumber;
        this.minnumber = minnumber;
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

    public Long getBmstarttime() {
        return bmstarttime;
    }

    public void setBmstarttime(Long bmstarttime) {
        this.bmstarttime = bmstarttime;
    }

    public Long getBmendtime() {
        return bmendtime;
    }

    public void setBmendtime(Long bmendtime) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Subject)) return false;

        Subject subject = (Subject) o;

        if (getId() != null ? !getId().equals(subject.getId()) : subject.getId() != null) return false;
        if (getName() != null ? !getName().equals(subject.getName()) : subject.getName() != null) return false;
        if (getStarttime() != null ? !getStarttime().equals(subject.getStarttime()) : subject.getStarttime() != null)
            return false;
        if (getEndtime() != null ? !getEndtime().equals(subject.getEndtime()) : subject.getEndtime() != null)
            return false;
        if (getBmstarttime() != null ? !getBmstarttime().equals(subject.getBmstarttime()) : subject.getBmstarttime() != null)
            return false;
        if (getBmendtime() != null ? !getBmendtime().equals(subject.getBmendtime()) : subject.getBmendtime() != null)
            return false;
        if (getMaxnumber() != null ? !getMaxnumber().equals(subject.getMaxnumber()) : subject.getMaxnumber() != null)
            return false;
        return getMinnumber() != null ? getMinnumber().equals(subject.getMinnumber()) : subject.getMinnumber() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getStarttime() != null ? getStarttime().hashCode() : 0);
        result = 31 * result + (getEndtime() != null ? getEndtime().hashCode() : 0);
        result = 31 * result + (getBmstarttime() != null ? getBmstarttime().hashCode() : 0);
        result = 31 * result + (getBmendtime() != null ? getBmendtime().hashCode() : 0);
        result = 31 * result + (getMaxnumber() != null ? getMaxnumber().hashCode() : 0);
        result = 31 * result + (getMinnumber() != null ? getMinnumber().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", starttime=" + starttime +
                ", endtime=" + endtime +
                ", bmstarttime=" + bmstarttime +
                ", bmendtime=" + bmendtime +
                ", maxnumber=" + maxnumber +
                ", minnumber=" + minnumber +
                '}';
    }
}
