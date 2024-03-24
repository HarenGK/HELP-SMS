package DIP215_ASG.src;
import java.util.ArrayList;

public class Course {
    private String courseId;
    private String courseName;
    private int creditHours;
    private ArrayList<String> courseSchedule; // ArrayList to store course schedule

    // Constructor
    public Course(String courseId, String courseName, int creditHours) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.creditHours = creditHours;
        this.courseSchedule = new ArrayList<>(); // Initialize the ArrayList
    }

    // Getter methods
    public String getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public ArrayList<String> getCourseSchedule() {
        return courseSchedule;
    }

    // Setter methods
    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setCreditHours(int creditHours) {
        this.creditHours = creditHours;
    }

    // Method to add a schedule to the course
    public void addSchedule(String schedule) {
        courseSchedule.add(schedule);
    }
}
