package kz.edu.astanait.controllers;

import kz.edu.astanait.DB;
import kz.edu.astanait.controllers.interfaces.IController;
import kz.edu.astanait.controllers.interfaces.IUserController;
import kz.edu.astanait.models.News;
import kz.edu.astanait.models.User;

import javax.ws.rs.BadRequestException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserController implements IUserController<User> {

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

    @Override
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

    @Override
    public List<User> getByGroup(String group) throws BadRequestException {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users WHERE group_name LIKE ? AND id != 1";
        try {
            PreparedStatement pstmt = DB.getConnection().prepareStatement(sql);
            //ResultSet rs = stmt.executeQuery(sql);
            pstmt.setString(1, "%" + group + "%");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()){
                users.add(new User(
                        rs.getInt("id"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("fname"),
                        rs.getString("lname"),
                        rs.getString("group_name"),
                        rs.getInt("course")
                ));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return users;
    }

    @Override
    public List<User> getByCourse(int c) throws BadRequestException {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users WHERE course LIKE ? AND id != 1";
        try {
            PreparedStatement pstmt = DB.getConnection().prepareStatement(sql);
            //ResultSet rs = stmt.executeQuery(sql);
            pstmt.setString(1, "%" + c + "%");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()){
                users.add(new User(
                        rs.getInt("id"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("fname"),
                        rs.getString("lname"),
                        rs.getString("group_name"),
                        rs.getInt("course")
                ));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return users;
    }

    @Override
    public List<User> getByMajor(String m) throws BadRequestException {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users WHERE group_name LIKE ? AND id != 1";
        try {
            PreparedStatement pstmt = DB.getConnection().prepareStatement(sql);
            //ResultSet rs = stmt.executeQuery(sql);
            pstmt.setString(1, "%" + m + "%");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()){
                users.add(new User(
                        rs.getInt("id"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("fname"),
                        rs.getString("lname"),
                        rs.getString("group_name"),
                        rs.getInt("course")
                ));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return users;
    }

    @Override
    public List getAll() throws BadRequestException {
        List<User> users = new ArrayList<>();

        try {
            Statement stmt = DB.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE id != 1");

            while (rs.next()){
                users.add(new User(
                        rs.getInt("id"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("fname"),
                        rs.getString("lname"),
                        rs.getString("group_name"),
                        rs.getInt("course")
                ));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return users;
    }

}
