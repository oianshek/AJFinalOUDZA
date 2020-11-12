package kz.edu.astanait.models;

import kz.edu.astanait.models.interfaces.Post;

import java.util.Date;

public class Event extends Post {
    private Date date;

    public Event(String name, String image, String description, String author, Date date) {
        super(name, image, description, author);
        setDate(date);
    }
    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }
}
