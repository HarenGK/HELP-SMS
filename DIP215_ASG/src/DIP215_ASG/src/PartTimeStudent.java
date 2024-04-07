package DIP215_ASG.src;

public class PartTimeStudent extends Student {
    private static final int PartTimeMaxCredits = 8; // Example, assuming part-time students can enroll in a maximum of 8 credits
    private boolean employmentStatus;

    public PartTimeStudent(String studentID, String studentName, int creditHours, boolean employmentStatus) {
        super(studentID, studentName, "Part Time", Math.min(creditHours, PartTimeMaxCredits));
        this.employmentStatus = employmentStatus;
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

    @Override
    public String toString() {
        return super.toString() + "\nEmployment Status: " + getEmploymentStatus();
    }
}