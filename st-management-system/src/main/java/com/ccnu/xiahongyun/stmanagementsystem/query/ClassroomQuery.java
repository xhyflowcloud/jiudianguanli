package com.ccnu.xiahongyun.stmanagementsystem.query;

public class ClassroomQuery {

    private Integer id ;
    private Integer size ;
    private Long starttime ;
    private Long endtime ;
    private String position ;
    private Boolean isEnable ;

    private Integer pageIndex;
    private Integer pageSize;
    private Integer totalRecord;

    public ClassroomQuery(Integer id, Integer size,
                          Long starttime, Long endtime,
                          String position, Boolean isEnable,
                          Integer pageIndex, Integer pageSize,
                          Integer totalRecord) {
        this.id = id;
        this.size = size;
        this.starttime = starttime;
        this.endtime = endtime;
        this.position = position;
        this.isEnable = isEnable;
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.totalRecord = totalRecord;
    }

    public ClassroomQuery() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Boolean getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Boolean enable) {
        this.isEnable = enable;
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
        if (!(o instanceof ClassroomQuery)) return false;

        ClassroomQuery that = (ClassroomQuery) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getSize() != null ? !getSize().equals(that.getSize()) : that.getSize() != null) return false;
        if (getStarttime() != null ? !getStarttime().equals(that.getStarttime()) : that.getStarttime() != null)
            return false;
        if (getEndtime() != null ? !getEndtime().equals(that.getEndtime()) : that.getEndtime() != null) return false;
        if (getPosition() != null ? !getPosition().equals(that.getPosition()) : that.getPosition() != null)
            return false;
        if (isEnable != null ? !isEnable.equals(that.isEnable) : that.isEnable != null) return false;
        if (getPageIndex() != null ? !getPageIndex().equals(that.getPageIndex()) : that.getPageIndex() != null)
            return false;
        if (getPageSize() != null ? !getPageSize().equals(that.getPageSize()) : that.getPageSize() != null)
            return false;
        return getTotalRecord() != null ? getTotalRecord().equals(that.getTotalRecord()) : that.getTotalRecord() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getSize() != null ? getSize().hashCode() : 0);
        result = 31 * result + (getStarttime() != null ? getStarttime().hashCode() : 0);
        result = 31 * result + (getEndtime() != null ? getEndtime().hashCode() : 0);
        result = 31 * result + (getPosition() != null ? getPosition().hashCode() : 0);
        result = 31 * result + (isEnable != null ? isEnable.hashCode() : 0);
        result = 31 * result + (getPageIndex() != null ? getPageIndex().hashCode() : 0);
        result = 31 * result + (getPageSize() != null ? getPageSize().hashCode() : 0);
        result = 31 * result + (getTotalRecord() != null ? getTotalRecord().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ClassroomQuery{" +
                "id=" + id +
                ", size=" + size +
                ", starttime=" + starttime +
                ", endtime=" + endtime +
                ", position='" + position + '\'' +
                ", isEnable=" + isEnable +
                ", pageIndex=" + pageIndex +
                ", pageSize=" + pageSize +
                ", totalRecord=" + totalRecord +
                '}';
    }
}
