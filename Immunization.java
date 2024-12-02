// Immunization.java
import java.util.Date;

public class Immunization {
    private int immunizationID;
    private Patient patient;
    private String vaccineName;
    private Date administrationDate;
    private Date nextDoseDue;

    public Immunization(int immunizationID, Patient patient, String vaccineName, Date administrationDate, Date nextDoseDue) {
        this.immunizationID = immunizationID;
        this.patient = patient;
        this.vaccineName = vaccineName;
        this.administrationDate = administrationDate;
        this.nextDoseDue = nextDoseDue;
    }

    // Getters and Setters
    public int getImmunizationID() { return immunizationID; }
    public Patient getPatient() { return patient; }
    public String getVaccineName() { return vaccineName; }
    public Date getAdministrationDate() { return administrationDate; }
    public Date getNextDoseDue() { return nextDoseDue; }

    public void setVaccineName(String vaccineName) { this.vaccineName = vaccineName; }
    public void setAdministrationDate(Date administrationDate) { this.administrationDate = administrationDate; }
    public void setNextDoseDue(Date nextDoseDue) { this.nextDoseDue = nextDoseDue; }

    @Override
    public String toString() {
        return "Immunization ID: " + immunizationID + ", Patient: " + patient.getName() +
               ", Vaccine: " + vaccineName + ", Administered On: " + administrationDate +
               ", Next Dose Due: " + nextDoseDue;
    }

    public String toFileString() {
        return immunizationID + "," + patient.getId() + "," + vaccineName + "," +
               administrationDate.getTime() + "," + (nextDoseDue != null ? nextDoseDue.getTime() : "null") + "\n";
    }
}
