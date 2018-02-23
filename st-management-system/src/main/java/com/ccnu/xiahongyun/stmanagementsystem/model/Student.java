package com.ccnu.xiahongyun.stmanagementsystem.model;

public class Student {

    Integer examid;
    String name;

    /**
     * 身份证号
     */
    String id;

    /**
     * 报名ID
     */
    Integer sid;
    public Student(){

    }
    public Student(Integer examid, String name, String id, Integer sid) {
        this.examid = examid;
        this.name = name;
        this.id = id;
        this.sid = sid;
    }

    public Integer getExamid() {
        return examid;
    }

    public void setExamid(Integer examid) {
        this.examid = examid;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;

        Student student = (Student) o;

        if (getExamid() != null ? !getExamid().equals(student.getExamid()) : student.getExamid() != null) return false;
        if (getName() != null ? !getName().equals(student.getName()) : student.getName() != null) return false;
        if (getId() != null ? !getId().equals(student.getId()) : student.getId() != null) return false;
        return getSid() != null ? getSid().equals(student.getSid()) : student.getSid() == null;
    }

    @Override
    public int hashCode() {
        int result = getExamid() != null ? getExamid().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getId() != null ? getId().hashCode() : 0);
        result = 31 * result + (getSid() != null ? getSid().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Student{" +
                "examid=" + examid +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", sid=" + sid +
                '}';
    }
}
