package ru.hotelinno.domain;

public class WishfulRoomData {

    private String cityName;
    private String roomType;
    private String checkInDate;
    private String checkOutDate;
    private String hotelID;
    private String roomID;

    public WishfulRoomData() {}

    public WishfulRoomData(String cityName, String roomType, String checkInDate, String checkOutDate) {
        this.cityName = cityName;
        this.roomType = roomType;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public WishfulRoomData(int hotelID, int roomID, String checkInDate, String checkOutDate) {
        this.hotelID = hotelID + "";
        this.roomID = roomID + "";
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public String getCityName() {return cityName;}
    public String getRoomType() {return roomType;}
    public String getCheckInDate() {return checkInDate;}
    public String getCheckOutDate() {return checkOutDate;}
    public String getHotelID() {return hotelID;}
    public String getRoomID() {return roomID;}

    public void setCityName(String cityName) {this.cityName = cityName;}
    public void setRoomType(String roomType) {this.roomType = roomType;}
    public void setCheckInDate(String checkInDate) {this.checkInDate = checkInDate;}
    public void setCheckOutDate(String checkOutDate) {this.checkOutDate = checkOutDate;}
    public void setHotelID(String hotelID) {this.hotelID = hotelID + "";}
    public void setRoomID(String roomID) {this.roomID = roomID + "";}
}