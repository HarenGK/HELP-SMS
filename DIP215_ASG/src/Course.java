package DIP215_ASG.src;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String courseId;
    private String courseName;
    private int creditHours;
    private List<String> courseSchedule; // Use List for type flexibility

    public Course(String courseId, String courseName, int creditHours) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.creditHours = creditHours;
        this.courseSchedule = new ArrayList<>(); // Initialize the ArrayList
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public void setCreditHours(int creditHours) {
        this.creditHours = creditHours;
    }

    public List<String> getCourseSchedule() {
        return new ArrayList<>(courseSchedule); // Return a copy of the courseSchedule list
    }

    public void addSchedule(String schedule) {
        courseSchedule.add(schedule);
    }

    public void displayCourseInfo() {
        System.out.println("Course ID: " + courseId);
        System.out.println("Course Name: " + courseName);
        System.out.println("Course Credit Hours: " + creditHours);
        System.out.println("Course Schedule: ");
        for (String schedule : courseSchedule) {
            System.out.println(schedule);
        }
    }
}
