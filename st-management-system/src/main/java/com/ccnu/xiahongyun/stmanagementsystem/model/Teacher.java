package com.ccnu.xiahongyun.stmanagementsystem.model;

import java.util.Arrays;

public class Teacher {
    Integer id;
    String name;
    String[] experience;

    public Teacher() {
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", experience=" + Arrays.toString(experience) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Teacher)) return false;

        Teacher teacher = (Teacher) o;

        if (getId() != null ? !getId().equals(teacher.getId()) : teacher.getId() != null) return false;
        if (getName() != null ? !getName().equals(teacher.getName()) : teacher.getName() != null) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(getExperience(), teacher.getExperience());
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + Arrays.hashCode(getExperience());
        return result;
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

    public String[] getExperience() {
        return experience;
    }

    public void setExperience(String[] experience) {
        this.experience = experience;
    }

    public Teacher(Integer id, String name, String[] experience) {

        this.id = id;
        this.name = name;
        this.experience = experience;
    }
}
