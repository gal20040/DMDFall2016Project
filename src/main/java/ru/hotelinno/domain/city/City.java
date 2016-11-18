package ru.hotelinno.domain.city;

public final class City {
    private int cityID;
    private String name;
    

    public int getCityID(){
        return cityID;
    }

    public String getName() {
        return name;
    }

    public void setCityID(int cityID) {
        this.cityID = cityID;
    }

    public void setName(String name) {
        this.name = name;
    }

}
