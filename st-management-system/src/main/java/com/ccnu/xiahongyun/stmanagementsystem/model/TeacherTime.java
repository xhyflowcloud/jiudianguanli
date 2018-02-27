package com.ccnu.xiahongyun.stmanagementsystem.model;

public class TeacherTime {
    private Integer id ;
    private String name ;
    private String starttime;
    private String endtime ;
    private Boolean isInvigilator;
    private Integer numInvigilator ;
    private Boolean accInvigilator;

    public TeacherTime() {
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

    @Override
    public String toString() {
        return "TeacherTime{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", starttime='" + starttime + '\'' +
                ", endtime='" + endtime + '\'' +
                ", isInvigilator=" + isInvigilator +
                ", numInvigilator=" + numInvigilator +
                ", accInvigilator=" + accInvigilator +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TeacherTime)) return false;

        TeacherTime that = (TeacherTime) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null) return false;
        if (getStarttime() != null ? !getStarttime().equals(that.getStarttime()) : that.getStarttime() != null)
            return false;
        if (getEndtime() != null ? !getEndtime().equals(that.getEndtime()) : that.getEndtime() != null) return false;
        if (isInvigilator != null ? !isInvigilator.equals(that.isInvigilator) : that.isInvigilator != null)
            return false;
        if (getNumInvigilator() != null ? !getNumInvigilator().equals(that.getNumInvigilator()) : that.getNumInvigilator() != null)
            return false;
        return getAccInvigilator() != null ? getAccInvigilator().equals(that.getAccInvigilator()) : that.getAccInvigilator() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getStarttime() != null ? getStarttime().hashCode() : 0);
        result = 31 * result + (getEndtime() != null ? getEndtime().hashCode() : 0);
        result = 31 * result + (isInvigilator != null ? isInvigilator.hashCode() : 0);
        result = 31 * result + (getNumInvigilator() != null ? getNumInvigilator().hashCode() : 0);
        result = 31 * result + (getAccInvigilator() != null ? getAccInvigilator().hashCode() : 0);
        return result;
    }
}
