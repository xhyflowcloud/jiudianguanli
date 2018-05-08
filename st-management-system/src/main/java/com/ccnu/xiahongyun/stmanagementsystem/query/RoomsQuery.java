package com.ccnu.xiahongyun.stmanagementsystem.query;

public class RoomsQuery {
    private Integer roomId;
    private String  roomName;
    private String pURL;
    private String type;
    private Integer totalRecord;
    private Integer pageIndex;
    private Integer pageSize;
    private Double price;
    private Integer total;

    public RoomsQuery() {
    }

    public Integer getTotal() {
        return this.total = (pageIndex-1) * pageSize;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

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

    public Integer getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(Integer totalRecord) {
        this.totalRecord = totalRecord;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}
