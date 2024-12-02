public class Feedback {
    private int feedbackID;
    private Patient patient;
    private Doctor doctor;
    private String comments;
    private int rating; // Rating out of 5

    public Feedback(int feedbackID, Patient patient, Doctor doctor, String comments, int rating) {
        this.feedbackID = feedbackID;
        this.patient = patient;
        this.doctor = doctor;
        this.comments = comments;
        this.rating = rating;
    }

    // Getters and Setters
    public int getFeedbackID() { return feedbackID; }
    public Patient getPatient() { return patient; }
    public Doctor getDoctor() { return doctor; }
    public String getComments() { return comments; }
    public int getRating() { return rating; }

    public void setComments(String comments) { this.comments = comments; }
    public void setRating(int rating) { this.rating = rating; }

    @Override
    public String toString() {
        return "Feedback ID: " + feedbackID + ", Patient: " + patient.getName() +
               ", Doctor: " + doctor.getName() + ", Rating: " + rating +
               "/5, Comments: " + comments;
    }

    public String toFileString() {
        return feedbackID + "," + patient.getId() + "," + doctor.getId() +
               "," + rating + "," + comments + "\n";
    }
}
