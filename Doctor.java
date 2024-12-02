// Doctor.java
import java.util.ArrayList;
import java.util.List;

public class Doctor extends Person {
    private String specialization;
    private String officeHours;
    private List<Appointment> appointments;

    public Doctor(int id, String name, String email, String phone, String specialization, String officeHours) {
        super(id, name, email, phone);
        this.specialization = specialization;
        this.officeHours = officeHours;
        this.appointments = new ArrayList<>();
    }

    public String getSpecialization() { return specialization; }
    public String getOfficeHours() { return officeHours; }
    public List<Appointment> getAppointments() { return appointments; }

    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    public String toString() {
        return super.toString() + ", Specialization: " + specialization + ", Office Hours: " + officeHours;
    }

    public String toFileString() {
        return id + "," + name + "," + email + "," + phone + "," + specialization + "," + officeHours + "\n";
    }
}
