import java.util.ArrayList;
import java.util.List;

public class CrudManager<T> {
    private List<T> records;

    public CrudManager() {
        this.records = new ArrayList<>();
    }

    // Create a new record
    public void create(T record) {
        records.add(record);
    }

    // Read a record by ID
    public T read(int id) {
        for (T record : records) {
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

    // Update a record
    public void update(int id, T updatedRecord) {
        for (int i = 0; i < records.size(); i++) {
            if (records.get(i) instanceof PatientWrapper && ((PatientWrapper) records.get(i)).getId() == id) {
                records.set(i, updatedRecord);
                return;
            } else if (records.get(i) instanceof DoctorWrapper && ((DoctorWrapper) records.get(i)).getId() == id) {
                records.set(i, updatedRecord);
                return;
            } else if (records.get(i) instanceof AppointmentWrapper && ((AppointmentWrapper) records.get(i)).getAppointmentId() == id) {
                records.set(i, updatedRecord);
                return;
            }
        }
    }

    // Delete a record by ID
    public void delete(int id) {
        records.removeIf(record -> (record instanceof PatientWrapper && ((PatientWrapper) record).getId() == id)
                || (record instanceof DoctorWrapper && ((DoctorWrapper) record).getId() == id)
                || (record instanceof AppointmentWrapper && ((AppointmentWrapper) record).getAppointmentId() == id));
    }
}
