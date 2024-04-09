package DIP215_ASG.src;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Student {
    private String studentID;
    private String studentName;
    private String studentType;
    private int totalCreditHours;
    private List<Course> coursesEnrolled; // List to keep track of courses enrolled

    public List<Course> getCoursesEnrolled() { // Getter method for coursesEnrolled
        return new ArrayList<>(coursesEnrolled);
    }
    private Map<Course, Double> courseGrades; // Map to keep track of grades for courses in pair (Course, Grade)

    public Student(String studentID, String studentName, String studentType, int totalCreditHours) { // Constructor
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentType = studentType;
        this.totalCreditHours = totalCreditHours;
        this.coursesEnrolled = new ArrayList<>();
        this.courseGrades = new HashMap<>(); // Initialize the grades map where vales are stored in pairs such as (Course, Grade)
    }

    // Getters and Setters for the Student class
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

    // Method to enroll in a course
    public void enrollCourse(Course course) {
        coursesEnrolled.add(course);
        totalCreditHours += course.getCreditHours(); // Update credit hours when enrolling in a course
        courseGrades.put(course, null); // Initialize the grade for this course as null
    }

    // Method to drop a course
    public void dropCourse(Course course) {
        if (coursesEnrolled.remove(course)) {
            totalCreditHours -= course.getCreditHours(); // Update credit hours when dropping a course
            // Ensure that totalCreditHours doesn't become negative
            if (totalCreditHours < 0) {
                totalCreditHours = 0;
            }
            courseGrades.remove(course); // Remove the grade entry for this course
        }
    }

    // Method to set the grade for a course
    public void setGrade(Course course, double grade) {
        if(coursesEnrolled.contains(course)) {
            courseGrades.put(course, grade); // Set the grade for the course
        } else {
            System.out.println("Student not enrolled in course: " + course.getCourseName());
        }
    }

    // Method to get the grade for a course
    public Double getGrade(Course course) {
        return courseGrades.get(course); // Gets the grade for the course
    }

    // Method to generate a transcript for a student
    // Helper method to convert grade to grade point
    private static double getGradePoint(double grade) {
        if (grade >= 85) return 4.00;
        else if (grade >= 80) return 3.75;
        else if (grade >= 75) return 3.50;
        else if (grade >= 70) return 3.25;
        else if (grade >= 65) return 3.00;
        else if (grade >= 60) return 2.75;
        else if (grade >= 55) return 2.50;
        else if (grade >= 50) return 2.00;
        else return 0.00;
    }

    // generateTranscript method to calculate and include CGPA
    public String generateTranscript() {
        StringBuilder transcript = new StringBuilder();
        transcript.append("Transcript for: ").append(getStudentName())
                .append(" (ID: ").append(getStudentId()).append(")\n")
                .append("------------------------------------------------------\n");

        double totalGradePoints = 0;
        int courseCount = 0;

        for (Course course : getCoursesEnrolled()) {
            Double grade = getGrade(course);
            double gradePoint = grade != null ? getGradePoint(grade) : 0;
            totalGradePoints += gradePoint;
            courseCount++;

            transcript.append(course.getCourseName())
                    .append(": Grade: ")
                    .append(grade != null ? grade : "N/A")
                    .append(" - Grade Point: ")
                    .append(gradePoint)
                    .append("\n");
        }

        double cgpa = courseCount > 0 ? totalGradePoints / courseCount : 0.00;
        transcript.append("------------------------------------------------------\n")
                .append("CGPA: ").append(String.format("%.2f", cgpa)).append("\n");

        return transcript.toString();
    }

    // Override the equals method to compare two Student objects based on studentID
    @Override // toString method to display student details that is overridden in subclasses (PartTimeStudent & FullTimeStudent)
    public String toString() {
        return "\nStudent ID: " + studentID +
                "\nStudent Name: " + studentName +
                "\nStudent Type: " + studentType +
                "\nTotal Credit Hours: " + totalCreditHours ;

    }
}
