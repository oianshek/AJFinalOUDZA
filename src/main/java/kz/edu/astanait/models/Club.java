package kz.edu.astanait.models;

public class Club extends Post {

    public Club(String name, String image, String description, String author) {
        super(name, image, description, author);
    }

    public Club(int id, String name, String image, String description, String author)
    {
        super(id, name, image, description, author);
    }
}
