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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Teacher)) return false;

        Teacher teacher = (Teacher) o;

        if (getId() != null ? !getId().equals(teacher.getId()) : teacher.getId() != null) return false;
        if (getName() != null ? !getName().equals(teacher.getName()) : teacher.getName() != null) return false;
        if (getStarttime() != null ? !getStarttime().equals(teacher.getStarttime()) : teacher.getStarttime() != null)
            return false;
        if (getEndtime() != null ? !getEndtime().equals(teacher.getEndtime()) : teacher.getEndtime() != null)
            return false;
        if (isInvigilator != null ? !isInvigilator.equals(teacher.isInvigilator) : teacher.isInvigilator != null)
            return false;
        if (getNumInvigilator() != null ? !getNumInvigilator().equals(teacher.getNumInvigilator()) : teacher.getNumInvigilator() != null)
            return false;
        return getAccInvigilator() != null ? getAccInvigilator().equals(teacher.getAccInvigilator()) : teacher.getAccInvigilator() == null;
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

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", starttime=" + starttime +
                ", endtime=" + endtime +
                ", isInvigilator=" + isInvigilator +
                ", numInvigilator=" + numInvigilator +
                ", accInvigilator=" + accInvigilator +
                '}';
    }
}
