package ru.hotelinno.domain.city;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CityDAO {
    private final Connection con;

    public CityDAO(Connection con){
        this.con=con;
    }

    private City getCityFormRS(ResultSet rs) throws SQLException {
        City result = new City();

        result.setCityID(rs.getInt("CityID"));
        result.setCountryID(rs.getInt("CountryID"));
        result.setName(rs.getString("CityName"));
        return result;
    }

    public City getCity(int id){
        City result = null;
        try{
            PreparedStatement ps =con.prepareStatement("SELECT * FROM city WHERE CityID=?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                result = getCityFormRS(rs);
            }
            ps.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    public City getCity(String name){
        City result = null;
        try{
            PreparedStatement ps =con.prepareStatement("SELECT * FROM city WHERE CityName=?");
            ps.setString(1, name);

            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                result = getCityFormRS(rs);
            }
            ps.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    public List<City> getCityList(){
        List<City> result = new ArrayList<City>();
        try{
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM city");
            while (rs.next()){
                result.add(getCityFormRS(rs));
            }
            rs.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    public void deleteCity(int id){
        try{
            PreparedStatement ps = con.prepareStatement("DELETE FROM city WHERE cityID=?");
            ps.setInt(1, id);
            ps.executeQuery();
        }
        catch (SQLException  e){
            e.printStackTrace();
        }
    }
}
