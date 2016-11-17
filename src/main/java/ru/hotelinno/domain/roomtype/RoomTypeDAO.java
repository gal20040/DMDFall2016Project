package ru.hotelinno.domain.roomtype;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomTypeDAO {
    private final Connection con;

    public RoomTypeDAO(Connection con){
        this.con=con;
    }

    private RoomType getRoomTypeFormRS(ResultSet rs) throws SQLException {
        RoomType result = new RoomType();

        result.setPrice(rs.getInt("Price"));
        result.setTypeID(rs.getInt("RoomTypeID"));
        result.setTypeName(rs.getString("RoomTypeName"));
        return result;
    }

    public RoomType getRoomType(int id){
        RoomType result = null;
        try{
            PreparedStatement ps =con.prepareStatement("SELECT * FROM roomtype WHERE RoomTypeID=?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                result = getRoomTypeFormRS(rs);
            }
            ps.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    public List<RoomType> getRoomTypeList(){
        List<RoomType> result = new ArrayList<RoomType>();
        try{
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM roomtype");
            while (rs.next()){
                result.add(getRoomTypeFormRS(rs));
            }
            rs.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    public void deleteRoombooking(int id){
        try{
            PreparedStatement ps = con.prepareStatement("DELETE FROM roomtype WHERE RoomTypeID=?");
            ps.setInt(1, id);
            ps.executeQuery();
        }
        catch (SQLException  e){
            e.printStackTrace();
        }
    }
}
