package com.ccnu.xiahongyun.stmanagementsystem.model;

public class Studentexamroominfo {
    private Integer examroomId;
    private Integer studentId;

    public Studentexamroominfo(Integer examroomId, Integer studentId) {
        this.examroomId = examroomId;
        this.studentId = studentId;
    }

    public Integer getExamroomId() {
        return examroomId;
    }

    public void setExamroomId(Integer examroomId) {
        this.examroomId = examroomId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Studentexamroominfo() {
    }

    @Override
    public String toString() {
        return "Studentexamroominfo{" +
                "examroomId=" + examroomId +
                ", studentId=" + studentId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Studentexamroominfo)) return false;

        Studentexamroominfo that = (Studentexamroominfo) o;

        if (getExamroomId() != null ? !getExamroomId().equals(that.getExamroomId()) : that.getExamroomId() != null)
            return false;
        return getStudentId() != null ? getStudentId().equals(that.getStudentId()) : that.getStudentId() == null;
    }

    @Override
    public int hashCode() {
        int result = getExamroomId() != null ? getExamroomId().hashCode() : 0;
        result = 31 * result + (getStudentId() != null ? getStudentId().hashCode() : 0);
        return result;
    }
}
