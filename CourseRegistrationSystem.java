package myCoursesSystem;

import java.util.ArrayList;
import java.util.List;

public class CourseRegistrationSystem implements CourseRegistrationFacade {

    private static final int MAX_ACTIVE_USERS = 100;
    private static int activeUserCount = 0;

    private static CourseRegistrationSystem instance;
    private UserFactory userFactory;
    private CourseFactory courseFactory;
    private List<User> activeUsers;

    private CourseRegistrationSystem() {
    	this.userFactory = new UserFactory();
        this.courseFactory = new CourseFactory();
        this.activeUsers = new ArrayList<>();
    }

    public static synchronized CourseRegistrationSystem getInstance() {
        if (instance == null) {
            instance = new CourseRegistrationSystem();
        }
        return instance;
    }

    @Override
    public User login(String userType, String name, int id) {
        if (activeUserCount >= MAX_ACTIVE_USERS) {
            return null;
        }

        User user = userFactory.getUser(userType, name, id);
        if (user != null) {
            activeUsers.add(user);
            activeUserCount++;
            System.out.println(user.getName() + " logged in");
        }
        return user;
    }

    @Override
    public void logout(User user) {
        if (activeUsers.remove(user)) {
            activeUserCount--;
            System.out.println(user.getName() + " logged out");
        }
    }

    @Override
    public void registerStudentForCourse(User student, Course course) {
        ((Student) student).registerToCourse(course);
    }

    @Override
    public Course createCourse(User user, String name, int courseId, CourseType type, int maxStudents) {
        if (user instanceof Lecturer) {
            Course newCourse = ((Lecturer) user).createCourse(name, courseId, type, maxStudents);
            if (newCourse != null) {
                System.out.println("Course '" + newCourse.getName() + "' has been created successfully.");
                return newCourse;
            } else {
                System.out.println("Failed to create course. Invalid parameters.");
            }
        } else if (user instanceof Practitioner) {
            Course newCourse = ((Practitioner) user).createCourse(name, courseId, type, maxStudents);
            if (newCourse != null) {
                System.out.println("Course '" + newCourse.getName() + "' has been created successfully.");
                return newCourse;
            } else {
                System.out.println("Failed to create course. Invalid parameters.");
            }
        } else {
            System.out.println("User is not authorized to create a course.");
        }
        return null;
    }


    @Override
    public void unregisterStudentFromCourse(User student, Course course) {
        ((Student) student).unregisterFromCourse(course);
    }
}
