package ru.hotelinno.domain.hotel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HotelDAO {
    private final Connection con;

    public HotelDAO(Connection con){
        this.con=con;
    }

    private Hotel getHotelFormRS(ResultSet rs) throws SQLException {
        Hotel result = new Hotel();

        result.setHotelID(rs.getInt("HotelID"));
        result.setCityID(rs.getInt("CityID"));
        result.setHotelName(rs.getString("HotelName"));
        result.setAdress(rs.getString("Address"));
        return result;
    }

    public Hotel getHotel(int id){
        Hotel result = null;
        try{
            PreparedStatement ps =con.prepareStatement("SELECT * FROM hotel WHERE HotelID=?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                result = getHotelFormRS(rs);
            }
            ps.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    public List<Hotel> getHotelListFromCity(int cityID){
        List<Hotel> result = new ArrayList<Hotel>();
        try{
            PreparedStatement ps = con.prepareStatement("SELECT * FROM hotel WHERE CityID=?");
            ps.setInt(1, cityID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                result.add(getHotelFormRS(rs));
            }
            rs.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    public void deleteHotel(int id){
        try{
            PreparedStatement ps = con.prepareStatement("DELETE FROM hotel WHERE HotelID=?");
            ps.setInt(1, id);
            ps.executeQuery();
        }
        catch (SQLException  e){
            e.printStackTrace();
        }
    }
}
