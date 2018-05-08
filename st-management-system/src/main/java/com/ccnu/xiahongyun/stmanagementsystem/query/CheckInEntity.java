package com.ccnu.xiahongyun.stmanagementsystem.query;

import com.ccnu.xiahongyun.stmanagementsystem.model.RoomCheckIn;
import com.ccnu.xiahongyun.stmanagementsystem.model.User;

import java.util.Date;

public class CheckInEntity {

    private String UserName;

    /*身份证*/
    private String userIDNum;

    private String phone;

    /*开始入住时间*/
    private Date timeBegin;

    /* 结束时间  */
    private Date timeEnd;

    private Integer userId;

    private Integer roomId;

    /*游泳池套餐数量*/
    private Integer swimming;

    /*健生房套餐数量*/
    private Integer gym;

    /*免费酒水权限*/
    private Boolean freeDinks;

    /*住房总费用*/
    private Double totPrice;

    public CheckInEntity() {
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

    public Date getTimeBegin() {
        return timeBegin;
    }

    public void setTimeBegin(Date timeBegin) {
        this.timeBegin = timeBegin;
    }

    public Date getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Date timeEnd) {
        this.timeEnd = timeEnd;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getSwimming() {
        return swimming;
    }

    public void setSwimming(Integer swimming) {
        this.swimming = swimming;
    }

    public Integer getGym() {
        return gym;
    }

    public void setGym(Integer gym) {
        this.gym = gym;
    }

    public Boolean getFreeDinks() {
        return freeDinks;
    }

    public void setFreeDinks(Boolean freeDinks) {
        this.freeDinks = freeDinks;
    }

    public Double getTotPrice() {
        return totPrice;
    }

    public void setTotPrice(Double totPrice) {
        this.totPrice = totPrice;
    }
}
