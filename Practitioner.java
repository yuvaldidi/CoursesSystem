package myCoursesSystem;

class Practitioner extends User {
    public Practitioner(String name, int id) {
        super(name, id, UserType.PRACTITIONER);
    }

    public Course createCourse(String name, int courseId, CourseType type,int maxStudents) {
        CourseFactory courseFactory = new CourseFactory();
        return courseFactory.createCourse(this.getUserType(), name, courseId, type, maxStudents);
    }
}
