package ru.hotelinno.Search;

import ru.hotelinno.Search.JDBC.ConnectionPool;
import ru.hotelinno.domain.RESULT.*;
import ru.hotelinno.domain.WishfulRoomData;

import java.sql.*;
import java.util.*;


public class Searcher {
    private Connection con;
    private ConnectionPool pool = new ConnectionPool();
    public Searcher(){
        pool = new ConnectionPool();
        pool.initConnectionPool("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/hotelinno", "hoteluserzzg", "123123");
        this.con= pool.getConnection();
    }

    public  List<Result> searchRooms(List<String> options) throws SQLException{
        String tempHotelTableName = "tempHotel";

        String queryTemplate = String.format("DROP TABLE IF EXISTS %s", tempHotelTableName);
        con.createStatement().executeUpdate(queryTemplate);
        queryTemplate = String.format("CREATE TEMPORARY TABLE %s AS (\n" +
                "SELECT RoomTable.*,\n" +
                "HotelTable.*\n" +
                "FROM Room RoomTable, Hotel HotelTable\n" +
                "LEFT JOIN City CityTable ON CityTable.CityID = HotelTable.CityID\n" +
                "WHERE CityTable.CityName = '%s' );", tempHotelTableName, options.get(0));
        con.createStatement().executeUpdate(queryTemplate);
        queryTemplate = String.format(
                "SELECT distinct tempHotelTable.HotelID,\n" +
                        "    tempHotelTable.HotelName,\n" +
                        "    tempHotelTable.Address,\n" +
                        "    tempHotelTable.RoomID,\n" +
                        "    RTTable.RoomTypeName,\n" +
                        "    RTTable.Price\n" +
                        "FROM %s tempHotelTable\n" +
                        "    LEFT JOIN roombooking RBTable ON RBTable.HotelID = tempHotelTable.HotelID AND RBTable.RoomID = tempHotelTable.RoomID\n" +
                        "        AND ((CheckIn > %s AND CheckOut < %s)\n" +
                        "        OR (CheckIn < %s AND CheckOut > %s)\n" +
                        "        OR (CheckIn > %s AND CheckIn < %s)\n" +
                        "        OR (CheckOut > %s AND CheckOut < %s))\n" +
                        "    LEFT JOIN roomtype RTTable ON RTTable.RoomTypeID = tempHotelTable.TypeID\n" +
                        "WHERE\n" +
                        "    RBTable.HotelID IS NULL\n" +
                        "    AND RBTable.RoomID IS NULL\n" +
                        "    %s \n %s",
                tempHotelTableName,
                options.get(1), options.get(1), options.get(1), options.get(1),
                options.get(2), options.get(2), options.get(2), options.get(2),
                formQuery(options), "ORDER BY RTTable.Price");
        PreparedStatement ps = con.prepareStatement(queryTemplate);
        ResultSet rs = ps.executeQuery();
        List<Result> results = new ArrayList<Result>();


        while (rs.next())
            results.add(ResultDAO.getResultFormRS(rs));
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
        return res + "\n";
    }

    public void insertBooking(WishfulRoomData wishfulRoomData) throws SQLException{
        String queryTemplate = String.format(
                "INSERT INTO roombooking(HotelID, RoomID, CheckIn, CheckOut)\n" +
                "VALUES (%s, %s, %s, %s)",
                wishfulRoomData.getHotelID(),
                wishfulRoomData.getRoomID(),
                wishfulRoomData.getCheckInDate(),
                wishfulRoomData.getCheckOutDate());
        PreparedStatement ps = con.prepareStatement(queryTemplate);
        ps.executeUpdate();
        ps.close();
    }
}