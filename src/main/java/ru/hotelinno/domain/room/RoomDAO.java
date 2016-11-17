package ru.hotelinno.domain.room;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomDAO {

    private final Connection con;

    public RoomDAO(Connection con){
        this.con=con;
    }

    private Room getRoomFormRS(ResultSet rs) throws SQLException {
        Room result = new Room();

        result.setRoomID(rs.getInt("RoomID"));
        result.setTypeID(rs.getInt("TypeID"));
        return result;
    }

    public Room getRoom(int id){
        Room result = null;
        try{
            PreparedStatement ps =con.prepareStatement("SELECT * FROM room WHERE RoomID=?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                result = getRoomFormRS(rs);
            }
            ps.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    public List<Room> getRoomList(){
        List<Room> result = new ArrayList<Room>();
        try{
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM room");
            while (rs.next()){
                result.add(getRoomFormRS(rs));
            }
            rs.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    public void deleteRoom(int id){
        try{
            PreparedStatement ps = con.prepareStatement("DELETE FROM room WHERE RoomID=?");
            ps.setInt(1, id);
            ps.executeQuery();
        }
        catch (SQLException  e){
            e.printStackTrace();
        }
    }
}
