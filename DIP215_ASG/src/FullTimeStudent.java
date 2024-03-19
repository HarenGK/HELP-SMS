package DIP215_ASG.src;

public class FullTimeStudent extends Student {
    private double scholarship;

    public FullTimeStudent(String studentID, String studentName, int creditHours, double scholarship) {
        super(studentID, studentName, "Full Time", creditHours); // Call to superclass constructor
        this.scholarship = scholarship;
    }

    // Getter method for scholarship
    public double getScholarship() {
        return scholarship;
    }

    // Setter method for scholarship
    public void setScholarship(double scholarship) {
        this.scholarship = scholarship;
    }
}

