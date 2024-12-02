// Appointment.java
import java.util.Date;

public class Appointment {
    private int appointmentID;
    private Date appointmentDate;
    private String status;
    private Patient patient;
    private Doctor doctor;

    public Appointment(int appointmentID, Date appointmentDate, String status, Patient patient, Doctor doctor) {
        this.appointmentID = appointmentID;
        this.appointmentDate = appointmentDate;
        this.status = status;
        this.patient = patient;
        this.doctor = doctor;
    }

    public int getAppointmentID() { return appointmentID; }
    public Date getAppointmentDate() { return appointmentDate; }
    public String getStatus() { return status; }
    public Patient getPatient() { return patient; }
    public Doctor getDoctor() { return doctor; }

    public String toString() {
        return "Appointment ID: " + appointmentID + ", Date: " + appointmentDate + ", Status: " + status +
               ", Patient: " + patient.getName() + ", Doctor: " + doctor.getName();
    }

    public String toFileString() {
        return appointmentID + "," + appointmentDate.getTime() + "," + status + "," + patient.getId() + "," + doctor.getId() + "\n";
    }
}
