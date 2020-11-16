package kz.edu.astanait.models;

public class Club extends Post{

    public Club(){
        super();
    }

    public Club(String name, String image, String description, String author, String date) {
        super(name, image, description, author, date);
    }

    public Club(int id, String name, String image, String description, String author, String date) {
        super(id, name, image, description, author, date);
    }
}
