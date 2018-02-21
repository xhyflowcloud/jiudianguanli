package com.ccnu.xiahongyun.stmanagementsystem.model;

public class Examroom {
    Integer id;
    Integer tid;//监考人员
    Integer rid;//教室id
    Integer sid;//考试科目
    Integer number;//人数

    public Examroom() {
    }

    @Override
    public String toString() {
        return "Examroom{" +
                "id=" + id +
                ", tid=" + tid +
                ", rid=" + rid +
                ", sid=" + sid +
                ", number=" + number +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Examroom)) return false;

        Examroom examroom = (Examroom) o;

        if (getId() != null ? !getId().equals(examroom.getId()) : examroom.getId() != null) return false;
        if (getTid() != null ? !getTid().equals(examroom.getTid()) : examroom.getTid() != null) return false;
        if (getRid() != null ? !getRid().equals(examroom.getRid()) : examroom.getRid() != null) return false;
        if (getSid() != null ? !getSid().equals(examroom.getSid()) : examroom.getSid() != null) return false;
        return getNumber() != null ? getNumber().equals(examroom.getNumber()) : examroom.getNumber() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getTid() != null ? getTid().hashCode() : 0);
        result = 31 * result + (getRid() != null ? getRid().hashCode() : 0);
        result = 31 * result + (getSid() != null ? getSid().hashCode() : 0);
        result = 31 * result + (getNumber() != null ? getNumber().hashCode() : 0);
        return result;
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Examroom(Integer id, Integer tid, Integer rid, Integer sid, Integer number) {

        this.id = id;
        this.tid = tid;
        this.rid = rid;
        this.sid = sid;
        this.number = number;
    }
}
