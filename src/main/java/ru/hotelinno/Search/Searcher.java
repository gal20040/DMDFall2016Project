package ru.hotelinno.Search;

import ru.hotelinno.Search.JDBC.ConnectionPool;
import ru.hotelinno.domain.RESULT.Result;
import ru.hotelinno.domain.RESULT.ResultDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Searcher {
    private Connection con;
    private ConnectionPool pool;
    public Searcher(){
        pool = new ConnectionPool();
        pool.initConnectionPool("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/hotelinno", "hoteluser", "123123");
        this.con= pool.getConnection();
    }
    public List<Result> searchRooms(List<String> options) throws SQLException{
        con.createStatement().executeUpdate("DROP TABLE IF EXISTS tempHotel");
        con.createStatement().executeUpdate("CREATE TEMPORARY TABLE tempHotel AS ( " +
                "SELECT HotelTable.*, RoomTable.* " +
                "FROM Room RoomTable, Hotel HotelTable " +
                "LEFT JOIN City CityTable ON CityTable.CityID = HotelTable.CityID " +
                "WHERE CityTable.CityName = " + options.get(0) + ");");
        PreparedStatement ps = con.prepareStatement("SELECT tempHotelTable.HotelID, tempHotelTable.HotelName, tempHotelTable.Adress, " +
                "tempHotelTable.RoomID, tempHotelTable.RoomTypeName, tempHotelTable.CheckIn, tempHotelTableCheckOut "+
                "FROM tempHotel tempHotelTable\n" +
                "LEFT JOIN roombooking RBTable ON RBTable.HotelID = tempHotelTable.HotelID AND RBTable.RoomID = tempHotelTable.RoomID\n" +
                "AND ((CheckIn > ? AND CheckOut < ?)\n" +
                "OR (CheckIn < ? AND CheckOut > ?)\n" +
                "OR (CheckIn > ? AND CheckIn < ?)\n" +
                "OR (CheckOut > ? AND CheckOut < ?))\n" +
                "WHERE\n" +
                "RBTable.HotelID IS NULL\n" +
                "AND RBTable.RoomID IS NULL\n" + formQuery(options) +
                "ORDER BY tempHotelTable.HotelID, tempHotelTable.RoomID");
        ps.setString(1, options.get(1));
        ps.setString(3, options.get(1));
        ps.setString(5, options.get(1));
        ps.setString(7, options.get(1));
        ps.setString(2, options.get(2));
        ps.setString(4, options.get(2));
        ps.setString(6, options.get(2));
        ps.setString(8, options.get(2));
        ResultSet rs = ps.executeQuery();
        List<Result> results = new ArrayList<Result>();
        while (rs.next()){
            results.add(ResultDAO.getResultFormRS(rs));
        }
        rs.close();
        return results;
    }

    private String formQuery(List<String> options){
        String res="";
        if (!options.get(3).equals("*")){
            res+=" AND temp.HotelTable.RoomType = " + options.get(3);
        }
        if (!options.get(4).equals("*")){
            res+=" AND " + options.get(4);
        }
        return res;
    }
}
