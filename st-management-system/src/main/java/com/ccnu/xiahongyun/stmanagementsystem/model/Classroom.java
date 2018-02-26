package com.ccnu.xiahongyun.stmanagementsystem.model;

public class Classroom {
    Integer id;
    Integer size;
    String position;
    Boolean isEnable;


    public Classroom(Integer id, Integer size, String position, Boolean isEnable) {
        this.id = id;
        this.size = size;

        this.position = position;
        this.isEnable = isEnable;
    }

    public Classroom() {
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Boolean getEnable() {
        return isEnable;
    }

    public void setEnable(Boolean enable) {
        isEnable = enable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Classroom)) return false;

        Classroom classroom = (Classroom) o;

        if (getId() != null ? !getId().equals(classroom.getId()) : classroom.getId() != null) return false;
        if (getSize() != null ? !getSize().equals(classroom.getSize()) : classroom.getSize() != null) return false;
        if (getPosition() != null ? !getPosition().equals(classroom.getPosition()) : classroom.getPosition() != null)
            return false;
        return isEnable != null ? isEnable.equals(classroom.isEnable) : classroom.isEnable == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getSize() != null ? getSize().hashCode() : 0);
        result = 31 * result + (getPosition() != null ? getPosition().hashCode() : 0);
        result = 31 * result + (isEnable != null ? isEnable.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Classroom{" +
                "id=" + id +
                ", size=" + size +
                ", position='" + position + '\'' +
                ", isEnable=" + isEnable +
                '}';
    }
}
