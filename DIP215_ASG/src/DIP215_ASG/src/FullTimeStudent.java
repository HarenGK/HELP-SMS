package DIP215_ASG.src;

public class FullTimeStudent extends Student {
    private static final int FullTimeMinCredits = 12; // Assume full-time students need at least 12 credits
    private double scholarship;

    public FullTimeStudent(String studentID, String studentName, int creditHours, double scholarship) {
        // Constructor that takes in some attributes from the superclass and some from the subclass demonstrating inheritance
        super(studentID, studentName, "Full Time", Math.max(creditHours, FullTimeMinCredits));
        // Ensure credit hours are at least FullTimeMinCredits
        this.scholarship = Math.max(0.0, scholarship); // Ensures scholarship amount is not negative
    }

    // Public static getter for FullTimeMinCredits
    public static int getFullTimeMinCredits() {
        return FullTimeMinCredits;
    }

    // Getter method for scholarship
    public double getScholarship() {
        return scholarship;
    }

    // Setter method for scholarship
    public void setScholarship(double scholarship) {
        this.scholarship = Math.max(0.0, scholarship); // Ensure scholarship is not negative
    }

    @Override // Override the toString method from Student class to include scholarship amount demonstrating polymorphism
    public String toString() {
        return super.toString() + "\nScholarship Amount (RM): " + getScholarship();
    }
}
