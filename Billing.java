import java.util.Date;

public class Billing {
    private int billingID;
    private Patient patient;
    private double amountDue;
    private Date dueDate;
    private boolean isPaid;

    public Billing(int billingID, Patient patient, double amountDue, Date dueDate) {
        this.billingID = billingID;
        this.patient = patient;
        this.amountDue = amountDue;
        this.dueDate = dueDate;
        this.isPaid = false;
    }

    // Getters and Setters
    public int getBillingID() { return billingID; }
    public Patient getPatient() { return patient; }
    public double getAmountDue() { return amountDue; }
    public Date getDueDate() { return dueDate; }
    public boolean isPaid() { return isPaid; }

    public void setAmountDue(double amountDue) { this.amountDue = amountDue; }
    public void setDueDate(Date dueDate) { this.dueDate = dueDate; }
    public void setPaid(boolean isPaid) { this.isPaid = isPaid; }

    @Override
    public String toString() {
        return "Billing ID: " + billingID + ", Patient: " + patient.getName() +
               ", Amount Due: $" + amountDue + ", Due Date: " + dueDate +
               ", Paid: " + isPaid;
    }

    public String toFileString() {
        return billingID + "," + patient.getId() + "," + amountDue + "," +
               dueDate.getTime() + "," + isPaid + "\n";
    }
}
