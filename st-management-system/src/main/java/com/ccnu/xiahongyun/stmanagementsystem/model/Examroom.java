package com.ccnu.xiahongyun.stmanagementsystem.model;

public class Examroom {
    Integer id;
    Teacher tea;
    Classroom classroom;

    public Examroom() {
    }

    public Integer getId() {

        return id;
    }

    @Override
    public String toString() {
        return "Examroom{" +
                "id=" + id +
                ", tea=" + tea +
                ", classroom=" + classroom +
                ", number=" + number +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Examroom)) return false;

        Examroom examroom = (Examroom) o;

        if (getId() != null ? !getId().equals(examroom.getId()) : examroom.getId() != null) return false;
        if (getTea() != null ? !getTea().equals(examroom.getTea()) : examroom.getTea() != null) return false;
        if (getClassroom() != null ? !getClassroom().equals(examroom.getClassroom()) : examroom.getClassroom() != null)
            return false;
        return getNumber() != null ? getNumber().equals(examroom.getNumber()) : examroom.getNumber() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getTea() != null ? getTea().hashCode() : 0);
        result = 31 * result + (getClassroom() != null ? getClassroom().hashCode() : 0);
        result = 31 * result + (getNumber() != null ? getNumber().hashCode() : 0);
        return result;
    }

    public void setId(Integer id) {

        this.id = id;
    }

    public Teacher getTea() {
        return tea;
    }

    public void setTea(Teacher tea) {
        this.tea = tea;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Examroom(Integer id, Teacher tea, Classroom classroom, Integer number) {

        this.id = id;
        this.tea = tea;
        this.classroom = classroom;
        this.number = number;
    }

    Integer number;


}
