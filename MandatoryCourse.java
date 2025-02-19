package myCoursesSystem;

public class MandatoryCourse implements CourseIntr {
    @Override
    public Course createCourse(String name, int courseId, CourseType type, int maxStudents) {
        if (type == CourseType.MANDATORY) {
            return new Course(name, courseId, type, maxStudents);
        } else {
            throw new IllegalArgumentException("Invalid course type for MandatoryCourseFactory");
        }
    }
}