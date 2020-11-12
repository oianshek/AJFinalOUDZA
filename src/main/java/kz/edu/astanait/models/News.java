package kz.edu.astanait.models;

import java.sql.Date;

public class News extends Post {

    public News(String name, String image, String description, String author, Date date) {
        super(name, image, description, author, date);
    }

    public News(int id, String name, String image, String description, String author, Date date) {
        super(id, name, image, description, author, date);
    }
}
