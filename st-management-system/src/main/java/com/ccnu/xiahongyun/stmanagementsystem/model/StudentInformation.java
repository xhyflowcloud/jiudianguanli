package com.ccnu.xiahongyun.stmanagementsystem.model;

public class StudentInformation {
    Integer examid;
    Integer sbid;

    @Override
    public String toString() {
        return "StudentInformation{" +
                "examid=" + examid +
                ", sbid=" + sbid +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentInformation)) return false;

        StudentInformation that = (StudentInformation) o;

        if (getExamid() != null ? !getExamid().equals(that.getExamid()) : that.getExamid() != null) return false;
        return getSbid() != null ? getSbid().equals(that.getSbid()) : that.getSbid() == null;
    }

    @Override
    public int hashCode() {
        int result = getExamid() != null ? getExamid().hashCode() : 0;
        result = 31 * result + (getSbid() != null ? getSbid().hashCode() : 0);
        return result;
    }

    public Integer getExamid() {

        return examid;
    }

    public void setExamid(Integer examid) {
        this.examid = examid;
    }

    public Integer getSbid() {
        return sbid;
    }

    public void setSbid(Integer sbid) {
        this.sbid = sbid;
    }

    public StudentInformation(Integer examid, Integer sbid) {

        this.examid = examid;
        this.sbid = sbid;
    }
}
