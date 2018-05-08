package com.ccnu.xiahongyun.stmanagementsystem.query;

import com.ccnu.xiahongyun.stmanagementsystem.model.RoomCheckIn;
import com.ccnu.xiahongyun.stmanagementsystem.model.User;

public class CheckInEntity {

    private User user;

    private RoomCheckIn roomCheckIn;

    public CheckInEntity() {
    }

    public CheckInEntity(User user, RoomCheckIn roomCheckIn) {
        this.user = user;
        this.roomCheckIn = roomCheckIn;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public RoomCheckIn getRoomCheckIn() {
        return roomCheckIn;
    }

    public void setRoomCheckIn(RoomCheckIn roomCheckIn) {
        this.roomCheckIn = roomCheckIn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CheckInEntity)) return false;

        CheckInEntity that = (CheckInEntity) o;

        if (getUser() != null ? !getUser().equals(that.getUser()) : that.getUser() != null) return false;
        return getRoomCheckIn() != null ? getRoomCheckIn().equals(that.getRoomCheckIn()) : that.getRoomCheckIn() == null;
    }

    @Override
    public int hashCode() {
        int result = getUser() != null ? getUser().hashCode() : 0;
        result = 31 * result + (getRoomCheckIn() != null ? getRoomCheckIn().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CheckInEntity{" +
                "user=" + user +
                ", roomCheckIn=" + roomCheckIn +
                '}';
    }
}
