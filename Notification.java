import java.util.Date;

public class Notification {
    private int notificationID;
    private String message;
    private Date timestamp;
    private Person recipient; // Could be Patient, Doctor, or StaffMember

    public Notification(int notificationID, String message, Date timestamp, Person recipient) {
        this.notificationID = notificationID;
        this.message = message;
        this.timestamp = timestamp;
        this.recipient = recipient;
    }

    // Getters and Setters
    public int getNotificationID() { return notificationID; }
    public String getMessage() { return message; }
    public Date getTimestamp() { return timestamp; }
    public Person getRecipient() { return recipient; }

    public void setMessage(String message) { this.message = message; }
    public void setTimestamp(Date timestamp) { this.timestamp = timestamp; }

    @Override
    public String toString() {
        return "Notification ID: " + notificationID + ", Message: " + message +
               ", Timestamp: " + timestamp + ", Recipient: " + recipient.getName();
    }

    public String toFileString() {
        return notificationID + "," + message + "," + timestamp.getTime() + "," + recipient.getId() + "\n";
    }
}
