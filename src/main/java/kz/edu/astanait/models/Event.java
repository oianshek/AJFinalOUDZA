package kz.edu.astanait.models;

import java.sql.Date;

public class Event extends Post {
    private Date date;

    public Event(String name, String image, String description, String author, Date date) {
        super(name, image, description, author);
        setDate(date);
    }

    public Event(int id, String name, String image, String description,String author,Date date) {
        super(id,name,image,description,author);
        setDate(date);
    }


    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }
}
