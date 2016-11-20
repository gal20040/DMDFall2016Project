package ru.hotelinno.domain.RESULT;

public  class Result {
    private int hotelID;
    private String hotelName;
    private String address;
    private int roomID;
    private String roomType;
    private int price;
//    private String hrID;
//    private String checkInDate;
//    private String checkOutDate;

//    public String getCheckInDate() {
//        return checkInDate;
//    }
//
//    public void setCheckInDate(String checkInDate) {
//        this.checkInDate = checkInDate;
//    }
//
//    public String getCheckOutDate() {
//        return checkOutDate;
//    }
//
//    public void setCheckOutDate(String checkOutDate) {
//        this.checkOutDate = checkOutDate;
//    }

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

//    public String getHrID() {
//        return hrID;
//    }
//
//    public void setHrID(String hrID) {
//        this.hrID = hrID;
//    }
}