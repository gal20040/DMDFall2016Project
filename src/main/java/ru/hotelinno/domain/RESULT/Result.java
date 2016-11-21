package ru.hotelinno.domain.RESULT;

public  class Result {
    private int hotelID;
    private String hotelName;
    private String address;
    private int roomID;
    private String roomType;
    private int price;
    private String hrID;
    private String checkInDate;
    private String checkOutDate;
    private String cityName;

    public int getHotelID() {return hotelID;}
    public String getHotelName() {return hotelName;}
    public String getAddress() {return address;}
    public int getRoomID() {return roomID;}
    public String getRoomType() {return roomType;}
    public int getPrice() {return price;}
    public String getHrID() {return hrID;}
    public String getCheckInDate() {return checkInDate;}
    public String getCheckOutDate() {return checkOutDate;}
    public String getCityName() {return cityName;}

    public void setHotelID(int hotelID) {this.hotelID = hotelID;}
    public void setHotelName(String hotelName) {this.hotelName = hotelName;}
    public void setAddress(String address) {this.address = address;}
    public void setRoomID(int roomID) {this.roomID = roomID;}
    public void setRoomType(String roomType) {this.roomType = roomType;}
    public void setPrice(int price) {this.price = price;}
    public void setHrID(String hrID) {this.hrID = hrID;}
    public void setCheckInDate(String checkInDate) {this.checkInDate = checkInDate;}
    public void setCheckOutDate(String checkOutDate) {this.checkOutDate = checkOutDate;}
    public void setCityName(String cityName) {this.cityName = cityName;}
}