package DIP215_ASG.src;

import java.util.ArrayList;
import java.util.List;

public class Teacher {
    private String teacherId;
    private String teacherName;
    private List<Course> coursesTaught;
    private String teacherQualifications;

    public Teacher(String teacherId, String teacherName, String teacherQualifications) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.teacherQualifications = teacherQualifications;
        this.coursesTaught = new ArrayList<>();
    }

    public void addCourse(Course course) {
        this.coursesTaught.add(course);
    }

    public void printTeacherInfo() {
        System.out.println("Teacher ID: " + teacherId);
        System.out.println("Teacher Name: " + teacherName);
        System.out.println("Qualifications: " + teacherQualifications);
        System.out.println("Courses Assigned:");
        for (Course course : coursesTaught) {
            System.out.println("- " + course.getCourseName());
        }
    }

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

    public List<Course> getCoursesTaught() {
        return coursesTaught;
    }

    public void setCoursesTaught(List<Course> coursesTaught) {
        this.coursesTaught = new ArrayList<>(coursesTaught);
    }
}
