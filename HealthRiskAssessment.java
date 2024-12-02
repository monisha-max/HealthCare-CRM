// HealthRiskAssessment.java
public class HealthRiskAssessment {
    private int assessmentID;
    private Patient patient;
    private String lifestyleFactors;
    private String medicalHistory;
    private String riskLevel; // e.g., Low, Moderate, High
    private String recommendations;

    public HealthRiskAssessment(int assessmentID, Patient patient, String lifestyleFactors, String medicalHistory) {
        this.assessmentID = assessmentID;
        this.patient = patient;
        this.lifestyleFactors = lifestyleFactors;
        this.medicalHistory = medicalHistory;
        this.riskLevel = assessRisk();
        this.recommendations = generateRecommendations();
    }

    // Getters and Setters
    public int getAssessmentID() { return assessmentID; }
    public Patient getPatient() { return patient; }
    public String getLifestyleFactors() { return lifestyleFactors; }
    public String getMedicalHistory() { return medicalHistory; }
    public String getRiskLevel() { return riskLevel; }
    public String getRecommendations() { return recommendations; }

    public void setLifestyleFactors(String lifestyleFactors) {
        this.lifestyleFactors = lifestyleFactors;
        this.riskLevel = assessRisk();
        this.recommendations = generateRecommendations();
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
        this.riskLevel = assessRisk();
        this.recommendations = generateRecommendations();
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public void setRecommendations(String recommendations) {
        this.recommendations = recommendations;
    }

    // Method to assess risk level based on factors
    private String assessRisk() {
        // Simple risk assessment logic (can be expanded)
        if (lifestyleFactors.toLowerCase().contains("smoking") || medicalHistory.toLowerCase().contains("heart disease")) {
            return "High";
        } else if (lifestyleFactors.toLowerCase().contains("sedentary") || medicalHistory.toLowerCase().contains("hypertension")) {
            return "Moderate";
        } else {
            return "Low";
        }
    }

    // Method to generate recommendations based on risk
    private String generateRecommendations() {
        switch (riskLevel) {
            case "High":
                return "Immediate lifestyle changes recommended. Schedule regular check-ups.";
            case "Moderate":
                return "Consider lifestyle improvements. Monitor health regularly.";
            default:
                return "Maintain current lifestyle. Regular check-ups advised.";
        }
    }

    @Override
    public String toString() {
        return "Assessment ID: " + assessmentID + ", Patient: " + patient.getName() +
               ", Risk Level: " + riskLevel + ", Recommendations: " + recommendations;
    }

    public String toFileString() {
        return assessmentID + "," + patient.getId() + "," + lifestyleFactors + "," +
               medicalHistory + "," + riskLevel + "," + recommendations + "\n";
    }
}
