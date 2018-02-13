package com.ccnu.xiahongyun.stmanagementsystem.model;

public class Examroom {
    Integer id;
    Integer tid;
    Integer cid;
    Integer number;

    public Examroom() {
    }

    @Override
    public String toString() {
        return "Examroom{" +
                "id=" + id +
                ", tid=" + tid +
                ", cid=" + cid +
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
        if (getCid() != null ? !getCid().equals(examroom.getCid()) : examroom.getCid() != null) return false;
        return getNumber() != null ? getNumber().equals(examroom.getNumber()) : examroom.getNumber() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getTid() != null ? getTid().hashCode() : 0);
        result = 31 * result + (getCid() != null ? getCid().hashCode() : 0);
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

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Examroom(Integer id, Integer tid, Integer cid, Integer number) {

        this.id = id;
        this.tid = tid;
        this.cid = cid;
        this.number = number;
    }
}
