package ru.hotelinno.domain.roombooking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoombookingDAO {

    private final Connection con;

    public RoombookingDAO(Connection con){
        this.con=con;
    }

    private Roombooking getRoombookingFormRS(ResultSet rs) throws SQLException {
        Roombooking result = new Roombooking();

        result.setRoomID(rs.getInt("RoomID"));
        result.setHotelID(rs.getInt("TypeID"));
        result.setRBID(rs.getInt("RBID"));
        return result;
    }

    public Roombooking getRoomboking(int id){
        Roombooking result = null;
        try{
            PreparedStatement ps =con.prepareStatement("SELECT * FROM roombooking WHERE RBID=?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                result = getRoombookingFormRS(rs);
            }
            ps.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    public List<Roombooking> getRoombookingList(){
        List<Roombooking> result = new ArrayList<Roombooking>();
        try{
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM roombooking");
            while (rs.next()){
                result.add(getRoombookingFormRS(rs));
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
            PreparedStatement ps = con.prepareStatement("DELETE FROM roombooking WHERE RBID=?");
            ps.setInt(1, id);
            ps.executeQuery();
        }
        catch (SQLException  e){
            e.printStackTrace();
        }
    }
}
