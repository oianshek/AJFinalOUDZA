package kz.edu.astanait.controllers;

import kz.edu.astanait.DB;
import kz.edu.astanait.controllers.interfaces.IController;
import kz.edu.astanait.models.Event;

import javax.ws.rs.BadRequestException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class EventController implements IController<Event> {

    @Override
    public void add(Event entity) throws BadRequestException {
        String sql = "INSERT INTO event(name, image, description, date, author)"+
                " VALUES(?,?,?,?,?)";

        try {
            PreparedStatement stmt = DB.getConnection().prepareStatement(sql);

            stmt.setString(1,entity.getName());
            stmt.setString(2,entity.getImage());
            stmt.setString(3,entity.getDescription());
            stmt.setString(4, entity.getDate());
            stmt.setString(5, entity.getAuthor());

            stmt.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void update(Event entity) throws BadRequestException {
        String sql = "UPDATE event SET name = ?, image = ?, description = ?, date = ?" +
                " WHERE id = ?";

        try {
            PreparedStatement stmt = DB.getConnection().prepareStatement(sql);

            stmt.setString(1, entity.getName());
            stmt.setString(2, entity.getImage());
            stmt.setString(3, entity.getDescription());
            stmt.setString(4, entity.getDate());
            stmt.setInt(5, entity.getId());

            stmt.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void delete(int id) throws BadRequestException {
        String sql = "DELETE from event WHERE id = ?";

        try {
            PreparedStatement stmt = DB.getConnection().prepareStatement(sql);

            stmt.setInt(1, id);
            stmt.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Event> getAll() throws BadRequestException {
        List<Event>events = new ArrayList<>();

        try {
            Statement stmt = DB.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM event");

            while (rs.next()){
                events.add(new Event(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("image"),
                        rs.getString("description"),
                        rs.getString("author"),
                        rs.getString("date")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return events;
    }

}
