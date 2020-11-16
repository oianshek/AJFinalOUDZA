package kz.edu.astanait.models;

public class News extends Post {

    public News(){
        super();
    }

    public News(String name, String image, String description, String author, String date) {
        super(name, image, description, author, date);
    }

    public News(int id, String name, String image, String description, String author, String date) {
        super(id, name, image, description, author, date);
    }
}
