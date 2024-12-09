public class AppointmentWrapper {
    private int appointmentId;
    private int patientId;
    private int doctorId;
    private String date;
    private String status;

    // Constructor
    public AppointmentWrapper(int appointmentId, int patientId, int doctorId, String date, String status) {
        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.date = date;
        this.status = status;
    }

    // Getters and setters
    public int getAppointmentId() { return appointmentId; }
    public void setAppointmentId(int appointmentId) { this.appointmentId = appointmentId; }

    public int getPatientId() { return patientId; }
    public void setPatientId(int patientId) { this.patientId = patientId; }

    public int getDoctorId() { return doctorId; }
    public void setDoctorId(int doctorId) { this.doctorId = doctorId; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "Appointment{id=" + appointmentId + ", patientId=" + patientId + ", doctorId=" + doctorId + ", date='" + date + "', status='" + status + "'}";
    }
}
