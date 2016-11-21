package ru.hotelinno.Search;

import ru.hotelinno.Search.JDBC.ConnectionPool;
import ru.hotelinno.domain.RESULT.*;
import ru.hotelinno.domain.WishfulRoomData;
import ru.hotelinno.domain.roombooking.*;

import java.sql.*;
import java.util.*;


public class Searcher {
    private Connection con;
    private ConnectionPool pool = new ConnectionPool();
    public Searcher(){
        pool = new ConnectionPool();
        pool.initConnectionPool("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/hotelinno", "hoteluser", "123123");
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
//        PreparedStatement ps = con.prepareStatement("SELECT tempHotelTable.HotelID, tempHotelTable.HotelName, tempHotelTable.Address, " +
//                "tempHotelTable.RoomID, RTTable.RoomTypeName, RTTable.Price " +
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
//        int i = 0;
//        String delimiter = "019";
//        String hr;
//        Result result;
        while (rs.next()){
            results.add(ResultDAO.getResultFormRS(rs));
//            result = results.get(i);
//            result.setCheckInDate(options.get(1));
//            result.setCheckOutDate(options.get(2));
//            hr = result.getHotelID() + delimiter
//                    + result.getRoomID() + delimiter
//                    + options.get(1) + delimiter
//                    + options.get(2);
////            result.setHrID(hr);
//            result.setHrID("22");
//            i++;
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
        return res + "\n";
    }

    //    public void insertBooking(Roombooking rb, String checkIn, String checkOut) throws SQLException{
    public void insertBooking(WishfulRoomData wishfulRoomData) throws SQLException{
        String queryTemplate = String.format(
                "INSERT INTO roombooking(HotelID, RoomID, CheckIn, CheckOut)\n" +
                "VALUES (%s, %s, %s, %s)",
                wishfulRoomData.getHotelID(),
                wishfulRoomData.getRoomID(),
                wishfulRoomData.getCheckInDate(),
                wishfulRoomData.getCheckOutDate());
        PreparedStatement ps = con.prepareStatement(queryTemplate);
//        ps.setInt(1, Integer.parseInt(wishfulRoomData.getHotelID()));
//        ps.setInt(2, Integer.parseInt(wishfulRoomData.getRoomID()));
//        ps.setInt(1, wishfulRoomData.getHotelID());
//        ps.setInt(2, wishfulRoomData.getRoomID());
//        ps.setString(3, wishfulRoomData.getCheckInDate());
//        ps.setString(4, wishfulRoomData.getCheckOutDate());
        ps.executeUpdate();
        ps.close();
    }
}