package ru.hotelinno.domain.city;

public final class City {
    private int cityID;
    private String name;
    private int countryID;
    

    public int getCityID(){
        return cityID;
    }

    public int getCountryID() {
        return countryID;
    }

    public String getName() {
        return name;
    }

    public void setCountryID(int countryID) {
        this.countryID = countryID;
    }

    public void setCityID(int cityID) {
        this.cityID = cityID;
    }

    public void setName(String name) {
        this.name = name;
    }

}