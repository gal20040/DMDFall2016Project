package ru.hotelinno.domain.country;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Илья on 15.11.2016.
 */
public class CountryDAO {
    private final Connection con;

    public CountryDAO(Connection con){
        this.con=con;
    }

    private Country getCountryFormRS(ResultSet rs) throws SQLException{
        Country result = new Country();

        result.setCountryID(rs.getInt("CountryID"));
        result.setName(rs.getString("CountryName"));
        return result;
    }

    public Country getCountry(int id){
        Country result = null;
        try{
            PreparedStatement ps =con.prepareStatement("SELECT * FROM country WHERE CountryID=?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                result = getCountryFormRS(rs);
            }
            ps.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    public List<Country> getCountryList(){
        List<Country> result = new ArrayList<Country>();
        try{
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM country");
            while (rs.next()){
                result.add(getCountryFormRS(rs));
            }
            rs.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    public void deleteCountry(int id) {
        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM country WHERE CountryID=?");
            ps.setInt(1, id);
            ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
