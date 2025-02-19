package myCoursesSystem;

class Lecturer extends User {
    public Lecturer(String name, int id) {
        super(name, id, UserType.LECTURER);
    }

    public Course createCourse(String name, int courseId, CourseType type,int maxStudents) {
        CourseFactory courseFactory = new CourseFactory();
        return courseFactory.createCourse(this.getUserType(), name, courseId, type, maxStudents);
    }
}