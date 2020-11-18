package kz.edu.astanait.models;

public class Event extends Post {

    public Event(){
        super();
    }

    public Event(String name, String image, String description, String author, String date) {
        super(name, image, description, author, date);
    }

    public Event(int id, String name, String image, String description, String author, String date) {
        super(id, name, image, description, author, date);
    }
}

