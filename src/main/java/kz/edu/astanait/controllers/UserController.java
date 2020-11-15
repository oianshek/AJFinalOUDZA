package kz.edu.astanait.controllers;

import kz.edu.astanait.DB;
import kz.edu.astanait.controllers.interfaces.IController;
import kz.edu.astanait.models.User;

import javax.ws.rs.BadRequestException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserController implements IController<User> {

    @Override
    public void add(User entity) throws BadRequestException {
    }

    @Override
    public void update(User entity) throws BadRequestException {

    }

    @Override
    public void delete(int id) throws BadRequestException {

    }

    @Override
    public List getAll() throws BadRequestException {
        return null;
    }

    public User check(String email, String password) throws SQLException {
        String sql = "SELECT * FROM users WHERE email = ? AND password = ?";

        PreparedStatement stmt = DB.getConnection().prepareStatement(sql);
        stmt.setString(1,email);
        stmt.setString(2,password);

        ResultSet rs = stmt.executeQuery();
        User user = null;

        if(rs.next()){
            user = new User();
            user.setId(rs.getInt("id"));
            user.setFirstName(rs.getString("fname"));
            user.setLastName(rs.getString("lname"));
            user.setGroupName(rs.getString("group_name"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
            user.setCourse(rs.getInt("course"));
        }
        return user;
    }

    public User getById(int id) {
        String sql = "SELECT * FROM users WHERE id = ?";

        try {
            //Statement stmt = db.getConnection().createStatement();
            PreparedStatement pstmt = DB.getConnection().prepareStatement(sql);
            //ResultSet rs = stmt.executeQuery(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setFirstName(rs.getString("fname"));
                user.setLastName(rs.getString("lname"));
                user.setGroupName(rs.getString("group_name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setCourse(rs.getInt("course"));
                return user;

            }
        } catch (SQLException ex) {
            throw new BadRequestException("Cannot run SQL statement: " + ex.getMessage());
        }
        return null;
    }

}
