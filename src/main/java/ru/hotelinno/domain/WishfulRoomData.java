package ru.hotelinno.domain;

public class WishfulRoomData {

    private String cityName;
    private String roomType;
    private String checkInDate;
    private String checkOutDate;
    private int hotelID;
    private int roomID;

    public WishfulRoomData() {}

    public String getCityName() {return cityName;}
    public String getRoomType() {return roomType;}
    public String getCheckInDate() {return checkInDate;}
    public String getCheckOutDate() {return checkOutDate;}
    public int getHotelID() {return hotelID;}
    public int getRoomID() {return roomID;}

    public void setCityName(String cityName) {this.cityName = cityName;}
    public void setRoomType(String roomType) {this.roomType = roomType;}
    public void setCheckInDate(String checkInDate) {this.checkInDate = checkInDate;}
    public void setCheckOutDate(String checkOutDate) {this.checkOutDate = checkOutDate;}
    public void setHotelID(int hotelID) {this.hotelID = hotelID;}
    public void setRoomID(int roomID) {this.roomID = roomID;}
}