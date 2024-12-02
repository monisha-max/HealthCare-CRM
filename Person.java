// Person.java
import java.io.Serializable;

// Abstract Person class demonstrating inheritance and abstraction
public abstract class Person implements Serializable {
    protected int id;
    protected String name;
    protected String email;
    protected String phone;

    public Person(int id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    // Encapsulation with getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Email: " + email + ", Phone: " + phone;
    }

    public abstract String toFileString();
}
