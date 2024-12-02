// Prescription.java
public class Prescription {
    private int prescriptionID;
    private String medicationName;
    private String dosage;
    private String instructions;

    public Prescription(int prescriptionID, String medicationName, String dosage, String instructions) {
        this.prescriptionID = prescriptionID;
        this.medicationName = medicationName;
        this.dosage = dosage;
        this.instructions = instructions;
    }

    public String toString() {
        return "Prescription ID: " + prescriptionID + ", Medication: " + medicationName + ", Dosage: " + dosage + ", Instructions: " + instructions;
    }

    public String toFileString() {
        return prescriptionID + ":" + medicationName + ":" + dosage + ":" + instructions;
    }
}
