package com.ccnu.xiahongyun.stmanagementsystem.query;

public class SubjectQuery {


    private  Integer id ;
    private String name ;
    private Long starttime ;
    private Long endtime ;
    private Long bmstarttime;
    private Long bmendtime ;
    private Integer maxnumber;
    private Integer minnumber ;


    Integer pageIndex;
    Integer pageSize;
    Integer totalRecord;

    public SubjectQuery() {
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

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(Integer totalRecord) {
        this.totalRecord = totalRecord;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SubjectQuery)) return false;

        SubjectQuery that = (SubjectQuery) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null) return false;
        if (getStarttime() != null ? !getStarttime().equals(that.getStarttime()) : that.getStarttime() != null)
            return false;
        if (getEndtime() != null ? !getEndtime().equals(that.getEndtime()) : that.getEndtime() != null) return false;
        if (getBmstarttime() != null ? !getBmstarttime().equals(that.getBmstarttime()) : that.getBmstarttime() != null)
            return false;
        if (getBmendtime() != null ? !getBmendtime().equals(that.getBmendtime()) : that.getBmendtime() != null)
            return false;
        if (getMaxnumber() != null ? !getMaxnumber().equals(that.getMaxnumber()) : that.getMaxnumber() != null)
            return false;
        if (getMinnumber() != null ? !getMinnumber().equals(that.getMinnumber()) : that.getMinnumber() != null)
            return false;
        if (getPageIndex() != null ? !getPageIndex().equals(that.getPageIndex()) : that.getPageIndex() != null)
            return false;
        if (getPageSize() != null ? !getPageSize().equals(that.getPageSize()) : that.getPageSize() != null)
            return false;
        return getTotalRecord() != null ? getTotalRecord().equals(that.getTotalRecord()) : that.getTotalRecord() == null;
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
        result = 31 * result + (getPageIndex() != null ? getPageIndex().hashCode() : 0);
        result = 31 * result + (getPageSize() != null ? getPageSize().hashCode() : 0);
        result = 31 * result + (getTotalRecord() != null ? getTotalRecord().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SubjectQuery{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", starttime=" + starttime +
                ", endtime=" + endtime +
                ", bmstarttime=" + bmstarttime +
                ", bmendtime=" + bmendtime +
                ", maxnumber=" + maxnumber +
                ", minnumber=" + minnumber +
                ", pageIndex=" + pageIndex +
                ", pageSize=" + pageSize +
                ", totalRecord=" + totalRecord +
                '}';
    }
}
