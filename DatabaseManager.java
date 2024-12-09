import java.util.ArrayList;
import java.util.List;

public class DatabaseManager<T> {
    private List<T> database;

    public DatabaseManager() {
        this.database = new ArrayList<>();
    }

    // Add a record (patient, doctor, appointment, etc.)
    public void addRecord(T record) {
        database.add(record);
    }

    // Remove a record
    public void removeRecord(T record) {
        database.remove(record);
    }

    // Get all records
    public List<T> getAllRecords() {
        return database;
    }

    // Get a record by ID (overloaded for Patient, Doctor, Appointment)
    public T getRecordById(int id) {
        for (T record : database) {
            if (record instanceof PatientWrapper && ((PatientWrapper) record).getId() == id) {
                return record;
            } else if (record instanceof DoctorWrapper && ((DoctorWrapper) record).getId() == id) {
                return record;
            } else if (record instanceof AppointmentWrapper && ((AppointmentWrapper) record).getAppointmentId() == id) {
                return record;
            }
        }
        return null;
    }
}
