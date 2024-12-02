import java.util.Date;

public class AppointmentReminder extends Notification {
    private Appointment appointment;

    public AppointmentReminder(int notificationID, String message, Date timestamp, Patient recipient, Appointment appointment) {
        super(notificationID, message, timestamp, recipient);
        this.appointment = appointment;
    }

    // Getter
    public Appointment getAppointment() { return appointment; }

    @Override
    public String toString() {
        return super.toString() + ", Appointment ID: " + appointment.getAppointmentID() +
               ", Appointment Date: " + appointment.getAppointmentDate();
    }

    @Override
    public String toFileString() {
        return super.toFileString().trim() + "," + appointment.getAppointmentID() + "\n";
    }
}
