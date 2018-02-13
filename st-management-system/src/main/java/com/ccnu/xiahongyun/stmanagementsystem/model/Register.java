package com.ccnu.xiahongyun.stmanagementsystem.model;

public class Register {
    Integer id;
    String name;
    String email;
    String pwd;

    public Register() {

    }

    public Register(Integer id, String name, String email, String pwd) {

        this.id = id;
        this.name = name;
        this.email = email;
        this.pwd = pwd;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "Register{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Register)) return false;

        Register register = (Register) o;

        if (getId() != null ? !getId().equals(register.getId()) : register.getId() != null) return false;
        if (getName() != null ? !getName().equals(register.getName()) : register.getName() != null) return false;
        if (getEmail() != null ? !getEmail().equals(register.getEmail()) : register.getEmail() != null) return false;
        return getPwd() != null ? getPwd().equals(register.getPwd()) : register.getPwd() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (getPwd() != null ? getPwd().hashCode() : 0);
        return result;
    }
}
