import java.util.Date;

public class InsuranceClaim {
    private int claimID;
    private Patient patient;
    private double claimAmount;
    private Date claimDate;
    private String status; // e.g., Submitted, Approved, Denied

    public InsuranceClaim(int claimID, Patient patient, double claimAmount, Date claimDate, String status) {
        this.claimID = claimID;
        this.patient = patient;
        this.claimAmount = claimAmount;
        this.claimDate = claimDate;
        this.status = status;
    }

    // Getters and Setters
    public int getClaimID() { return claimID; }
    public Patient getPatient() { return patient; }
    public double getClaimAmount() { return claimAmount; }
    public Date getClaimDate() { return claimDate; }
    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "Claim ID: " + claimID + ", Patient: " + patient.getName() +
               ", Amount: $" + claimAmount + ", Date: " + claimDate +
               ", Status: " + status;
    }

    public String toFileString() {
        return claimID + "," + patient.getId() + "," + claimAmount + "," +
               claimDate.getTime() + "," + status + "\n";
    }
}
