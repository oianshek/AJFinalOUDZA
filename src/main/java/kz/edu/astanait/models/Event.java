package kz.edu.astanait.models;

import java.sql.Date;

public class Event extends Post {

    public Event(String name, String image, String description, String author, Date date) {
        super(name, image, description, author, date);
    }

    public Event(int id, String name, String image, String description, String author, Date date) {
        super(id, name, image, description, author, date);
    }
}

