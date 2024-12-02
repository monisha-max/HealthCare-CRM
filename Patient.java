// Patient.java
import java.util.ArrayList;
import java.util.List;

public class Patient extends Person {
    private String address;
    private List<Appointment> appointments;
    private MedicalRecord medicalRecord;
    private InsuranceInfo insuranceInfo;

    public Patient(int id, String name, String email, String phone, String address) {
        super(id, name, email, phone);
        this.address = address;
        this.appointments = new ArrayList<>();
        this.medicalRecord = new MedicalRecord(id, this);
        this.insuranceInfo = null;
    }

    public String getAddress() { return address; }
    public List<Appointment> getAppointments() { return appointments; }
    public MedicalRecord getMedicalRecord() { return medicalRecord; }
    public void setMedicalRecord(MedicalRecord medicalRecord) { this.medicalRecord = medicalRecord; }

    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    public String toString() {
        return super.toString() + ", Address: " + address;
    }

    public String toFileString() {
        return id + "," + name + "," + email + "," + phone + "," + address + "\n";
    }

    public InsuranceInfo getInsuranceInfo() { return insuranceInfo; }
    public void setInsuranceInfo(InsuranceInfo insuranceInfo) { this.insuranceInfo = insuranceInfo; }
}
