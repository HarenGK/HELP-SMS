package DIP215_ASG.src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Student {
    private String studentID;
    private String studentName;
    private String studentType;
    private int totalCreditHours;
    private List<Course> coursesEnrolled;

    public Student(String studentID, String studentName, String studentType, int totalCreditHours) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentType = studentType;
        this.totalCreditHours = totalCreditHours;
        this.coursesEnrolled = new ArrayList<>();
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
        // Optionally update totalCreditHours here
    }

    public void dropCourse(Course course) {
        coursesEnrolled.remove(course);
        // Optionally update totalCreditHours here
    }

    public List<Course> getCoursesEnrolled() {
        return Collections.unmodifiableList(coursesEnrolled);
    }

    @Override
    public String toString(){
        return "\nStudent ID: " + studentID +
                "\nStudent Name: " + studentName +
                "\nStudent Type: " + studentType +
                "\nTotal Credit Hours: " + totalCreditHours +
                "\nCourses Enrolled: \n" + getCoursesEnrolled() + "\n";
    }
}
