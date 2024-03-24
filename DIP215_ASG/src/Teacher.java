
import java.util.ArrayList;
import java.util.List;

public class Teacher {
    private String teacherId;
    private String teacherName;
    private List<Course> coursesTaught;
    private String teacherQualifications;
    private List<Course> teacherAssignedCourses;

    public Teacher(String teacherId, String teacherName, String teacherQualifications) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.teacherQualifications = teacherQualifications;
        this.coursesTaught = new ArrayList<>();
        this.teacherAssignedCourses = new ArrayList<>();
    }

    public void getGrade() {
        // Placeholder for the method implementation
    }

    public List<Course> getCourses() {
        return coursesTaught;
    }

    public void setCourse(Course course) {
        this.coursesTaught.add(course);
    }

    public void getTeacherInfo() {
        // Printing teacher's information to the console
        System.out.println("Teacher ID: " + teacherId);
        System.out.println("Teacher Name: " + teacherName);
        System.out.println("Qualifications: " + teacherQualifications);
        System.out.println("Courses Assigned:");
        for (Course course : teacherAssignedCourses) {
            System.out.println("- " );
        }
    }
    public String getTeacherQualifications() {
        return teacherQualifications;
    }

    public void setTeacherQualifications(String qualifications) {
        this.teacherQualifications = qualifications;
    }

    // Getters and setters for all other fields

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

    public List<Course> getTeacherAssignedCourses() {
        return teacherAssignedCourses;
    }

    public void setTeacherAssignedCourses(List<Course> teacherAssignedCourses) {
        this.teacherAssignedCourses = teacherAssignedCourses;
    }

    // Additional methods to manipulate coursesTaught and teacherAssignedCourses
}
