package com.ccnu.xiahongyun.stmanagementsystem.model;

public class User {
    /*自增主键*/
    private Integer userId;

    private String UserName;
    
    /*身份证*/
    private String userIDNum;

    private String phone;

    public User() {
    }

    public User(Integer userId, String userName, String userIDNum, String phone) {

        this.userId = userId;
        UserName = userName;
        this.userIDNum = userIDNum;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", UserName='" + UserName + '\'' +
                ", userIDNum='" + userIDNum + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (getUserId() != null ? !getUserId().equals(user.getUserId()) : user.getUserId() != null) return false;
        if (getUserName() != null ? !getUserName().equals(user.getUserName()) : user.getUserName() != null)
            return false;
        if (getUserIDNum() != null ? !getUserIDNum().equals(user.getUserIDNum()) : user.getUserIDNum() != null)
            return false;
        return getPhone() != null ? getPhone().equals(user.getPhone()) : user.getPhone() == null;
    }

    @Override
    public int hashCode() {
        int result = getUserId() != null ? getUserId().hashCode() : 0;
        result = 31 * result + (getUserName() != null ? getUserName().hashCode() : 0);
        result = 31 * result + (getUserIDNum() != null ? getUserIDNum().hashCode() : 0);
        result = 31 * result + (getPhone() != null ? getPhone().hashCode() : 0);
        return result;
    }

    public Integer getUserId() {

        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserIDNum() {
        return userIDNum;
    }

    public void setUserIDNum(String userIDNum) {
        this.userIDNum = userIDNum;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
