package com.ccnu.xiahongyun.stmanagementsystem.model;

public class Examroom {
    private Integer id ;
    private Integer rid ;//教室id
    private Integer tid ;//监考人员id
    private Integer number ;
    private Integer sid ;//科目id

    public Examroom(Integer id, Integer rid, Integer tid, Integer number, Integer sid) {
        this.id = id;
        this.rid = rid;
        this.tid = tid;
        this.number = number;
        this.sid = sid;
    }

    public Examroom() {
    }

    @Override
    public String toString() {
        return "Examroom{" +
                "id=" + id +
                ", rid=" + rid +
                ", tid=" + tid +
                ", number=" + number +
                ", sid=" + sid +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Examroom)) return false;

        Examroom examroom = (Examroom) o;

        if (getId() != null ? !getId().equals(examroom.getId()) : examroom.getId() != null) return false;
        if (getRid() != null ? !getRid().equals(examroom.getRid()) : examroom.getRid() != null) return false;
        if (getTid() != null ? !getTid().equals(examroom.getTid()) : examroom.getTid() != null) return false;
        if (getNumber() != null ? !getNumber().equals(examroom.getNumber()) : examroom.getNumber() != null)
            return false;
        return getSid() != null ? getSid().equals(examroom.getSid()) : examroom.getSid() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getRid() != null ? getRid().hashCode() : 0);
        result = 31 * result + (getTid() != null ? getTid().hashCode() : 0);
        result = 31 * result + (getNumber() != null ? getNumber().hashCode() : 0);
        result = 31 * result + (getSid() != null ? getSid().hashCode() : 0);
        return result;
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }
}
