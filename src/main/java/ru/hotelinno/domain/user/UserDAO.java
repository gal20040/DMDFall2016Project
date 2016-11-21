package ru.hotelinno.domain.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    private final Connection con;

    public UserDAO(Connection con){
        this.con=con;
    }

    private User getUserFormRS(ResultSet rs) throws SQLException {
        User result = new User();

        result.setUserID(rs.getInt("UserID"));
        result.setFirstName(rs.getString("FirstName"));
        result.setLastName(rs.getString("LastName"));
        result.setPermissions(rs.getInt("Permissions"));
        result.setPassword(rs.getString("Password"));
        return result;
    }

    public User getUser(int id){
        User result = null;
        try{
            PreparedStatement ps =con.prepareStatement("SELECT * FROM user WHERE UserID=?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                result = getUserFormRS(rs);
            }
            ps.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    public List<User> getUser(){
        List<User> result = new ArrayList<User>();
        try{
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM user");
            while (rs.next()){
                result.add(getUserFormRS(rs));
            }
            rs.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    public void deleteUser(int id){
        try{
            PreparedStatement ps = con.prepareStatement("DELETE FROM user WHERE UserID=?");
            ps.setInt(1, id);
            ps.executeQuery();
        }
        catch (SQLException  e){
            e.printStackTrace();
        }
    }
}
