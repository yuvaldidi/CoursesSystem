package myCoursesSystem;

public class Main {
    public static void main(String[] args) {
        // Create factories
       

        // Create system instance
        CourseRegistrationSystem registrationSystem = CourseRegistrationSystem.getInstance();

        // Login users
        User lecturer = registrationSystem.login("LECTURER", "Dr. Smith", 101);
        User student1 = registrationSystem.login("STUDENT", "John Doe", 201);
        User student2 = registrationSystem.login("STUDENT", "Alice", 202);
        User practitioner = registrationSystem.login("PRACTITIONER", "Bob", 301);

     // Create new courses
        Course course1 = registrationSystem.createCourse(lecturer, "Advanced Programming", 301, CourseType.ELECTIVE, 30);
        Course course2 = registrationSystem.createCourse(practitioner, "Software Engineering", 201, CourseType.MANDATORY, 50);

        // Register students for courses
        registrationSystem.registerStudentForCourse(student1, course1);
        registrationSystem.registerStudentForCourse(student2, course2);
        // Unregister students from courses
        registrationSystem.unregisterStudentFromCourse(student1, course1);
    }
}
