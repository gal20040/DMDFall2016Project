package ru.hotelinno.domain.RESULT;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultDAO {

    static public Result getResultFormRS(ResultSet rs) throws SQLException{
        Result result = new Result();
        result.setHotelID(rs.getInt("HotelID"));
        result.setHotelName(rs.getString("HotelName"));
        result.setAddress(rs.getString("Address"));
        result.setRoomID(rs.getInt("RoomID"));
        result.setRoomType(rs.getString("RoomTypeName"));
        result.setPrice(rs.getInt("Price"));
//        result.setCheckInDate(rs.getString(2));
//        result.setCheckOutDate(rs.getString(3));

        String len = "" + ("" + rs.getInt("HotelID")).length();
        String hr = len + rs.getInt("HotelID") + rs.getInt("RoomID");

//        String delimiter = "0123456789";
//        String hr = rs.getInt("HotelID") + delimiter
//                + rs.getInt("RoomID") + delimiter
//                + rs.getString("CheckIn") + delimiter
//                + rs.getString("CheckOut");
        result.setHrID(hr);
        return result;
    }
}