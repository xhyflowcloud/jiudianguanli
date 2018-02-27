package com.ccnu.xiahongyun.stmanagementsystem.query;

public class StudentQuery {

    String name;

    /**
     * 身份证号
     */
    String id;

    /**
     * 报名ID
     */
    Integer sid;

    Integer pageIndex;
    Integer pageSize;
    Integer totalRecord;


    public StudentQuery() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
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
    public String toString() {
        return "StudentQuery{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", sid=" + sid +
                ", pageIndex=" + pageIndex +
                ", pageSize=" + pageSize +
                ", totalRecord=" + totalRecord +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentQuery)) return false;

        StudentQuery that = (StudentQuery) o;

        if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null) return false;
        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getSid() != null ? !getSid().equals(that.getSid()) : that.getSid() != null) return false;
        if (getPageIndex() != null ? !getPageIndex().equals(that.getPageIndex()) : that.getPageIndex() != null)
            return false;
        if (getPageSize() != null ? !getPageSize().equals(that.getPageSize()) : that.getPageSize() != null)
            return false;
        return getTotalRecord() != null ? getTotalRecord().equals(that.getTotalRecord()) : that.getTotalRecord() == null;
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getId() != null ? getId().hashCode() : 0);
        result = 31 * result + (getSid() != null ? getSid().hashCode() : 0);
        result = 31 * result + (getPageIndex() != null ? getPageIndex().hashCode() : 0);
        result = 31 * result + (getPageSize() != null ? getPageSize().hashCode() : 0);
        result = 31 * result + (getTotalRecord() != null ? getTotalRecord().hashCode() : 0);
        return result;
    }
}
