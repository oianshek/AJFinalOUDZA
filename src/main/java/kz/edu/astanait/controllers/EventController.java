package kz.edu.astanait.controllers;

import kz.edu.astanait.DB;
import kz.edu.astanait.controllers.interfaces.IController;
import kz.edu.astanait.models.Club;
import kz.edu.astanait.models.Event;

import javax.ws.rs.BadRequestException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EventController implements IController<Event> {

    @Override
    public void add(Event entity) throws BadRequestException {
        String sql = "INSERT INTO events(name, image, description, date, author)"+
                "VALUES(?,?,?,?,?)";

        try {
            PreparedStatement stmt = DB.getConnection().prepareStatement(sql);

            stmt.setString(1,entity.getName());
            stmt.setString(2,entity.getImage());
            stmt.setString(3,entity.getDescription());
            stmt.setDate(4, entity.getDate());
            stmt.setString(5, entity.getAuthor());

            stmt.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void update(Event entity) throws BadRequestException {
        String sql = "UPDATE event SET name = ?, image = ?, description = ?, date = ?, author = ?" +
                " WHERE id = ?";

        try {
            PreparedStatement stmt = DB.getConnection().prepareStatement(sql);

            stmt.setString(1, entity.getName());
            stmt.setString(2, entity.getImage());
            stmt.setString(3, entity.getDescription());
            stmt.setDate(4, entity.getDate());
            stmt.setString(5, entity.getAuthor());
            stmt.setInt(6, entity.getId());

            stmt.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void delete(Event entity) throws BadRequestException {
        String sql = "DELETE from event WHERE id = ?";

        try {
            PreparedStatement stmt = DB.getConnection().prepareStatement(sql);

            stmt.setInt(1,entity.getId());
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
                        rs.getDate("date")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return events;
    }

}
