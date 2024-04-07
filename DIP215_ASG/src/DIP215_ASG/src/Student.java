package DIP215_ASG.src;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class Student {
    private String studentID;
    private String studentName;
    private String studentType;
    private int totalCreditHours;
    private List<Course> coursesEnrolled;

    public List<Course> getCoursesEnrolled() {
        return new ArrayList<>(coursesEnrolled);
    }
    private Map<Course, Double> courseGrades; // Map to keep track of grades for courses

    public Student(String studentID, String studentName, String studentType, int totalCreditHours) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentType = studentType;
        this.totalCreditHours = totalCreditHours;
        this.coursesEnrolled = new ArrayList<>();
        this.courseGrades = new HashMap<>(); // Initialize the grades map
    }

    public String getStudentId() {
        return studentID;
    }

    public void setStudentId(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentType() {
        return studentType;
    }

    public void setStudentType(String studentType) {
        this.studentType = studentType;
    }

    public int getTotalCreditHours() {
        return totalCreditHours;
    }

    public void setTotalCreditHours(int totalCreditHours) {
        this.totalCreditHours = totalCreditHours;
    }

    public void enrollCourse(Course course) {
        coursesEnrolled.add(course);
        totalCreditHours += course.getCreditHours(); // Update credit hours when enrolling in a course
        courseGrades.put(course, null); // Initialize the grade for this course as null
    }

    public void dropCourse(Course course) {
        if (coursesEnrolled.remove(course)) {
            totalCreditHours -= course.getCreditHours(); // Update credit hours when dropping a course
            courseGrades.remove(course); // Remove the grade entry for this course
        }
    }

    public void setGrade(Course course, double grade) {
        if(coursesEnrolled.contains(course)) {
            courseGrades.put(course, grade); // Set the grade for the course
        } else {
            System.out.println("Student not enrolled in course: " + course.getCourseName());
        }
    }

    public Double getGrade(Course course) {
        return courseGrades.get(course); // Get the grade for the course
    }


    @Override
    public String toString() {
        return "\nStudent ID: " + studentID +
                "\nStudent Name: " + studentName +
                "\nStudent Type: " + studentType +
                "\nTotal Credit Hours: " + totalCreditHours ;

    }
}
