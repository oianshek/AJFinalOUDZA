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

public class ClubController implements IController<Club> {

    @Override
    public void add(Club entity) throws BadRequestException {
        String sql = "INSERT INTO club(name, image, description, author) "+
                "VALUES(?,?,?,?)";

        try {
            PreparedStatement stmt = DB.getConnection().prepareStatement(sql);

            stmt.setString(1, entity.getName());
            stmt.setString(2, entity.getImage());
            stmt.setString(3, entity.getDescription());
            stmt.setString(4, entity.getAuthor());

            stmt.execute();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    @Override
    public void update(Club entity) throws BadRequestException {
        String sql = "update club set name = ?, image = ?, description = ?, author = ? where id = ?";
        PreparedStatement stmt = null;
        try {

            stmt = DB.getConnection().prepareStatement(sql);

            stmt.setString(1, entity.getName());
            stmt.setString(2, entity.getImage());
            stmt.setString(3, entity.getDescription());
            stmt.setString(4, entity.getAuthor());
            stmt.setInt(5, entity.getId());

            stmt.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void delete(Club entity) throws BadRequestException {
        String sql = "DELETE from club WHERE id = ?";

        try {
            PreparedStatement stmt = DB.getConnection().prepareStatement(sql);

            stmt.setInt(1,entity.getId());
            stmt.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List getAll() throws BadRequestException {
        List<Club> clubs = new ArrayList<>();

        try {
            Statement stmt = DB.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM club");

            while (rs.next()){
                clubs.add(new Club(
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
        return clubs;
    }

}
