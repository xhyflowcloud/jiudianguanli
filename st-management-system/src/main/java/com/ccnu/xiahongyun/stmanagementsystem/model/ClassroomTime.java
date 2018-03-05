package com.ccnu.xiahongyun.stmanagementsystem.model;

public class ClassroomTime {
    private Integer id ;
    private Integer size ;
    private String starttime ;
    private String endtime ;
    private String position ;
    private Boolean isEnable ;

    public ClassroomTime() {
    }

    public ClassroomTime(Integer id, Integer size, String starttime, String endtime, String position, Boolean isEnable) {
        this.id = id;
        this.size = size;
        this.starttime = starttime;
        this.endtime = endtime;
        this.position = position;
        this.isEnable = isEnable;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClassroomTime)) return false;

        ClassroomTime classroom = (ClassroomTime) o;

        if (getId() != null ? !getId().equals(classroom.getId()) : classroom.getId() != null) return false;
        if (getSize() != null ? !getSize().equals(classroom.getSize()) : classroom.getSize() != null) return false;
        if (getStarttime() != null ? !getStarttime().equals(classroom.getStarttime()) : classroom.getStarttime() != null)
            return false;
        if (getEndtime() != null ? !getEndtime().equals(classroom.getEndtime()) : classroom.getEndtime() != null)
            return false;
        if (getPosition() != null ? !getPosition().equals(classroom.getPosition()) : classroom.getPosition() != null)
            return false;
        return isEnable != null ? isEnable.equals(classroom.isEnable) : classroom.isEnable == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getSize() != null ? getSize().hashCode() : 0);
        result = 31 * result + (getStarttime() != null ? getStarttime().hashCode() : 0);
        result = 31 * result + (getEndtime() != null ? getEndtime().hashCode() : 0);
        result = 31 * result + (getPosition() != null ? getPosition().hashCode() : 0);
        result = 31 * result + (isEnable != null ? isEnable.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Classroom{" +
                "id=" + id +
                ", size=" + size +
                ", starttime=" + starttime +
                ", endtime=" + endtime +
                ", position='" + position + '\'' +
                ", isEnable=" + isEnable +
                '}';
    }
}
