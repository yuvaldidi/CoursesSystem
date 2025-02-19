package myCoursesSystem;

public class ElectiveCourse implements CourseIntr {
    @Override
    public Course createCourse(String name, int courseId, CourseType type, int maxStudents) {
        if (type == CourseType.ELECTIVE) {
            return new Course(name, courseId, type, maxStudents);
        } else {
            throw new IllegalArgumentException("Invalid course type for ElectiveCourseFactory");
        }
    }
}
