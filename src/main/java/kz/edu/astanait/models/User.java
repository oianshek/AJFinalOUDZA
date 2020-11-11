package kz.edu.astanait.models;

public class User {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String groupName;

    public User(String email, String password,String firstName, String lastName, String groupName) {
        setEmail(email);
        setPassword(password);
        setFirstName(firstName);
        setLastName(lastName);
        setGroupName(groupName);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public User() {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
