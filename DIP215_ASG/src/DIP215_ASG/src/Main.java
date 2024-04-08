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
        System.out.println("****************************************");
        System.out.println("Welcome to HELP School Management System");
        System.out.println("****************************************");


        while (true) {
            int choice = getMenuChoice();
            switch (choice) {
                case 1:
                    enrollStudents();
                    break;

                case 2:
                    addNewCourses();
                    break;

                case 3:
                    assignCourseToStudent();
                    break;

                case 4:
                    dropCourseForStudent();
                    break;

                case 5:
                    printAllCourses();
                    break;

                case 6:
                    assignCourseToTeacher();
                    break;

                case 7:
                    recordAttendance();
                    break;

                case 8:
                    enterGrades();
                    break;

                case 9:
                    printGradesReport();
                    break;

                case 10:
                    printAttendanceReport();
                    break;

                case 11:
                    printTeacherAssignmentsReport();
                    break;

                case 12:
                    printAllGradeReports();
                    break;

                case 13:
                    System.out.println("Exiting HELP School Management System. \nThank You!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private static int getMenuChoice() {
        while (true) {
            System.out.println("\nPlease choose an option:");
            System.out.println("1. Enroll a new student");
            System.out.println("2. Create a new course");
            System.out.println("3. Assign course to students");
            System.out.println("4. Drop course for students");
            System.out.println("5. Display all courses");
            System.out.println("6. Assign a course to a teacher");
            System.out.println("7. Record student attendance");
            System.out.println("8. Enter grades for a student");
            System.out.println("9. Print grades report");
            System.out.println("10. Print attendance report");
            System.out.println("11. Print teacher assignments report");
            System.out.println("12. Print all grade reports");
            System.out.println("13. Exit");
            System.out.print("Enter choice: ");

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline left-over
                if (choice >= 1 && choice <= 13) { // Updated to include all menu options
                    return choice;
                } else {
                    System.out.println("Invalid choice. Please enter a number between 1 and 13."); // Updated message
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Consume the non-integer input
            }
            scanner.nextLine(); // It's important to clear the newline character in the case of invalid input
        }
    }
    private static void enrollStudents() {
        System.out.print("How many students would you like to enroll? ");
        int studentCount = getValidIntegerInput1();

        scanner.nextLine(); // Clear buffer after number input

        for (int i = 0; i < studentCount; i++) {
            System.out.println("Entering information for student number " + (i + 1) + ":");
            enrollSingleStudent();

            // Optionally add a pause or confirmation before continuing
            if (i < studentCount - 1) {
                System.out.println("Press Enter to continue to the next student...");
                scanner.nextLine();
            }
        }
    }
    private static void enrollSingleStudent() {
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();
        if (studentExists(studentId)) {
            System.out.println("A student with this ID already exists. Try again.");
            return; // Exit the method if the student ID already exists
        }

        String studentName = getNonEmptyLine("Enter student's name: ");

        boolean fullTime = getYesOrNoInput("Is the student full-time? Please enter 'YES' or 'NO': ");
        int creditHours = fullTime ? FullTimeStudent.getFullTimeMinCredits() : PartTimeStudent.getPartTimeMaxCredits();

        Student student;
        if (fullTime) {
            System.out.print("Enter scholarship amount (or 0 if none): ");
            double scholarship = getValidDoubleInput();
            student = new FullTimeStudent(studentId, studentName, creditHours, scholarship);
        } else {
            System.out.print("Is the student employed? (yes/no): ");
            boolean isEmployed = getYesOrNoInput("Is the student employed?");
            student = new PartTimeStudent(studentId, studentName, creditHours, isEmployed);
        }

        students.add(student);
        System.out.println("Student " + studentName + " (" + studentId + ") has been registered.");
    }

    private static boolean getYesOrNoInput(String question) {
        String input;
        do {
            System.out.print(question);
            input = scanner.nextLine().trim().toLowerCase();
            if(input.equals("yes") || input.equals("no")) {
                return input.equals("yes");
            } else {
                System.out.println("Invalid input. Please enter 'YES' or 'NO'.");
            }
        } while(true);
    }

    private static String getNonEmptyLine(String prompt) {
        String input;
        do {
            System.out.print(prompt);
            input = scanner.nextLine().trim(); // Trim to remove leading and trailing whitespace
            if (input.isEmpty()) {
                System.out.println("Input cannot be empty. Please enter some text.");
            }
        } while (input.isEmpty());
        return input;
    }


    private static int getValidIntegerInput1() {
        while (!scanner.hasNextInt()) {
            System.out.println("That's not a valid number. Please enter a valid integer:");
            scanner.next(); // Consume the invalid input
        }
        int number = scanner.nextInt();
        scanner.nextLine(); // Consume the newline left-over
        return number;
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

    private static void addNewCourses() {
        System.out.print("How many new courses would you like to enter? ");
        int courseCount = getValidIntegerInput(); // Ensure that the user inputs a valid integer

        for (int i = 0; i < courseCount; i++) {
            System.out.println("Entering information for course number " + (i + 1));
            addNewCourse();
            // Optionally add a pause or confirmation before continuing
            if (i < courseCount - 1) {
                System.out.println("Press Enter to continue to the next course...");
                scanner.nextLine();
            }
        }
    }

    private static void addNewCourse() {
        // Input validation for new course ID
        String courseId;
        do {
            System.out.print("Enter the new course ID: ");
            courseId = scanner.nextLine();
            if (courseExists(courseId)) {
                System.out.println("A course with this ID already exists. Please enter a different ID.");
            }
        } while (courseExists(courseId)); // Repeat until a unique course ID is entered

        // Input validation for new course name
        System.out.print("Enter " + courseId + " course name: ");
        String courseName = scanner.nextLine();

        // Input validation for new course credit hours
        double creditHours;
        while (true) {
            System.out.print("Enter " + courseId + " course credit hours: ");
            if (scanner.hasNextDouble()) {
                creditHours = scanner.nextDouble();
                scanner.nextLine(); // Consume newline character
                break; // Exit loop if a valid double is entered
            } else {
                System.out.println("Invalid input. Please enter a valid number for credit hours. (E.g, 4.00)");
                scanner.nextLine(); // Consume invalid input
            }
        }

        // Create and add the new course if input validation passes
        Course course = new Course(courseId, courseName, creditHours);
        courses.add(course);
        System.out.println(courseName + "(" + courseId + ") added successfully to course list");
    }

    private static int getValidIntegerInput() {
        while (!scanner.hasNextInt()) {
            System.out.println("That's not a valid number. Please enter a valid integer:");
            scanner.next(); // Consume the invalid input
        }
        int number = scanner.nextInt();
        scanner.nextLine(); // Consume the newline left-over
        return number;
    }

    private static void printAllCourses() {
        System.out.println("\nAll Courses:");
        for (Course course : courses) {
            System.out.println(course); // Print the course details
        }
    }


    private static boolean courseExists(String courseId) {
        return courses.stream().anyMatch(course -> course.getCourseId().equals(courseId));
    }

    private static void assignCourseToStudent() {
        System.out.print("Course ID: ");
        String courseId = scanner.nextLine();

        // Check if the course exists
        Course course = findCourseById(courseId);
        if (course == null) {
            System.out.println("Course not found.");
            return;
        }

        System.out.print("Enter number of students: ");
        int noOfStudents = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        for (int i = 0; i < noOfStudents; i++) {
            System.out.print("Enter Student ID for student " + (i + 1) + ": ");
            String studentId = scanner.nextLine();

            // Check if the student exists
            Student student = findStudentById(studentId);
            if (student == null) {
                System.out.println("Student with ID " + studentId + " not found.");
                continue; // Continue to the next iteration if student not found
            }

            // Enroll the student in the course
            student.enrollCourse(course);
            System.out.println("Student " + studentId + " enrolled in " + courseId + "course.");
        }
    }

    private static void dropCourseForStudent() {
        System.out.print("Enter Course ID: ");
        String courseId = scanner.nextLine();

        // Check if the course exists
        Course course = findCourseById(courseId);
        if (course == null) {
            System.out.println("Course not found.");
            return;
        }

        System.out.print("Enter Student ID: ");
        String studentId = scanner.nextLine();

        // Check if the student exists
        Student student = findStudentById(studentId);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        // Drop the course for the student
        student.dropCourse(course);
        System.out.println("Course " + courseId + " dropped for student " + studentId + ".");
    }


    private static void assignCourseToTeacher() {
        System.out.println("Enter the teacher's ID: ");
        String teacherId = scanner.nextLine();

        if (teacherExists(teacherId)) {
            System.out.println("A teacher with this ID already exists. Try again.");
            return; // Exit the method if the teacher ID already exists
        }
        // Find or create the teacher
// Find or create the teacher
        Teacher teacher = teachers.stream()
                .filter(t -> t.getTeacherId().equals(teacherId))
                .findFirst()
                .orElseGet(() -> {
                    System.out.println("Enter teacher's name: ");
                    String teacherName = scanner.nextLine(); // Use nextLine() to capture full name input

                    System.out.println("Enter teacher's qualifications: ");
                    String qualifications = scanner.nextLine(); // Use nextLine() to capture full qualifications input

                    System.out.println("Enter teacher's work email: ");
                    String email = scanner.nextLine(); // Use nextLine() to capture full email input

                    System.out.println("Enter teacher's contact number: ");
                    while (!scanner.hasNextInt()) { // Check if the next input is an integer
                        System.out.println("Please enter a valid contact number (digits only):");
                        scanner.next(); // Discard the non-integer input
                    }
                    int contactNo = scanner.nextInt();
                    //scanner.nextLine(); // Consume the rest of the line after reading the integer

                    Teacher newTeacher = new Teacher(teacherId, teacherName, email, contactNo, qualifications);
                    teachers.add(newTeacher);
                    return newTeacher;
                });

        scanner.nextLine (); // Consume the newline left-over
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
                    double creditHours = scanner.nextDouble ();
                    Course newCourse = new Course(courseId, courseName, creditHours);
                    courses.add(newCourse);
                    return newCourse;
                });

        teacher.addCourse(course);
        System.out.println(
                "Course " + course.getCourseName() + " (" + course.getCourseId () + ") has been assigned to teacher " + teacher.getTeacherName() + "(" + teacher.getTeacherId () + ")");
    }

    private static boolean teacherExists(String teacherId) {
        return teachers.stream().anyMatch(teacher -> teacher.getTeacherId().equals(teacherId));
    }

    private static void recordAttendance() {
        System.out.println("\nStudent's Attendance Recording System Initialized...");
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
            System.out.println("Attendance of " + studentId + " recorded.");
        } else {
            System.out.println("Course or student not found.");
        }
    }

    private static void enterGrades() {System.out.println("Student's Grades Recording System Initialized...\n");
        System.out.println("Enter course ID for grade entry:");
        String courseId = scanner.next();
        Course course = findCourseById(courseId);

        System.out.println("Enter student ID:");
        String studentId = scanner.next();
        Student student = findStudentById(studentId);

        if (course != null && student != null) {
            System.out.println("Enter grade:");
            double grade = getValidDoubleInput();
            student.setGrade(course, grade); // Set the grade for the student in the course
            System.out.println("Grade for " + studentId + " recorded.");
        } else {
            System.out.println("Course or student not found.");
        }
    }

    private static void printGradesReport() {
        System.out.println("\nGenerating Student Grade Reports...\n");
        System.out.println ("\nStudent Grade Report:");
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
        System.out.println ("\nGenerating Attendance Report...\n");
        System.out.println("\nAttendance Report:");
        for (Course course : courses) {
            System.out.println("Course: " + course.getCourseName());
            course.displayAttendanceRecords();
        }
    }

    private static void printTeacherAssignmentsReport() {
        System.out.println("\nGenerating Teacher Assignments Report...\n");
        System.out.println("\nTeacher Assignments Report:");
        for (Teacher teacher : teachers) {
            System.out.println(teacher);
            for (Course course : teacher.getCoursesTaught()) {
                System.out.println("\t" + course.getCourseName() + ": " + course.getStudentsEnrolled().size() + " students");
            }
        }
    }

    // Method to print grade reports for all students
    private static void printAllGradeReports() {
        System.out.println ("\nGenerating Grade Reports for Students...\n");
        System.out.println("Grade Reports of all Students:");
        for (Student student : students) {
            System.out.println(student.generateTranscript());
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
