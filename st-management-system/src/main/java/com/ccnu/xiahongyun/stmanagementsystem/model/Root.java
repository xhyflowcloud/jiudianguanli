package com.ccnu.xiahongyun.stmanagementsystem.model;

public class Root {
    String email;
    Integer auth;
    Integer id;
    Boolean enable;

    public Root(String email, Integer auth, Integer id, Boolean enable) {
        this.email = email;
        this.auth = auth;
        this.id = id;
        this.enable = enable;
    }

    public Root() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAuth() {
        return auth;
    }

    public void setAuth(Integer auth) {
        this.auth = auth;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Root)) return false;

        Root root = (Root) o;

        if (getEmail() != null ? !getEmail().equals(root.getEmail()) : root.getEmail() != null) return false;
        if (getAuth() != null ? !getAuth().equals(root.getAuth()) : root.getAuth() != null) return false;
        if (getId() != null ? !getId().equals(root.getId()) : root.getId() != null) return false;
        return getEnable() != null ? getEnable().equals(root.getEnable()) : root.getEnable() == null;
    }

    @Override
    public int hashCode() {
        int result = getEmail() != null ? getEmail().hashCode() : 0;
        result = 31 * result + (getAuth() != null ? getAuth().hashCode() : 0);
        result = 31 * result + (getId() != null ? getId().hashCode() : 0);
        result = 31 * result + (getEnable() != null ? getEnable().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Root{" +
                "email='" + email + '\'' +
                ", auth=" + auth +
                ", id=" + id +
                ", enable=" + enable +
                '}';
    }
}
