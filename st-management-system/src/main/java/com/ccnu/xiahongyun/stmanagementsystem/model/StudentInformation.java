package com.ccnu.xiahongyun.stmanagementsystem.model;

public class StudentInformation {
    private Integer subjectId ;
    private Integer studentId ;

    public StudentInformation() {
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentInformation)) return false;

        StudentInformation that = (StudentInformation) o;

        if (getSubjectId() != null ? !getSubjectId().equals(that.getSubjectId()) : that.getSubjectId() != null)
            return false;
        return getStudentId() != null ? getStudentId().equals(that.getStudentId()) : that.getStudentId() == null;
    }

    @Override
    public int hashCode() {
        int result = getSubjectId() != null ? getSubjectId().hashCode() : 0;
        result = 31 * result + (getStudentId() != null ? getStudentId().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "StudentInformation{" +
                "subjectId=" + subjectId +
                ", studentId=" + studentId +
                '}';
    }
}
