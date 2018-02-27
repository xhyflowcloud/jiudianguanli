package com.ccnu.xiahongyun.stmanagementsystem.query;

public class TeacherQuery {
    Integer id;
    String name;
    Boolean isInvigilator;
    Integer numInvigilator;
    Boolean accInvigilator;
    Integer pageIndex;
    Integer pageSize;
    Integer totalRecord;

    public TeacherQuery(Integer id, String name, Boolean isInvigilator, Integer numInvigilator, Boolean accInvigilator, Integer pageIndex, Integer pageSize, Integer totalRecord) {
        this.id = id;
        this.name = name;
        this.isInvigilator = isInvigilator;
        this.numInvigilator = numInvigilator;
        this.accInvigilator = accInvigilator;
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.totalRecord = totalRecord;
    }

    public TeacherQuery() {
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

    public Boolean getInvigilator() {
        return isInvigilator;
    }

    public void setInvigilator(Boolean invigilator) {
        isInvigilator = invigilator;
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
        if (!(o instanceof TeacherQuery)) return false;

        TeacherQuery that = (TeacherQuery) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null) return false;
        if (isInvigilator != null ? !isInvigilator.equals(that.isInvigilator) : that.isInvigilator != null)
            return false;
        if (getNumInvigilator() != null ? !getNumInvigilator().equals(that.getNumInvigilator()) : that.getNumInvigilator() != null)
            return false;
        if (getAccInvigilator() != null ? !getAccInvigilator().equals(that.getAccInvigilator()) : that.getAccInvigilator() != null)
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
        result = 31 * result + (isInvigilator != null ? isInvigilator.hashCode() : 0);
        result = 31 * result + (getNumInvigilator() != null ? getNumInvigilator().hashCode() : 0);
        result = 31 * result + (getAccInvigilator() != null ? getAccInvigilator().hashCode() : 0);
        result = 31 * result + (getPageIndex() != null ? getPageIndex().hashCode() : 0);
        result = 31 * result + (getPageSize() != null ? getPageSize().hashCode() : 0);
        result = 31 * result + (getTotalRecord() != null ? getTotalRecord().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TeacherQuery{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isInvigilator=" + isInvigilator +
                ", numInvigilator=" + numInvigilator +
                ", accInvigilator=" + accInvigilator +
                ", pageIndex=" + pageIndex +
                ", pageSize=" + pageSize +
                ", totalRecord=" + totalRecord +
                '}';
    }
}
