package kz.edu.astanait.models;

import java.sql.Date;

public class Post {
    private int id;
    private String name;
    private String image;
    private String description;
    private String author;
    private Date date;

    public Post(String name, String image, String description, String author, Date date){
        setName(name);
        setImage(image);
        setDescription(description);
        setAuthor(author);
        setDate(date);
    }

    public Post(int id,String name, String image, String description, String author, Date date){
        setId(id);
        setName(name);
        setImage(image);
        setDescription(description);
        setAuthor(author);
        setDate(date);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
