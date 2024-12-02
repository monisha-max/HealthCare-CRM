import java.util.Date;

public class InsuranceInfo {
    private int insuranceID;
    private String providerName;
    private String policyNumber;
    private Date expirationDate;

    public InsuranceInfo(int insuranceID, String providerName, String policyNumber, Date expirationDate) {
        this.insuranceID = insuranceID;
        this.providerName = providerName;
        this.policyNumber = policyNumber;
        this.expirationDate = expirationDate;
    }

    // Getters and Setters
    public int getInsuranceID() { return insuranceID; }
    public String getProviderName() { return providerName; }
    public String getPolicyNumber() { return policyNumber; }
    public Date getExpirationDate() { return expirationDate; }

    public void setInsuranceID(int insuranceID) { this.insuranceID = insuranceID; }
    public void setProviderName(String providerName) { this.providerName = providerName; }
    public void setPolicyNumber(String policyNumber) { this.policyNumber = policyNumber; }
    public void setExpirationDate(Date expirationDate) { this.expirationDate = expirationDate; }

    @Override
    public String toString() {
        return "Insurance ID: " + insuranceID + ", Provider: " + providerName + ", Policy #: " + policyNumber + ", Expiration: " + expirationDate;
    }

    public String toFileString(int patientID) {
        return patientID + "," + insuranceID + "," + providerName + "," + policyNumber + "," + expirationDate.getTime() + "\n";
    }
}
