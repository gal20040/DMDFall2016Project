package ru.hotelinno.domain.roomorder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomOrderDAO {

    private final Connection con;

    public RoomOrderDAO(Connection con){
        this.con=con;
    }

    private RoomOrder getRoomOrderFormRS(ResultSet rs) throws SQLException {
        RoomOrder result = new RoomOrder();

        result.setRBID(rs.getInt("RBID"));
        result.setOrderID(rs.getInt("OrderID"));
        result.setUserID(rs.getInt("UserID"));
        return result;
    }

    public RoomOrder getRoomOrder(int id){
        RoomOrder result = null;
        try{
            PreparedStatement ps =con.prepareStatement("SELECT * FROM roomorder WHERE OrderID=?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                result = getRoomOrderFormRS(rs);
            }
            ps.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    public List<RoomOrder> getRoomOrderList(){
        List<RoomOrder> result = new ArrayList<RoomOrder>();
        try{
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM roomorder");
            while (rs.next()){
                result.add(getRoomOrderFormRS(rs));
            }
            rs.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    public void deleteRoomOrder(int id){
        try{
            PreparedStatement ps = con.prepareStatement("DELETE FROM roomorder WHERE OrderID=?");
            ps.setInt(1, id);
            ps.executeQuery();
        }
        catch (SQLException  e){
            e.printStackTrace();
        }
    }
}
