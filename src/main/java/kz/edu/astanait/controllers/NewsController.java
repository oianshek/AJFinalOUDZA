package kz.edu.astanait.controllers;

import kz.edu.astanait.DB;
import kz.edu.astanait.controllers.interfaces.IPostController;
import kz.edu.astanait.models.News;

import javax.ws.rs.BadRequestException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NewsController implements IPostController<News> {
    @Override
    public void add(News entity) throws BadRequestException {
        String sql = "INSERT INTO news(name, image, description, date, author)"+
                "VALUES(?,?,?,?,?)";

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
    public void update(News entity) throws BadRequestException {
        String sql = "UPDATE news SET name = ?, image = ?, description = ?" +
                " WHERE id = ?";

        try {
            PreparedStatement stmt = DB.getConnection().prepareStatement(sql);

            stmt.setString(1, entity.getName());
            stmt.setString(2, entity.getImage());
            stmt.setString(3, entity.getDescription());;
            stmt.setInt(4, entity.getId());

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
                        rs.getString("date")
                ));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return news;
    }

}
