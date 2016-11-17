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
    private ConnectionPool pool = new ConnectionPool();
    public Searcher(){
        pool = new ConnectionPool();
        pool.initConnectionPool("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/hotelinno", "hoteluser", "123123");
        this.con= pool.getConnection();
    }
    public  List<Result> searchRooms(List<String> options) throws SQLException{
        con.createStatement().executeUpdate("DROP TABLE IF EXISTS tempHotel;");
        String paramString = String.format(
                "CREATE TEMPORARY TABLE tempHotel AS ( \n" +
                        "SELECT RoomTable.*, HotelTable.* \n" +
                        "FROM Room RoomTable, Hotel HotelTable \n" +
                        "    LEFT JOIN City CityTable ON CityTable.CityID = HotelTable.CityID \n" +
                        "WHERE CityTable.CityName = '%s' );", options.get(0));
        con.createStatement().executeUpdate(paramString);
        paramString = String.format(
                "SELECT tempHotelTable.HotelID, tempHotelTable.HotelName, tempHotelTable.Address, \n" +
                        "tempHotelTable.RoomID, RTTable.RoomTypeName, RTTable.Price \n"+
                        "FROM tempHotel tempHotelTable \n" +
                        "    LEFT JOIN roombooking RBTable ON RBTable.HotelID = tempHotelTable.HotelID AND RBTable.RoomID = tempHotelTable.RoomID \n" +
                        "        AND ((RBTable.CheckIn > %s AND RBTable.CheckOut < %s)\n" +
                        "        OR (RBTable.CheckIn < %s AND RBTable.CheckOut > %s)\n" +
                        "        OR (RBTable.CheckIn > %s AND RBTable.CheckIn < %s)\n" +
                        "        OR (RBTable.CheckOut > %s AND RBTable.CheckOut < %s))\n" +
                        "    LEFT JOIN roomtype RTTable ON RTTable.RoomTypeID = tempHotelTable.TypeID \n" +
                        "WHERE\n" +
                        "RBTable.HotelID IS NULL\n" +
                        "AND RBTable.RoomID IS NULL\n %s \n %s",
                options.get(1), options.get(2), options.get(1), options.get(2),
                options.get(1), options.get(2), options.get(1), options.get(2),
                formQuery(options), "ORDER BY RTTable.Price"
        );

        PreparedStatement ps = con.prepareStatement(paramString);
//        ps.setString(1, options.get(1));
//        ps.setString(3, options.get(1));
//        ps.setString(5, options.get(1));
//        ps.setString(7, options.get(1));
//        ps.setString(2, options.get(2));
//        ps.setString(4, options.get(2));
//        ps.setString(6, options.get(2));
//        ps.setString(8, options.get(2));
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
            res+=" AND RTTable.RoomTypeName = " + options.get(3);
        }
        if (!options.get(4).equals("*")){
            res+=" AND " + options.get(4);
        }
        return res;
    }
}