import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TreatmentPlan {
    private int planID;
    private Patient patient;
    private String diagnosis;
    private List<String> procedures;
    private List<String> medications;
    private Date startDate;
    private Date endDate;

    public TreatmentPlan(int planID, Patient patient, String diagnosis, Date startDate, Date endDate) {
        this.planID = planID;
        this.patient = patient;
        this.diagnosis = diagnosis;
        this.procedures = new ArrayList<>();
        this.medications = new ArrayList<>();
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // Getters and Setters
    public int getPlanID() { return planID; }
    public Patient getPatient() { return patient; }
    public String getDiagnosis() { return diagnosis; }
    public List<String> getProcedures() { return procedures; }
    public List<String> getMedications() { return medications; }
    public Date getStartDate() { return startDate; }
    public Date getEndDate() { return endDate; }

    public void addProcedure(String procedure) { procedures.add(procedure); }
    public void addMedication(String medication) { medications.add(medication); }

    @Override
    public String toString() {
        return "Treatment Plan ID: " + planID + ", Patient: " + patient.getName() +
               ", Diagnosis: " + diagnosis + ", Procedures: " + procedures +
               ", Medications: " + medications + ", Start Date: " + startDate +
               ", End Date: " + endDate;
    }

    public String toFileString() {
        String proceduresStr = String.join(";", procedures);
        String medicationsStr = String.join(";", medications);
        return planID + "," + patient.getId() + "," + diagnosis + "," +
               proceduresStr + "," + medicationsStr + "," +
               startDate.getTime() + "," + endDate.getTime() + "\n";
    }
}
