public class DoctorWrapper {
    private int id;
    private String name;
    private String email;
    private String phone;
    private String specialization;

    // Constructor
    public DoctorWrapper(int id, String name, String email, String phone, String specialization) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.specialization = specialization;
    }

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }

    @Override
    public String toString() {
        return "Doctor{id=" + id + ", name='" + name + "', email='" + email + "', phone='" + phone + "', specialization='" + specialization + "'}";
    }
}

