package kz.edu.astanait.models;

import java.util.Date;

public class News extends Post {
    private Date date;

    public News(String name, String image, String description, String author, Date date) {
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
