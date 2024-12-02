import java.util.Date;

public class Referral {
    private int referralID;
    private Patient patient;
    private Doctor referringDoctor;
    private Doctor specialistDoctor;
    private String reason;
    private Date referralDate;

    public Referral(int referralID, Patient patient, Doctor referringDoctor, Doctor specialistDoctor, String reason, Date referralDate) {
        this.referralID = referralID;
        this.patient = patient;
        this.referringDoctor = referringDoctor;
        this.specialistDoctor = specialistDoctor;
        this.reason = reason;
        this.referralDate = referralDate;
    }

    // Getters and Setters
    public int getReferralID() { return referralID; }
    public Patient getPatient() { return patient; }
    public Doctor getReferringDoctor() { return referringDoctor; }
    public Doctor getSpecialistDoctor() { return specialistDoctor; }
    public String getReason() { return reason; }
    public Date getReferralDate() { return referralDate; }

    @Override
    public String toString() {
        return "Referral ID: " + referralID + ", Patient: " + patient.getName() +
               ", From Doctor: " + referringDoctor.getName() +
               ", To Specialist: " + specialistDoctor.getName() +
               ", Reason: " + reason + ", Date: " + referralDate;
    }

    public String toFileString() {
        return referralID + "," + patient.getId() + "," + referringDoctor.getId() +
               "," + specialistDoctor.getId() + "," + reason + "," +
               referralDate.getTime() + "\n";
    }
}
