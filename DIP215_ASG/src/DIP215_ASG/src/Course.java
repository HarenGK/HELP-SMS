package DIP215_ASG.src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Course {
    // Instance variables that are set as private to ensure data encapsulation
    private String courseId; //The ID of the course
    private String courseName; //The name of the course
    private double creditHours; //Credit hours for a single course
    private String scheduleDate; // Date of the course
    private String scheduleTime; // Time of the course
    private int scheduleDuration; // Duration of the course
    private List<Student> enrolledStudents = new ArrayList<>(); // List of students enrolled in the course
    private Map<Student, List<Boolean>> attendanceRecords; // Maps each student to their attendance record
    private Map<Student, Double> grades = new HashMap<>(); // Maps each student to their grade

    // Constructor initializing course attributes
    public Course(String courseId, String courseName, double creditHours, String scheduleDate, String scheduleTime, int scheduleDuration) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.creditHours = creditHours;
        this.scheduleDate = scheduleDate;
        this.scheduleTime = scheduleTime;
        this.scheduleDuration = scheduleDuration;
        this.attendanceRecords = new HashMap<>(); // Initialize the HashMap for attendance records
        this.grades = new HashMap<>(); // Initialize the HashMap for grades
    }

    // Getters and setters for course attributes

    //Getter method to get course id
    public String getCourseId() {
        return courseId;
    }

    //Setter method to set course id
    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    //Getter method to get course name
    public String getCourseName() {
        return courseName;
    }

    //Setter method to set course name
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    //Getter method to get course credit hours
    public double getCreditHours() {
        return creditHours;
    }

    //Setter method to set course credit hours
    public void setCreditHours(int creditHours) {
        this.creditHours = creditHours;
    }

    //Getter method to get course schedule date
    public String getScheduleDate() {
        return scheduleDate;
    }

    //Setter method to set course schedule date
    public void setScheduleDate(String scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    //Getter method to get course scheduled time
    public String getScheduleTime() {
        return scheduleTime;
    }

    //Setter method to set course schedule time
    public void setScheduleTime(String scheduleTime) {
        this.scheduleTime = scheduleTime;
    }

    //Getter method to set course schedule duration
    public int getScheduleDuration() {
        return scheduleDuration;
    }

    //Setter method to set course schedule duration
    public void setScheduleDuration(int scheduleDuration) {
        this.scheduleDuration = scheduleDuration;
    }

    // Method to record attendance of a student
    public void recordAttendance(Student student, boolean isPresent) {
        List<Boolean> attendanceList = attendanceRecords.getOrDefault(student, new ArrayList<>());
        attendanceList.add(isPresent);
        attendanceRecords.put(student, attendanceList);
    }

    // Method to display attendance records of all students
    public void displayAttendanceRecords() {
        System.out.println("Attendance Records:");
        attendanceRecords.forEach((student, attendanceList) -> {
            System.out.format("%-30s - %-5s", "Student ID: " + student.getStudentId(), student.getStudentName());

            for (Boolean present : attendanceList) {
                System.out.format("%-10s%n", (present ? "Present" : "Absent"));
            }
        });
    }

    // Method to enroll a student in the course
    public void enrollStudent(Student student) {
        if (!enrolledStudents.contains(student)) {
            enrolledStudents.add(student);
            attendanceRecords.put(student, new ArrayList<>()); // Initialize attendance record for the student
            grades.put(student, null); // Initialize grade for the student
        }
    }

    // Method to drop a student from the course
    public void dropStudent(Student student) {
        if (enrolledStudents.remove(student)) {
            attendanceRecords.remove(student); // Remove attendance record
            grades.remove(student); // Remove grade record
        }
    }

    // Method to set grade for a student
    public void setGrade(Student student, Double grade) {
        if (!enrolledStudents.contains(student)) {
            System.out.println("Student is not enrolled in this course.");
            return;
        }
        grades.put(student, grade);
    }

    // Method to get grade for a student
    public Double getGrade(Student student) {
        return grades.get(student); // Returns null if the student does not have a grade
    }

    // Method to display all grades for the course
    public void displayGrades() {
        System.out.println("Grades for Course: " + courseName);
        grades.forEach((student, grade) -> System.out.println(student.getStudentName() + ": " + grade));
    }

    //Method to get the data of the students enrolled in the course
    public List<Student> getStudentsEnrolled() {
        return new ArrayList<>(enrolledStudents);
    }

    // Display course information using the toString Override method
    @Override
    public String toString() {
        return "Course ID: " + courseId +
                "\nCourse Name: " + courseName +
                "\nCredit Hours: " + creditHours +
                "\nCourse Date: " + scheduleDate +
                "\nCourse Time: " + scheduleTime +
                "\nCourse Duration: " + scheduleDuration + " hours" +"\n";
    }
}

