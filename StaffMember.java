public class StaffMember extends Person {
    private String role;
    private String department;
    private String shift;

    public StaffMember(int id, String name, String email, String phone, String role, String department, String shift) {
        super(id, name, email, phone);
        this.role = role;
        this.department = department;
        this.shift = shift;
    }

    // Getters and Setters
    public String getRole() { return role; }
    public String getDepartment() { return department; }
    public String getShift() { return shift; }

    public void setRole(String role) { this.role = role; }
    public void setDepartment(String department) { this.department = department; }
    public void setShift(String shift) { this.shift = shift; }

    @Override
    public String toString() {
        return super.toString() + ", Role: " + role +
               ", Department: " + department + ", Shift: " + shift;
    }

    @Override
    public String toFileString() {
        return id + "," + name + "," + email + "," + phone + "," +
               role + "," + department + "," + shift + "\n";
    }
}
