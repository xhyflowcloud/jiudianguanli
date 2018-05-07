package com.ccnu.xiahongyun.stmanagementsystem.query;

import java.util.Date;

public class RoomQuery {
    private String  roomName;
    private String pURL;
    private String type;

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

    private Integer pageRecord;
    private Integer pageIndex;
    private Integer pageSize;

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getpURL() {
        return pURL;
    }

    public void setpURL(String pURL) {
        this.pURL = pURL;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public Integer getPageRecord() {
        return pageRecord;
    }

    public void setPageRecord(Integer pageRecord) {
        this.pageRecord = pageRecord;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public RoomQuery() {
    }
}
