package myCoursesSystem;

class Student extends User implements CourseObserver {
    public Student(String name, int id) {
        super(name, id, UserType.STUDENT);
    }

    @Override
    public void update(Course course) {
        System.out.println(getName() + ": A spot is available in course " + course.getName() + " " + course.getCourseId());
    }
    
    public void unregisterFromCourse(Course course) {
        course.unregisterStudent(this);
    }
    public void registerToCourse(Course course) {
        course.enrollStudent(this);
    }
}

