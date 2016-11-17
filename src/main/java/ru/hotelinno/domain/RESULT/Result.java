package ru.hotelinno.domain.RESULT;

public  class Result {
    private int hotelID;
    private String hotelName;
    private String address;
    private int roomID;
    private String roomType;
    private int price;

    public int getHotelID() {
        return hotelID;
    }

    public int getPrice() {
        return price;
    }

    public int getRoomID() {
        return roomID;
    }

    public String getAddress() {
        return address;
    }

    public String getHotelName() {
        return hotelName;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setHotelID(int hotelID) {
        this.hotelID = hotelID;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }
}
