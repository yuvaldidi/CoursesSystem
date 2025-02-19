package myCoursesSystem;

import java.util.HashMap;
import java.util.Map;

public class CourseFactory {
    private Map<String, Course> courseRegistry;

    public CourseFactory() {
        this.courseRegistry = new HashMap<>();
    }

    public Course createCourse(UserType userType, String name, int courseId, CourseType type, int maxStudents) {
        if (userType != UserType.LECTURER && userType != UserType.PRACTITIONER) {
            return null; 
        }

        String key = name + "_" + courseId + "_" + type;

        if (courseRegistry.containsKey(key)) {
            return courseRegistry.get(key); 
        }

        Course course;
        switch (type) {
            case ELECTIVE:
                course = new Course(name, courseId, type, maxStudents);
                break;
            case MANDATORY:
                course = new Course(name, courseId, type, maxStudents);
                break;
            case SEMINAR:
                course = new Course(name, courseId, type, maxStudents);
                break;
            default:
                throw new IllegalArgumentException("Invalid course type: " + type);
        }

        courseRegistry.put(key, course);
        return course;
    }
}
