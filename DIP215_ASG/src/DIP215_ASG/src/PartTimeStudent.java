package DIP215_ASG.src;

public class PartTimeStudent extends Student {
    private static final int PartTimeMaxCredits = 8; // Assume part-time students can enroll in a maximum of 8 credits
    private boolean employmentStatus;

    // Constructor
    public PartTimeStudent(String studentID, String studentName, int creditHours, boolean employmentStatus) {
        // Constructor that takes in some attributes from the superclass and some from the subclass demonstrating inheritance
        super(studentID, studentName, "Part Time", Math.min(creditHours, PartTimeMaxCredits));
        // Call the superclass constructor and set the credit hours to the minimum of the input and the maximum allowed
        this.employmentStatus = employmentStatus; // Set the employment status
    }

    // Public static getter for PartTimeMaxCredits
    public static int getPartTimeMaxCredits() {
        return PartTimeMaxCredits;
    }

    // Getter method for employment status
    public boolean getEmploymentStatus() {
        return employmentStatus;
    }

    // Setter method for employment status
    public void setEmploymentStatus(boolean employmentStatus) {
        this.employmentStatus = employmentStatus;
    }

    @Override // Override the toString method from Student class to include employment status demonstrating polymorphism
    public String toString() {
        return super.toString() + "\nEmployment Status: " + getEmploymentStatus();
    }
}
