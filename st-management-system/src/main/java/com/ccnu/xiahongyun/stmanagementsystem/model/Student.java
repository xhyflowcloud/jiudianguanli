package com.ccnu.xiahongyun.stmanagementsystem.model;

public class Student {
    private String name ;
    private  String id ;
    private Integer sid ;

    public Student() {
    }

    public Student(String name, String id, Integer sid) {

        this.name = name;
        this.id = id;
        this.sid = sid;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", sid=" + sid +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;

        Student student = (Student) o;

        if (getName() != null ? !getName().equals(student.getName()) : student.getName() != null) return false;
        if (getId() != null ? !getId().equals(student.getId()) : student.getId() != null) return false;
        return getSid() != null ? getSid().equals(student.getSid()) : student.getSid() == null;
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getId() != null ? getId().hashCode() : 0);
        result = 31 * result + (getSid() != null ? getSid().hashCode() : 0);
        return result;
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
}
