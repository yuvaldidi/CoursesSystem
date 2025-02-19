package myCoursesSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Course {
    private String name;
    private int courseId;
    private CourseType type;
    private int maxStudents;
    private List<Student> enrolledStudents;
    private List<CourseObserver> waitingList;

    public Course(String name, int courseId, CourseType type, int maxStudents) {
        this.name = name;
        this.courseId = courseId;
        this.type = type;
        this.maxStudents = maxStudents;
        this.enrolledStudents = new ArrayList<>();
        this.waitingList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCourseId() {
        return courseId;
    }

    public CourseType getType() {
        return type;
    }

    public int getMaxStudents() {
        return maxStudents;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public void setType(CourseType type) {
        this.type = type;
    }

    public void setMaxStudents(int maxStudents) {
        this.maxStudents = maxStudents;
    }


    public void enrollStudent(Student student) {
        if (enrolledStudents.size() < maxStudents) {
            enrolledStudents.add(student);
            System.out.println(student.getName() + " enrolled in course " + name + " " + courseId);
        } else {
        	Scanner scanner = new Scanner(System.in);
        	System.out.println("Do you want to be notified when a place becomes available in this course? ");
        	String answer = scanner.nextLine();
        	if(answer.equals("yes")||answer.equals("Yes")) {
	            waitingList.add(student);
	            System.out.println(student.getName() + " added to waiting list for course " + name + " " + courseId);
	        }
        }
    }

    public void notifyObservers() {
        for (CourseObserver student : waitingList) {
            student.update(this); 
        }
    }

    public void unregisterStudent(Student student) {
        if (enrolledStudents.remove(student)) {
            System.out.println(student.getName() + " unregistered from course " + name + " " + courseId);
            if (!waitingList.isEmpty()) {
                notifyObservers();
            }
        } else {
            System.out.println(student.getName() + " is not enrolled in course " + name + " " + courseId);
        }
    }
}


