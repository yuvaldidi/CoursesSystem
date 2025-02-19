package myCoursesSystem;

public interface CourseRegistrationFacade {

    User login(String userType, String name, int id);

    void logout(User user);

    void registerStudentForCourse(User student, Course course);

    Course createCourse(User user, String name, int courseId, CourseType type, int maxStudents);

    void unregisterStudentFromCourse(User student, Course course);
}
