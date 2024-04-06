package DIP215_ASG.src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Course {
    private String courseId;
    private String courseName;
    private int creditHours;
    private List<String> courseSchedule; // Use List for type flexibility
    private Map<Student, List<Boolean>> attendanceRecords; // Maps each student to their attendance record

    public Course(String courseId, String courseName, int creditHours) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.creditHours = creditHours;
        this.courseSchedule = new ArrayList<>(); // Initialize the ArrayList
        this.attendanceRecords = new HashMap<>(); // Initialize the HashMap
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
        displayAttendanceRecords();
    }

    public void recordAttendance(Student student, boolean isPresent) {
        List<Boolean> attendanceList = attendanceRecords.getOrDefault(student, new ArrayList<>());
        attendanceList.add(isPresent);
        attendanceRecords.put(student, attendanceList);
    }

    private void displayAttendanceRecords() {
        System.out.println("Attendance Records:");
        attendanceRecords.forEach((student, attendanceList) -> {
            System.out.println("Student ID: " + student.getStudentId() + " - " + student.getStudentName());
            for (Boolean present : attendanceList) {
                System.out.println("\t" + (present ? "Present" : "Absent"));
            }
        });
    }
}
