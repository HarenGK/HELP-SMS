package DIP215_ASG.src;

public class PartTimeStudent extends Student {
    private boolean employmentStatus;

    public PartTimeStudent(String studentID, String studentName, int creditHours, boolean employmentStatus) {
        super(studentID, studentName, "Part Time", creditHours); // Call to superclass constructor
        this.employmentStatus = employmentStatus;
    }

    // Getter method for employment status
    public boolean getEmploymentStatus() {
        return employmentStatus;
    }

    // Setter method for employment status
    public void setEmploymentStatus(boolean employmentStatus) {
        this.employmentStatus = employmentStatus;
    }
}

