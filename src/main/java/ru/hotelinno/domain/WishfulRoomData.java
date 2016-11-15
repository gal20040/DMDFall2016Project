package ru.hotelinno.domain;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.ArrayList;

//@Table(name = "wishfulRoomData")
public class WishfulRoomData {

//    @Column(name = "cityName")
    private String cityName;

//    @Column(name = "roomType")
    private String roomType;

//    @Column(name = "checkInDate")
    private String checkInDate;

//    @Column(name = "checkOutDate")
    private String checkOutDate;

//    public WishfulRoomData() {}

    public WishfulRoomData(String cityName, String roomType, String checkInDate, String checkOutDate) {
        this.cityName = cityName;
        this.roomType = roomType;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public String getCityName() {return cityName;}
    public String getRoomType() {return roomType;}
    public String getCheckInDate() {return checkInDate;}
    public String getCheckOutDate() {return checkOutDate;}

    public void setCityName(String cityName) {this.cityName = cityName;}
    public void setRoomType(String roomType) {this.roomType = roomType;}
    public void setCheckInDate(String checkInDate) {this.checkInDate = checkInDate;}
    public void setCheckOutDate(String checkOutDate) {this.checkOutDate = checkOutDate;}

    //    public ArrayList<String> getListOfAllParams() {
//        ArrayList<String> stringArrayList = new ArrayList<String>();
//        stringArrayList.add(cityName.getClass().getSimpleName());
//        stringArrayList.add(roomType.getClass().getSimpleName());
//        stringArrayList.add(checkInDate.getClass().getSimpleName());
//        stringArrayList.add(checkOutDate.getClass().getSimpleName());
//        return stringArrayList;
//    }
}