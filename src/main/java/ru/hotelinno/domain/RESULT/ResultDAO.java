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
        String hr = "";
        hr +=  rs.getInt("HotelID")+ rs.getInt("RoomID");
        result.setHrID(hr);
        return result;
    }
}
