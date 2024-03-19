package DIP215_ASG.src;
import java.util.ArrayList;

public class Student {
    private String studentID;
    private String studentName;
    private String studentType;
    private int totalCreditHours;
    private ArrayList<Course> coursesEnrolled;

    public Student(String studentID, String studentName, String studentType, int totalCreditHours){
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentType = studentType;
        this.totalCreditHours = totalCreditHours;
    }

    public String getStudentId(){
        return studentID;
    }

    public String getStudentName(){
        return studentName;
    }

    public String getStudentType(){
        return studentType;
    }

    public int getCreditHours() {
        return totalCreditHours;
    }

    // Method to add a course to the enrolled courses list
    public void enrollCourse(Course course) {
        coursesEnrolled.add(course);
    }

    // Method to get the list of enrolled courses
    public ArrayList<Course> getCoursesEnrolled() {
        return coursesEnrolled;
    }
}
