package myCoursesSystem;

import java.util.HashMap;
import java.util.Map;

public class UserFactory {
    private static final Map<String, User> userCache = new HashMap<>();

    public User getUser(String userType, String name, int id) {
        UserType type = UserType.valueOf(userType.toUpperCase());
        String key = type.toString() + "_" + name + "_" + id;

        if (userCache.containsKey(key)) {
            return userCache.get(key);
        }

        User newUser;
        switch (type) {
            case STUDENT:
                newUser = new Student(name, id);
                break;
            case PRACTITIONER:
                newUser = new Practitioner(name, id);
                break;
            case LECTURER:
                newUser = new Lecturer(name, id);
                break;
            default:
                throw new IllegalArgumentException("Invalid user type: " + userType);
        }

        userCache.put(key, newUser);
        return newUser;
    }
}
