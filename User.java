package myCoursesSystem;

public abstract class User {
    private String name;
    private int id;
    private UserType userType;

    public User(String name, int id, UserType userType) {
        this.name = name;
        this.id = id;
        this.userType = userType;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public UserType getUserType() {
        return userType;
    }
}
