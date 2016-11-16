package ru.hotelinno.domain.country;

/**
 * Created by Илья on 15.11.2016.
 */
public class Country {
    private int countryID;
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public void setCountryID(int countryID) {
        this.countryID = countryID;
    }

    public String getName() {
        return name;
    }

    public int getCountryID() {
        return countryID;
    }
}
