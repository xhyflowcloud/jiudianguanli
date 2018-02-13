package com.ccnu.xiahongyun.stmanagementsystem.model;

public class Subject {
    Integer id;
    String name;
    String datetime;
    Integer duration;
    Integer number;

    public Subject() {
    }

    public Subject(Integer id, String name, String datetime, Integer duration, Integer number) {
        this.id = id;
        this.name = name;
        this.datetime = datetime;
        this.duration = duration;
        this.number = number;
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

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Subject)) return false;

        Subject subject = (Subject) o;

        if (getId() != null ? !getId().equals(subject.getId()) : subject.getId() != null) return false;
        if (getName() != null ? !getName().equals(subject.getName()) : subject.getName() != null) return false;
        if (getDatetime() != null ? !getDatetime().equals(subject.getDatetime()) : subject.getDatetime() != null)
            return false;
        if (getDuration() != null ? !getDuration().equals(subject.getDuration()) : subject.getDuration() != null)
            return false;
        return getNumber() != null ? getNumber().equals(subject.getNumber()) : subject.getNumber() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getDatetime() != null ? getDatetime().hashCode() : 0);
        result = 31 * result + (getDuration() != null ? getDuration().hashCode() : 0);
        result = 31 * result + (getNumber() != null ? getNumber().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", datetime='" + datetime + '\'' +
                ", duration=" + duration +
                ", number=" + number +
                '}';
    }
}
