package DIP215_ASG.src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Student> students = new ArrayList<>();
    private static List<Course> courses = new ArrayList<>();
    private static List<Teacher> teachers = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Welcome to the School Management System");

        while (true) {
            int choice = getMenuChoice();
            switch (choice) {
                case 1:
                    enrollStudent();
                    break;
                case 2:
                    assignCourseToTeacher();
                    break;
                case 3:
                    recordAttendance();
                    break;
                case 4:
                    enterGrades();
                    break;
                case 5:
                    printGradesReport();
                    break;
                case 6:
                    printAttendanceReport();
                    break;
                case 7:
                    printTeacherAssignmentsReport();
                    break;
                case 8:
                    System.out.println("Exiting the School Management System. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private static int getMenuChoice() {
        System.out.println("\nPlease choose an option:");
        System.out.println("1. Enroll a new student");
        System.out.println("2. Assign a course to a teacher");
        System.out.println("3. Record student attendance");
        System.out.println("4. Enter grades for a student");
        System.out.println("5. Print grades report");
        System.out.println("6. Print attendance report");
        System.out.println("7. Print teacher assignments report");
        System.out.println("8. Exit");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline left-over
        return choice;
    }


    private static void enrollStudent() {
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();
        if (studentExists(studentId)) {
            System.out.println("A student with this ID already exists. Try again.");
            return; // Exit the method if the student ID already exists
        }

        System.out.print("Enter student's name: ");
        String studentName = scanner.nextLine();

        System.out.println("Is the student full-time? (yes/no): ");
        String isFullTime = scanner.nextLine();

        boolean fullTime = isFullTime.equalsIgnoreCase("yes");
        int creditHours = fullTime ? FullTimeStudent.getFullTimeMinCredits() : PartTimeStudent.getPartTimeMaxCredits();

        Student student;
        if (fullTime) {
            System.out.print("Enter scholarship amount (or 0 if none): ");
            double scholarship = getValidDoubleInput();
            student = new FullTimeStudent(studentId, studentName, creditHours, scholarship);
        } else {
            System.out.print("Is the student employed? (yes/no): ");
            boolean isEmployed = scanner.nextLine().equalsIgnoreCase("yes");
            student = new PartTimeStudent(studentId, studentName, creditHours, isEmployed);
        }

        students.add(student);
        System.out.println("Student " + studentName + " has been enrolled.");
    }

    private static boolean studentExists(String studentId) {
        return students.stream().anyMatch(student -> student.getStudentId().equals(studentId));
    }

    private static double getValidDoubleInput() {
        while (!scanner.hasNextDouble()) {
            System.out.println("Please enter a valid number:");
            scanner.next(); // Consume the invalid input
        }
        double value = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline left-over
        return value;
    }



    private static void assignCourseToTeacher() {
        System.out.println("Enter the teacher's ID: ");
        String teacherId = scanner.nextLine();

        if (teacherExists(teacherId)) {
            System.out.println("A teacher with this ID already exists. Try again.");
            return; // Exit the method if the teacher ID already exists
        }
        // Find or create the teacher
        Teacher teacher = teachers.stream()
                .filter(t -> t.getTeacherId().equals(teacherId))
                .findFirst()
                .orElseGet(() -> {
                    System.out.println("Enter teacher's name: ");
                    String teacherName = scanner.next();
                    System.out.println("Enter teacher's qualifications: ");
                    String qualifications = scanner.next();
                    Teacher newTeacher = new Teacher(teacherId, teacherName, qualifications);
                    teachers.add(newTeacher);
                    return newTeacher;
                });

        System.out.println("Enter the course ID to assign: ");
        String courseId = scanner.next();
        // Find or create the course
        Course course = courses.stream()
                .filter(c -> c.getCourseId().equals(courseId))
                .findFirst()
                .orElseGet(() -> {
                    System.out.println("Enter course name: ");
                    String courseName = scanner.next();
                    System.out.println("Enter credit hours: ");
                    int creditHours = scanner.nextInt();
                    Course newCourse = new Course(courseId, courseName, creditHours);
                    courses.add(newCourse);
                    return newCourse;
                });

        teacher.addCourse(course);
        System.out.println(
                "Course " + course.getCourseName() + " has been assigned to teacher " + teacher.getTeacherName() + ".");
    }

    private static boolean teacherExists(String teacherId) {
        return teachers.stream().anyMatch(teacher -> teacher.getTeacherId().equals(teacherId));
    }

    private static void recordAttendance() {
        System.out.println("Recording attendance...");
        // Assuming you have a method to select a course and student
        System.out.println("Enter course ID:");
        String courseId = scanner.next();
        Course course = findCourseById(courseId);

        System.out.println("Enter student ID:");
        String studentId = scanner.next();
        Student student = findStudentById(studentId);

        if (course != null && student != null) {
            System.out.println("Mark student as present? (yes/no):");
            boolean isPresent = scanner.next().equalsIgnoreCase("yes");
            course.recordAttendance(student, isPresent);
            System.out.println("Attendance recorded.");
        } else {
            System.out.println("Course or student not found.");
        }
    }

    private static void enterGrades() {
        System.out.println("Enter course ID for grade entry:");
        String courseId = scanner.next();
        Course course = findCourseById(courseId);

        System.out.println("Enter student ID:");
        String studentId = scanner.next();
        Student student = findStudentById(studentId);

        if (course != null && student != null) {
            System.out.println("Enter grade:");
            double grade = getValidDoubleInput();
            student.setGrade(course, grade); // Assuming you add a method for setting grades in Student
            System.out.println("Grade entered.");
        } else {
            System.out.println("Course or student not found.");
        }
    }

    private static void printGradesReport() {
        System.out.println("\nGrades Report:");
        for (Student student : students) {
            System.out.println(student);
            for (Course course : student.getCoursesEnrolled()) {
                Double grade = student.getGrade(course);
                String gradeStr = (grade == null) ? "N/A" : grade.toString();
                System.out.println("\t" + course.getCourseName() + ": " + gradeStr);
            }
        }
    }

    private static void printAttendanceReport() {
        System.out.println("\nAttendance Report:");
        for (Course course : courses) {
            System.out.println("Course: " + course.getCourseName());
            course.displayAttendanceRecords();
        }
    }

    private static void printTeacherAssignmentsReport() {
        System.out.println("\nTeacher Assignments Report:");
        for (Teacher teacher : teachers) {
            System.out.println(teacher);
            for (Course course : teacher.getCoursesTaught()) {
                System.out.println("\t" + course.getCourseName() + ": " + course.getStudentsEnrolled().size() + " students");
            }
        }
    }

    // Helper methods to find a student or a course by ID
    private static Course findCourseById(String courseId) {
        for (Course course : courses) {
            if (course.getCourseId().equals(courseId)) {
                return course;
            }
        }
        return null; // Course not found
    }

    private static Student findStudentById(String studentId) {
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                return student;
            }
        }
        return null; // Student not found
    }


}
