package com.ccnu.xiahongyun.stmanagementsystem.model;

public class Room {
    private Integer roomId;
    private String  roomName;
    private String pURL;
    private String type;

    public Room(Integer roomId, String roomName, String pURL, String type) {
        /*唯一主键自增*/
        this.roomId = roomId;
        /*房间名称 如 201*/
        this.roomName = roomName;
        /*房间图片展示*/
        this.pURL = pURL;
       /* 房间类型*/
        this.type = type;
    }

    public Room() {
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

    @Override
    public String toString() {
        return "Room{" +
                "roomId=" + roomId +
                ", roomName='" + roomName + '\'' +
                ", pURL='" + pURL + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Room)) return false;

        Room room = (Room) o;

        if (getRoomId() != null ? !getRoomId().equals(room.getRoomId()) : room.getRoomId() != null) return false;
        if (getRoomName() != null ? !getRoomName().equals(room.getRoomName()) : room.getRoomName() != null)
            return false;
        if (getpURL() != null ? !getpURL().equals(room.getpURL()) : room.getpURL() != null) return false;
        return getType() != null ? getType().equals(room.getType()) : room.getType() == null;
    }

    @Override
    public int hashCode() {
        int result = getRoomId() != null ? getRoomId().hashCode() : 0;
        result = 31 * result + (getRoomName() != null ? getRoomName().hashCode() : 0);
        result = 31 * result + (getpURL() != null ? getpURL().hashCode() : 0);
        result = 31 * result + (getType() != null ? getType().hashCode() : 0);
        return result;
    }
}
