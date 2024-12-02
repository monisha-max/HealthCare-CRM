// CarePlan.java
import java.util.ArrayList;
import java.util.List;

public class CarePlan {
    private int planID;
    private String planName;
    private String description;
    private double price;
    private List<Patient> subscribers;

    public CarePlan(int planID, String planName, String description, double price) {
        this.planID = planID;
        this.planName = planName;
        this.description = description;
        this.price = price;
        this.subscribers = new ArrayList<>();
    }

    // Getters and Setters
    public int getPlanID() { return planID; }
    public String getPlanName() { return planName; }
    public String getDescription() { return description; }
    public double getPrice() { return price; }
    public List<Patient> getSubscribers() { return subscribers; }

    public void setPlanName(String planName) { this.planName = planName; }
    public void setDescription(String description) { this.description = description; }
    public void setPrice(double price) { this.price = price; }

    public void addSubscriber(Patient patient) {
        if (!subscribers.contains(patient)) {
            subscribers.add(patient);
        }
    }

    @Override
    public String toString() {
        return "Care Plan ID: " + planID + ", Name: " + planName +
               ", Description: " + description + ", Price: $" + price;
    }

    public String toFileString() {
        StringBuilder subscribersStr = new StringBuilder();
        for (Patient p : subscribers) {
            subscribersStr.append(p.getId()).append(";");
        }
        if (subscribersStr.length() > 0) {
            subscribersStr.setLength(subscribersStr.length() - 1); // Remove last semicolon
        }
        return planID + "," + planName + "," + description + "," + price + "," + subscribersStr + "\n";
    }
}
