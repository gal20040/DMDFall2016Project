package ru.hotelinno.domain.roombooking;

public final class Roombooking {
    private int RBID;
    private int hotelID;
    private int roomID;

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public int getHotelID() {
        return hotelID;
    }

    public int getRBID() {
        return RBID;
    }

    public void setRBID(int RBID) {
        this.RBID = RBID;
    }

    public void setHotelID(int hotelID) {
        this.hotelID = hotelID;
    }
}
