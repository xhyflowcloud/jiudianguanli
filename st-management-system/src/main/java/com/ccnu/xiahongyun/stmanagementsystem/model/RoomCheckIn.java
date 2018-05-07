package com.ccnu.xiahongyun.stmanagementsystem.model;

import java.util.Date;

public class RoomCheckIn {
    /*自增主键*/
    private Integer roomCheckInId;

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

    public RoomCheckIn(Integer roomCheckInId, Date timeBegin, Date timeEnd, Integer userId, Integer roomId, Integer swimming, Integer gym, Boolean freeDinks, Double totPrice) {
        this.roomCheckInId = roomCheckInId;
        this.timeBegin = timeBegin;
        this.timeEnd = timeEnd;
        this.userId = userId;
        this.roomId = roomId;
        this.swimming = swimming;
        this.gym = gym;
        this.freeDinks = freeDinks;
        this.totPrice = totPrice;
    }

    @Override
    public String toString() {
        return "RoomCheckIn{" +
                "roomCheckInId=" + roomCheckInId +
                ", timeBegin=" + timeBegin +
                ", timeEnd=" + timeEnd +
                ", userId=" + userId +
                ", roomId=" + roomId +
                ", swimming=" + swimming +
                ", gym=" + gym +
                ", freeDinks=" + freeDinks +
                ", totPrice=" + totPrice +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RoomCheckIn)) return false;

        RoomCheckIn that = (RoomCheckIn) o;

        if (getRoomCheckInId() != null ? !getRoomCheckInId().equals(that.getRoomCheckInId()) : that.getRoomCheckInId() != null)
            return false;
        if (getTimeBegin() != null ? !getTimeBegin().equals(that.getTimeBegin()) : that.getTimeBegin() != null)
            return false;
        if (getTimeEnd() != null ? !getTimeEnd().equals(that.getTimeEnd()) : that.getTimeEnd() != null) return false;
        if (getUserId() != null ? !getUserId().equals(that.getUserId()) : that.getUserId() != null) return false;
        if (getRoomId() != null ? !getRoomId().equals(that.getRoomId()) : that.getRoomId() != null) return false;
        if (getSwimming() != null ? !getSwimming().equals(that.getSwimming()) : that.getSwimming() != null)
            return false;
        if (getGym() != null ? !getGym().equals(that.getGym()) : that.getGym() != null) return false;
        if (getFreeDinks() != null ? !getFreeDinks().equals(that.getFreeDinks()) : that.getFreeDinks() != null)
            return false;
        return getTotPrice() != null ? getTotPrice().equals(that.getTotPrice()) : that.getTotPrice() == null;
    }

    @Override
    public int hashCode() {
        int result = getRoomCheckInId() != null ? getRoomCheckInId().hashCode() : 0;
        result = 31 * result + (getTimeBegin() != null ? getTimeBegin().hashCode() : 0);
        result = 31 * result + (getTimeEnd() != null ? getTimeEnd().hashCode() : 0);
        result = 31 * result + (getUserId() != null ? getUserId().hashCode() : 0);
        result = 31 * result + (getRoomId() != null ? getRoomId().hashCode() : 0);
        result = 31 * result + (getSwimming() != null ? getSwimming().hashCode() : 0);
        result = 31 * result + (getGym() != null ? getGym().hashCode() : 0);
        result = 31 * result + (getFreeDinks() != null ? getFreeDinks().hashCode() : 0);
        result = 31 * result + (getTotPrice() != null ? getTotPrice().hashCode() : 0);
        return result;
    }

    public Integer getRoomCheckInId() {

        return roomCheckInId;
    }

    public void setRoomCheckInId(Integer roomCheckInId) {
        this.roomCheckInId = roomCheckInId;
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
