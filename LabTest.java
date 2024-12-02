import java.util.Date;

public class LabTest {
    private int testID;
    private String testName;
    private Date testDate;
    private String result;
    private Patient patient;

    public LabTest(int testID, String testName, Date testDate, String result, Patient patient) {
        this.testID = testID;
        this.testName = testName;
        this.testDate = testDate;
        this.result = result;
        this.patient = patient;
    }

    // Getters and Setters
    public int getTestID() { return testID; }
    public String getTestName() { return testName; }
    public Date getTestDate() { return testDate; }
    public String getResult() { return result; }
    public Patient getPatient() { return patient; }

    public void setTestID(int testID) { this.testID = testID; }
    public void setTestName(String testName) { this.testName = testName; }
    public void setTestDate(Date testDate) { this.testDate = testDate; }
    public void setResult(String result) { this.result = result; }

    @Override
    public String toString() {
        return "Test ID: " + testID + ", Name: " + testName + ", Date: " + testDate + ", Result: " + result;
    }

    public String toFileString() {
        return testID + "," + testName + "," + testDate.getTime() + "," + result + "," + patient.getId() + "\n";
    }
}
