package ru.hotelinno.domain.roomorder;

public final class RoomOrder {
    private int orderID;
    private int RBID;
    private int userID;

    public void setRBID(int RBID) {
        this.RBID = RBID;
    }

    public int getRBID() {
        return RBID;
    }

    public int getOrderID() {
        return orderID;
    }

    public int getUserID() {
        return userID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}
