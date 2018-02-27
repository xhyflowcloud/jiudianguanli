package com.ccnu.xiahongyun.stmanagementsystem.query;

public class ExamroomQuery {
    Integer id;
    Integer tid;//监考人员
    Integer rid;//教室id
    Integer sid;//考试科目
    Integer number;//人数
    Integer pageIndex;
    Integer pageSize;
    Integer totalRecord;

    public ExamroomQuery(Integer id, Integer tid, Integer rid, Integer sid, Integer number, Integer pageIndex, Integer pageSize, Integer totalRecord) {
        this.id = id;
        this.tid = tid;
        this.rid = rid;
        this.sid = sid;
        this.number = number;
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.totalRecord = totalRecord;
    }

    public ExamroomQuery() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
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
        if (!(o instanceof ExamroomQuery)) return false;

        ExamroomQuery that = (ExamroomQuery) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getTid() != null ? !getTid().equals(that.getTid()) : that.getTid() != null) return false;
        if (getRid() != null ? !getRid().equals(that.getRid()) : that.getRid() != null) return false;
        if (getSid() != null ? !getSid().equals(that.getSid()) : that.getSid() != null) return false;
        if (getNumber() != null ? !getNumber().equals(that.getNumber()) : that.getNumber() != null) return false;
        if (getPageIndex() != null ? !getPageIndex().equals(that.getPageIndex()) : that.getPageIndex() != null)
            return false;
        if (getPageSize() != null ? !getPageSize().equals(that.getPageSize()) : that.getPageSize() != null)
            return false;
        return getTotalRecord() != null ? getTotalRecord().equals(that.getTotalRecord()) : that.getTotalRecord() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getTid() != null ? getTid().hashCode() : 0);
        result = 31 * result + (getRid() != null ? getRid().hashCode() : 0);
        result = 31 * result + (getSid() != null ? getSid().hashCode() : 0);
        result = 31 * result + (getNumber() != null ? getNumber().hashCode() : 0);
        result = 31 * result + (getPageIndex() != null ? getPageIndex().hashCode() : 0);
        result = 31 * result + (getPageSize() != null ? getPageSize().hashCode() : 0);
        result = 31 * result + (getTotalRecord() != null ? getTotalRecord().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ExamroomQuery{" +
                "id=" + id +
                ", tid=" + tid +
                ", rid=" + rid +
                ", sid=" + sid +
                ", number=" + number +
                ", pageIndex=" + pageIndex +
                ", pageSize=" + pageSize +
                ", totalRecord=" + totalRecord +
                '}';
    }
}
