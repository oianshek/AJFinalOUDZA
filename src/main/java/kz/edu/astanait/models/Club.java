package kz.edu.astanait.models;

import java.sql.Date;

public class Club extends Post{

    public Club(String name, String image, String description, String author, Date date) {
        super(name, image, description, author, date);
    }

    public Club(int id, String name, String image, String description, String author, Date date) {
        super(id, name, image, description, author, date);
    }
}
