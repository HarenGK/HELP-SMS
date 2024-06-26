package DIP215_ASG.src;

import java.util.ArrayList;
import java.util.List;

public class Teacher {
    private String teacherId;
    private String teacherName;
    private String teacherEmail;
    private int teacherContactNo;
    private List<Course> coursesTaught;
    private String teacherQualifications;


    // Constructor
    public Teacher(String teacherId, String teacherName, String teacherEmail, int teacherContactNo, String teacherQualifications) {
        // Initialize teacher with ID, name, email, contact number, and qualifications
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.teacherEmail = teacherEmail;
        this.teacherContactNo = teacherContactNo;
        this.teacherQualifications = teacherQualifications;
        // Set up an empty list for courses that the teacher will teach
        this.coursesTaught = new ArrayList<>();
    }

    // Method to add a course to the teacher
    public void addCourse(Course course) {
        // Check if the course is already taught by the teacher
        if (this.coursesTaught.stream().noneMatch(c -> c.getCourseId().equals(course.getCourseId()))) {
            this.coursesTaught.add(course);
        } else {
            System.out.println("This course is already assigned to the teacher.");
        }
    }

    public void printTeacherInfo() {
        // Display the teacher's basic information
        System.out.println("Teacher ID: " + teacherId);
        System.out.println("Teacher Name: " + teacherName);
        System.out.println("Teacher Email: " + teacherEmail);
        System.out.println("Teacher Contact Number: " + teacherContactNo);
        System.out.println("Qualifications: " + teacherQualifications);
        System.out.println("Courses Assigned:");
        for (Course course : this.coursesTaught) { // Loop through the courses taught by the teacher and print the course name and number of students enrolled using getStudentsEnrolled() in the Course class
            List<Student> enrolledStudents = course.getStudentsEnrolled();
            System.out.println("- " + course.getCourseName() + ": " + enrolledStudents.size() + " students enrolled");
        }
    }

    // Getters and Setters for the Teacher class
    public String getTeacherQualifications() {
        return teacherQualifications;
    }

    public void setTeacherQualifications(String qualifications) {
        this.teacherQualifications = qualifications;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherEmail() {
        return teacherEmail;
    }

    public int getTeacherContactNo() {
        return teacherContactNo;
    }

    public void setTeacherContactNo(int teacherContactNo) {
        this.teacherContactNo = teacherContactNo;
    }

    public List<Course> getCoursesTaught() {
        return coursesTaught;
    }

    public void setCoursesTaught(List<Course> coursesTaught) {
        this.coursesTaught = new ArrayList<>(coursesTaught);
    }

    // Method to remove an assigned course to the teacher
    public void dropCourse(Course course) {
        if (this.coursesTaught.remove(course)) {
            System.out.println("Course removed successfully.");
        } else {
            System.out.println("Course not found.");
        }
    }

    // Overriding the toString() method
    @Override
    public String toString() {
        return "Teacher ID: " + teacherId +
                "\nTeacher Name: " + teacherName +
                "\nTeacher Email: " + teacherEmail +
                "\nTeacher Contact Number: " + teacherContactNo +
                "\nQualifications: " + teacherQualifications;
    }


}
