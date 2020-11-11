package kz.edu.astanait.controllers;

import kz.edu.astanait.DB;
import kz.edu.astanait.controllers.interfaces.IUserController;
import kz.edu.astanait.models.User;

import javax.ws.rs.BadRequestException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserController implements IUserController {

    @Override
    public void add(User entity) throws BadRequestException {
    }

    @Override
    public void update(User entity) throws BadRequestException {

    }

    @Override
    public void delete(String id) throws BadRequestException {

    }

    @Override
    public List<User> getAll() throws BadRequestException {
        return null;
    }

    @Override
    public User check(String email, String password) throws SQLException {
        String sql = "SELECT * FROM users WHERE email = ? AND password = ?";

        PreparedStatement stmt = DB.getConnection().prepareStatement(sql);
        stmt.setString(1,email);
        stmt.setString(2,password);

        ResultSet rs = stmt.executeQuery();
        User user = null;

        if(rs.next()){
            user = new User();
            user.setFirstName(rs.getString("fname"));
            user.setLastName(rs.getString("lname"));
            user.setGroupName(rs.getString("group_name"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
        }
        return user;
    }
}
