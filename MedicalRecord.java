// MedicalRecord.java
import java.util.ArrayList;
import java.util.List;

public class MedicalRecord {
    private int recordID;
    private Patient patient;
    private List<String> diagnoses;
    private List<Prescription> prescriptions;

    public MedicalRecord(int recordID, Patient patient) {
        this.recordID = recordID;
        this.patient = patient;
        this.diagnoses = new ArrayList<>();
        this.prescriptions = new ArrayList<>();
    }

    public void addDiagnosis(String diagnosis) {
        diagnoses.add(diagnosis);
    }

    public void addPrescription(Prescription prescription) {
        prescriptions.add(prescription);
    }

    public List<String> getDiagnoses() { return diagnoses; }
    public List<Prescription> getPrescriptions() { return prescriptions; }

    public String toString() {
        return "Medical Record ID: " + recordID + ", Diagnoses: " + diagnoses + ", Prescriptions: " + prescriptions;
    }

    public String toFileString() {
        String diagnosesStr = String.join(";", diagnoses);
        StringBuilder prescriptionsStr = new StringBuilder();
        for (Prescription p : prescriptions) {
            prescriptionsStr.append(p.toFileString()).append(";");
        }
        if (prescriptionsStr.length() > 0) {
            prescriptionsStr.setLength(prescriptionsStr.length() - 1);
        }
        return recordID + "," + patient.getId() + "," + diagnosesStr + "," + prescriptionsStr + "\n";
    }
}
