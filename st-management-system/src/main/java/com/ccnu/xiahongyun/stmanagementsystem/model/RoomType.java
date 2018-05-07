package com.ccnu.xiahongyun.stmanagementsystem.model;

public class RoomType {
    /*自增主键*/
    private Integer roomTypeId;

    /*房间类型*/
    private String type;

    /*房间价格*/
    private Double price;

    public RoomType(Integer roomTypeId, String type, Double price) {
        this.roomTypeId = roomTypeId;
        this.type = type;
        this.price = price;
    }

    @Override
    public String toString() {
        return "RoomType{" +
                "roomTypeId=" + roomTypeId +
                ", type='" + type + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RoomType)) return false;

        RoomType roomType = (RoomType) o;

        if (getRoomTypeId() != null ? !getRoomTypeId().equals(roomType.getRoomTypeId()) : roomType.getRoomTypeId() != null)
            return false;
        if (getType() != null ? !getType().equals(roomType.getType()) : roomType.getType() != null) return false;
        return getPrice() != null ? getPrice().equals(roomType.getPrice()) : roomType.getPrice() == null;
    }

    @Override
    public int hashCode() {
        int result = getRoomTypeId() != null ? getRoomTypeId().hashCode() : 0;
        result = 31 * result + (getType() != null ? getType().hashCode() : 0);
        result = 31 * result + (getPrice() != null ? getPrice().hashCode() : 0);
        return result;
    }

    public Integer getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(Integer roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
