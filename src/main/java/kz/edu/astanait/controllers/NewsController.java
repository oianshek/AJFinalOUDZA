package kz.edu.astanait.controllers;

import kz.edu.astanait.DB;
import kz.edu.astanait.controllers.interfaces.IController;
import kz.edu.astanait.models.News;

import javax.ws.rs.BadRequestException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class NewsController implements IController<News> {

    @Override
    public void add(News entity) throws BadRequestException {
        String sql = "INSERT INTO news(name, image, description, date, author)"+
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
    public void update(News entity) throws BadRequestException {
        String sql = "UPDATE news SET name = ?, image = ?, description = ?, date = ?, author = ?" +
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
    public void delete(int id) throws BadRequestException {
        String sql = "DELETE from news WHERE id = ?";

        try {
            PreparedStatement stmt = DB.getConnection().prepareStatement(sql);

            stmt.setInt(1, id);
            stmt.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<News> getAll() throws BadRequestException {
        List<News> news = new ArrayList<>();

        try {
            Statement stmt = DB.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM news");

            while (rs.next()){
                news.add(new News(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("image"),
                        rs.getString("description"),
                        rs.getString("author"),
                        rs.getDate("date")
                ));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return news;
    }

}
