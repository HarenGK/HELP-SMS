package DIP215_ASG.src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Course {
    private String courseId;
    private String courseName;
    private double creditHours;
    private List<String> courseSchedule; // Use List for type flexibility
    private List<Student> enrolledStudents = new ArrayList<>();
    public List<Student> getStudentsEnrolled() {
        return new ArrayList<>(enrolledStudents);
    }
    private Map<Student, List<Boolean>> attendanceRecords; // Maps each student to their attendance record
    private Map<Student, Double> grades = new HashMap<>();

    public Course(String courseId, String courseName, double creditHours) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.creditHours = creditHours;
        this.courseSchedule = new ArrayList<>(); // Initialize the ArrayList
        this.attendanceRecords = new HashMap<>(); // Initialize the HashMap
        this.grades = new HashMap<>(); // Initialize the grades map
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

    public double getCreditHours() {
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

    public void displayAttendanceRecords() {
        System.out.println("Attendance Records:");
        attendanceRecords.forEach((student, attendanceList) -> {
            System.out.println("Student ID: " + student.getStudentId() + " - " + student.getStudentName());
            for (Boolean present : attendanceList) {
                System.out.println("\t" + (present ? "Present" : "Absent"));
            }
        });
    }

    public void enrollStudent(Student student) {
        if (!enrolledStudents.contains(student)) {
            enrolledStudents.add(student);
            // Also initialize the attendance and grade records for the new student
            attendanceRecords.put(student, new ArrayList<>());
            grades.put(student, null); // Initialize with no grade
        }
    }

    // Method to drop a student from the course
    public void dropStudent(Student student) {
        if (enrolledStudents.remove(student)) {
            // Remove the student's attendance and grade records
            attendanceRecords.remove(student);
            grades.remove(student);
        }
    }


    public void setGrade(Student student, Double grade) {
        if (!enrolledStudents.contains(student)) {
            System.out.println("Student is not enrolled in this course.");
            return;
        }
        grades.put(student, grade);
    }


    // Method to get a grade for a student
    public Double getGrade(Student student) {
        return grades.get(student); // Returns null if the student does not have a grade
    }

    // Method to display all grades for the course
    public void displayGrades() {
        System.out.println("Grades for Course: " + courseName);
        grades.forEach((student, grade) -> System.out.println(student.getStudentName() + ": " + grade));
    }
}