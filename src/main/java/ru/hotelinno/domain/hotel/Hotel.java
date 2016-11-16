package ru.hotelinno.domain.hotel;

public class Hotel {
    private int hotelID;
    private String hotelName;
    private String adress;
    private int cityID;

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setCityID(int cityID) {
        this.cityID = cityID;
    }

    public void setHotelID(int hotelID) {
        this.hotelID = hotelID;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelName() {
        return hotelName;
    }

    public String getAdress() {
        return adress;
    }

    public int getHotelID() {
        return hotelID;
    }

    public int getCityID() {
        return cityID;
    }
}
