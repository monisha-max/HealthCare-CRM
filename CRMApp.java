import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CRMApp {
    private CRMSystem crmSystem;
    private JFrame frame;
    private JTextArea displayArea;
    private JTextField idField, nameField, emailField, phoneField, addressField;

    public CRMApp() {
        crmSystem = new CRMSystem();
        initializeGUI();
    }

    private void initializeGUI() {
        frame = new JFrame("Health Management CRM");
        frame.setSize(1600, 1600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setVisible(true);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
		inputPanel.setBackground(Color.BLACK);
        
        // Row 1 - ID
        JPanel row1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		row1.setBackground(Color.BLACK); 
		JLabel idLabel = new JLabel("Patient ID:");
		idLabel.setForeground(Color.WHITE);
		row1.add(idLabel);
        idField = new JTextField(20);
		idField.setBackground(Color.BLACK);
		idField.setForeground(Color.WHITE);
        idField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        row1.add(idField);
        inputPanel.add(row1);

        // Row 2 - Name
        JPanel row2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		row2.setBackground(Color.BLACK);
		JLabel nameLabel = new JLabel("Name:");
        nameLabel.setForeground(Color.WHITE);
        row2.add(nameLabel);
        nameField = new JTextField(20);
		nameField.setBackground(Color.BLACK);
        nameField.setForeground(Color.WHITE);
        nameField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        row2.add(nameField);
        inputPanel.add(row2);

        // Row 3 - Email
        JPanel row3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		row3.setBackground(Color.BLACK);
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setForeground(Color.WHITE);
        row3.add(emailLabel);
        emailField = new JTextField(20);
		emailField.setBackground(Color.BLACK);
        emailField.setForeground(Color.WHITE);
        emailField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        row3.add(emailField);
        inputPanel.add(row3);

        // Row 4 - Phone
        JPanel row4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		row4.setBackground(Color.BLACK);
        JLabel phoneLabel = new JLabel("Phone:");
        phoneLabel.setForeground(Color.WHITE);
        row4.add(phoneLabel);
        phoneField = new JTextField(20);
		phoneField.setBackground(Color.BLACK);
        phoneField.setForeground(Color.WHITE);
        phoneField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        row4.add(phoneField);
        inputPanel.add(row4);

        // Row 5 - Address
        JPanel row5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		row5.setBackground(Color.BLACK);
        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setForeground(Color.WHITE);
        row5.add(addressLabel);
        addressField = new JTextField(20);
		addressField.setBackground(Color.BLACK);
        addressField.setForeground(Color.WHITE);
        addressField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        row5.add(addressField);
        inputPanel.add(row5);

        // Dropdown Menu
        String[] actions = {
            "Add Patient", "List Patients", "Add Doctor", "List Doctors",
            "Add Appointment", "List Appointments", "View Medical Record",
            "Add Diagnosis", "Add Prescription", "List Prescriptions",
            "Add Billing", "View Billing", "Add Insurance Claim",
            "View Insurance Claims", "Add Feedback", "View Feedback",
            "Add Referral", "View Referrals", "Add Staff Member",
            "List Staff Members", "Add Treatment Plan", "View Treatment Plans",
            "Send Notification", "View Notifications", "Send Appointment Reminder",
            "Add Immunization", "View Immunizations", "Add Care Plan",
            "List Care Plans", "Purchase Care Plan", "Add Health Risk Assessment",
            "View Health Risk Assessments"
        };
//action dropdown
        JComboBox<String> actionDropdown = new JComboBox<>(actions);
        actionDropdown.addActionListener(e -> {
            String selectedAction = (String) actionDropdown.getSelectedItem();
            switch (selectedAction) {
                case "Add Patient":
                    addPatient();
                    break;
                case "List Patients":
                    listPatients();
                    break;
                case "Add Doctor":
                    addDoctor();
                    break;
                case "List Doctors":
                    listDoctors();
                    break;
                case "Add Appointment":
                    addAppointment();
                    break;
                case "List Appointments":
                    listAppointments();
                    break;
                case "View Medical Record":
                    viewMedicalRecord();
                    break;
                case "Add Diagnosis":
                    addDiagnosis();
                    break;
                case "Add Prescription":
                    addPrescription();
                    break;
                case "List Prescriptions":
                    listPrescriptions();
                    break;
                case "Add Billing":
                    addBilling();
                    break;
                case "View Billing":
                    viewBilling();
                    break;
                case "Add Insurance Claim":
                    addInsuranceClaim();
                    break;
                case "View Insurance Claims":
                    viewInsuranceClaims();
                    break;
                case "Add Feedback":
                    addFeedback();
                    break;
                case "View Feedback":
                    viewFeedback();
                    break;
                case "Add Referral":
                    addReferral();
                    break;
                case "View Referrals":
                    viewReferrals();
                    break;
                case "Add Staff Member":
                    addStaffMember();
                    break;
                case "List Staff Members":
                    listStaffMembers();
                    break;
                case "Add Treatment Plan":
                    addTreatmentPlan();
                    break;
                case "View Treatment Plans":
                    viewTreatmentPlans();
                    break;
                case "Send Notification":
                    sendNotification();
                    break;
                case "View Notifications":
                    viewNotifications();
                    break;
                case "Send Appointment Reminder":
                    sendAppointmentReminder();
                    break;
                case "Add Immunization":
                    addImmunization();
                    break;
                case "View Immunizations":
                    viewImmunizations();
                    break;
                case "Add Care Plan":
                    addCarePlan();
                    break;
                case "List Care Plans":
                    listCarePlans();
                    break;
                case "Purchase Care Plan":
                    purchaseCarePlan();
                    break;
                case "Add Health Risk Assessment":
                    addHealthRiskAssessment();
                    break;
                case "View Health Risk Assessments":
                    viewHealthRiskAssessments();
                    break;
                default:
                    break;
            }
        });
        inputPanel.add(actionDropdown);

        displayArea = new JTextArea();
        displayArea.setEditable(false);

                // Create the JSplitPane
                JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, inputPanel, new JScrollPane(displayArea));
                splitPane.setDividerLocation(300); // Adjust as needed
                frame.add(splitPane, BorderLayout.CENTER);

                frame.setVisible(true);
            }

    // Method to add a patient
    private void addPatient() {
        try {
            int id = Integer.parseInt(idField.getText());
            String name = nameField.getText();
            String email = emailField.getText();
            String phone = phoneField.getText();
            String address = addressField.getText();

            if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || address.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please fill all fields.");
                return;
            }

            Patient patient = new Patient(id, name, email, phone, address);
            crmSystem.addPatient(patient);

            idField.setText("");
            nameField.setText("");
            emailField.setText("");
            phoneField.setText("");
            addressField.setText("");

            JOptionPane.showMessageDialog(frame, "Patient added successfully!");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Invalid input. Please enter numeric values where required.");
        }
    }

    // Method to list all patients
    private void listPatients() {
        List<Patient> patients = crmSystem.getAllPatients();
        displayArea.setText("");
        if (patients.isEmpty()) {
            displayArea.setText("No patients available.");
        } else {
            for (Patient patient : patients) {
                displayArea.append(patient.toString() + "\n");
            }
        }
    }

    // Method to add a doctor
    private void addDoctor() {
        try {
            int id = Integer.parseInt(JOptionPane.showInputDialog("Enter Doctor ID:"));
            String name = JOptionPane.showInputDialog("Enter Doctor Name:");
            String email = JOptionPane.showInputDialog("Enter Doctor Email:");
            String phone = JOptionPane.showInputDialog("Enter Doctor Phone:");
            String specialization = JOptionPane.showInputDialog("Enter Specialization:");
            String officeHours = JOptionPane.showInputDialog("Enter Office Hours:");

            if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || specialization.isEmpty() || officeHours.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please fill all fields.");
                return;
            }

            Doctor doctor = new Doctor(id, name, email, phone, specialization, officeHours);
            crmSystem.addDoctor(doctor);

            JOptionPane.showMessageDialog(frame, "Doctor added successfully!");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Invalid input. Please enter numeric values where required.");
        }
    }

    // Method to list all doctors
    private void listDoctors() {
        List<Doctor> doctors = crmSystem.getAllDoctors();
        displayArea.setText("");
        if (doctors.isEmpty()) {
            displayArea.setText("No doctors available.");
        } else {
            for (Doctor doctor : doctors) {
                displayArea.append(doctor.toString() + "\n");
            }
        }
    }

    // Method to add an appointment
    private void addAppointment() {
        try {
            int appointmentId = Integer.parseInt(JOptionPane.showInputDialog("Enter Appointment ID:"));
            int patientId = Integer.parseInt(JOptionPane.showInputDialog("Enter Patient ID:"));
            int doctorId = Integer.parseInt(JOptionPane.showInputDialog("Enter Doctor ID:"));
            String dateString = JOptionPane.showInputDialog("Enter Appointment Date (yyyy-MM-dd HH:mm):");

            Date appointmentDate = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(dateString);
            String status = "Scheduled";

            Patient patient = crmSystem.findPatientById(patientId);
            if (patient == null) {
                JOptionPane.showMessageDialog(frame, "Patient not found!");
                return;
            }

            Doctor doctor = crmSystem.findDoctorById(doctorId);
            if (doctor == null) {
                JOptionPane.showMessageDialog(frame, "Doctor not found!");
                return;
            }

            Appointment appointment = new Appointment(appointmentId, appointmentDate, status, patient, doctor);
            crmSystem.addAppointment(appointment);

            JOptionPane.showMessageDialog(frame, "Appointment added successfully!");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Invalid input. Please enter numeric values where required.");
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(frame, "Invalid date format. Please use yyyy-MM-dd HH:mm.");
        }
    }

    // Method to list all appointments
    private void listAppointments() {
        displayArea.setText("");
        List<Appointment> appointments = crmSystem.getAllAppointments();
        if (appointments.isEmpty()) {
            displayArea.setText("No appointments available.");
        } else {
            for (Appointment appointment : appointments) {
                displayArea.append(appointment.toString() + "\n");
            }
        }
    }

    // Method to view a patient's medical record
    private void viewMedicalRecord() {
        try {
            int patientId = Integer.parseInt(JOptionPane.showInputDialog("Enter Patient ID:"));
            Patient patient = crmSystem.findPatientById(patientId);
            if (patient == null) {
                JOptionPane.showMessageDialog(frame, "Patient not found!");
                return;
            }
            MedicalRecord medicalRecord = patient.getMedicalRecord();
            if (medicalRecord == null) {
                JOptionPane.showMessageDialog(frame, "No medical record found for this patient.");
                return;
            }
            displayArea.setText("Medical Record for patient " + patient.getName() + ":\n");
            displayArea.append("\nDiagnoses:\n");
            for (String diagnosis : medicalRecord.getDiagnoses()) {
                displayArea.append("- " + diagnosis + "\n");
            }
            displayArea.append("\nPrescriptions:\n");
            for (Prescription prescription : medicalRecord.getPrescriptions()) {
                displayArea.append(prescription.toString() + "\n");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Invalid Patient ID.");
        }
    }

    // Method to add a diagnosis to a patient's medical record
    private void addDiagnosis() {
        try {
            int patientId = Integer.parseInt(JOptionPane.showInputDialog("Enter Patient ID:"));
            Patient patient = crmSystem.findPatientById(patientId);
            if (patient == null) {
                JOptionPane.showMessageDialog(frame, "Patient not found!");
                return;
            }
            String diagnosis = JOptionPane.showInputDialog("Enter Diagnosis:");
            if (diagnosis != null && !diagnosis.trim().isEmpty()) {
                patient.getMedicalRecord().addDiagnosis(diagnosis);
                crmSystem.saveAllMedicalRecordsToFile();
                JOptionPane.showMessageDialog(frame, "Diagnosis added successfully!");
            } else {
                JOptionPane.showMessageDialog(frame, "Diagnosis cannot be empty.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Invalid Patient ID.");
        }
    }

    // Method to add a prescription to a patient's medical record
    private void addPrescription() {
        try {
            int patientId = Integer.parseInt(JOptionPane.showInputDialog("Enter Patient ID:"));
            Patient patient = crmSystem.findPatientById(patientId);
            if (patient == null) {
                JOptionPane.showMessageDialog(frame, "Patient not found!");
                return;
            }
            int prescriptionId = Integer.parseInt(JOptionPane.showInputDialog("Enter Prescription ID:"));
            String medicationName = JOptionPane.showInputDialog("Enter Medication Name:");
            String dosage = JOptionPane.showInputDialog("Enter Dosage:");
            String instructions = JOptionPane.showInputDialog("Enter Instructions:");

            if (medicationName.isEmpty() || dosage.isEmpty() || instructions.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please fill all fields.");
                return;
            }

            Prescription prescription = new Prescription(prescriptionId, medicationName, dosage, instructions);
            patient.getMedicalRecord().addPrescription(prescription);
            crmSystem.saveAllMedicalRecordsToFile();
            JOptionPane.showMessageDialog(frame, "Prescription added successfully!");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Invalid input. Please enter numeric values where required.");
        }
    }

    // Method to list all prescriptions for a patient
    private void listPrescriptions() {
        try {
            int patientId = Integer.parseInt(JOptionPane.showInputDialog("Enter Patient ID:"));
            Patient patient = crmSystem.findPatientById(patientId);
            if (patient == null) {
                JOptionPane.showMessageDialog(frame, "Patient not found!");
                return;
            }
            MedicalRecord medicalRecord = patient.getMedicalRecord();
            if (medicalRecord == null) {
                JOptionPane.showMessageDialog(frame, "No medical record found for this patient.");
                return;
            }
            displayArea.setText("Prescriptions for patient " + patient.getName() + ":\n");
            for (Prescription prescription : medicalRecord.getPrescriptions()) {
                displayArea.append(prescription.toString() + "\n");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Invalid Patient ID.");
        }
    }
    private void addBilling() {
        try {
            int billingID = Integer.parseInt(JOptionPane.showInputDialog("Enter Billing ID:"));
            int patientID = Integer.parseInt(JOptionPane.showInputDialog("Enter Patient ID:"));
            double amountDue = Double.parseDouble(JOptionPane.showInputDialog("Enter Amount Due:"));
            String dueDateString = JOptionPane.showInputDialog("Enter Due Date (yyyy-MM-dd):");
    
            Date dueDate = new SimpleDateFormat("yyyy-MM-dd").parse(dueDateString);
            Patient patient = crmSystem.findPatientById(patientID);
    
            if (patient == null) {
                JOptionPane.showMessageDialog(frame, "Patient not found!");
                return;
            }
    
            Billing billing = new Billing(billingID, patient, amountDue, dueDate);
            crmSystem.addBilling(billing);
    
            JOptionPane.showMessageDialog(frame, "Billing record added successfully!");
        } catch (NumberFormatException | ParseException ex) {
            JOptionPane.showMessageDialog(frame, "Invalid input.");
        }
    }
    
    private void viewBilling() {
        try {
            int patientID = Integer.parseInt(JOptionPane.showInputDialog("Enter Patient ID:"));
            List<Billing> bills = crmSystem.getBillingByPatient(patientID);
    
            if (bills.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "No billing records found for this patient.");
                return;
            }
    
            displayArea.setText("Billing Records for Patient ID " + patientID + ":\n");
            for (Billing bill : bills) {
                displayArea.append(bill.toString() + "\n");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Invalid Patient ID.");
        }
    }
    private void addInsuranceClaim() {
        try {
            int claimID = Integer.parseInt(JOptionPane.showInputDialog("Enter Claim ID:"));
            int patientID = Integer.parseInt(JOptionPane.showInputDialog("Enter Patient ID:"));
            double claimAmount = Double.parseDouble(JOptionPane.showInputDialog("Enter Claim Amount:"));
            String claimDateString = JOptionPane.showInputDialog("Enter Claim Date (yyyy-MM-dd):");
            String status = "Submitted";
    
            Date claimDate = new SimpleDateFormat("yyyy-MM-dd").parse(claimDateString);
            Patient patient = crmSystem.findPatientById(patientID);
    
            if (patient == null) {
                JOptionPane.showMessageDialog(frame, "Patient not found!");
                return;
            }
    
            InsuranceClaim claim = new InsuranceClaim(claimID, patient, claimAmount, claimDate, status);
            crmSystem.addInsuranceClaim(claim);
    
            JOptionPane.showMessageDialog(frame, "Insurance claim added successfully!");
        } catch (NumberFormatException | ParseException ex) {
            JOptionPane.showMessageDialog(frame, "Invalid input.");
        }
    }
    
    private void viewInsuranceClaims() {
        try {
            int patientID = Integer.parseInt(JOptionPane.showInputDialog("Enter Patient ID:"));
            List<InsuranceClaim> claims = crmSystem.getClaimsByPatient(patientID);
    
            if (claims.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "No insurance claims found for this patient.");
                return;
            }
    
            displayArea.setText("Insurance Claims for Patient ID " + patientID + ":\n");
            for (InsuranceClaim claim : claims) {
                displayArea.append(claim.toString() + "\n");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Invalid Patient ID.");
        }
    }
    private void addFeedback() {
        try {
            int feedbackID = Integer.parseInt(JOptionPane.showInputDialog("Enter Feedback ID:"));
            int patientID = Integer.parseInt(JOptionPane.showInputDialog("Enter Patient ID:"));
            int doctorID = Integer.parseInt(JOptionPane.showInputDialog("Enter Doctor ID:"));
            int rating = Integer.parseInt(JOptionPane.showInputDialog("Enter Rating (1-5):"));
            String comments = JOptionPane.showInputDialog("Enter Comments:");
    
            if (rating < 1 || rating > 5) {
                JOptionPane.showMessageDialog(frame, "Rating must be between 1 and 5.");
                return;
            }
    
            Patient patient = crmSystem.findPatientById(patientID);
            Doctor doctor = crmSystem.findDoctorById(doctorID);
    
            if (patient == null || doctor == null) {
                JOptionPane.showMessageDialog(frame, "Patient or Doctor not found!");
                return;
            }
    
            Feedback feedback = new Feedback(feedbackID, patient, doctor, comments, rating);
            crmSystem.addFeedback(feedback);
    
            JOptionPane.showMessageDialog(frame, "Feedback added successfully!");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Invalid input.");
        }
    }
    
    private void viewFeedback() {
        try {
            int doctorID = Integer.parseInt(JOptionPane.showInputDialog("Enter Doctor ID:"));
            List<Feedback> feedbacks = crmSystem.getFeedbackByDoctor(doctorID);
    
            if (feedbacks.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "No feedback found for this doctor.");
                return;
            }
    
            displayArea.setText("Feedback for Doctor ID " + doctorID + ":\n");
            for (Feedback feedback : feedbacks) {
                displayArea.append(feedback.toString() + "\n");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Invalid Doctor ID.");
        }
    }
    private void addReferral() {
        try {
            int referralID = Integer.parseInt(JOptionPane.showInputDialog("Enter Referral ID:"));
            int patientID = Integer.parseInt(JOptionPane.showInputDialog("Enter Patient ID:"));
            int referringDoctorID = Integer.parseInt(JOptionPane.showInputDialog("Enter Referring Doctor ID:"));
            int specialistDoctorID = Integer.parseInt(JOptionPane.showInputDialog("Enter Specialist Doctor ID:"));
            String reason = JOptionPane.showInputDialog("Enter Reason for Referral:");
            String referralDateString = JOptionPane.showInputDialog("Enter Referral Date (yyyy-MM-dd):");
    
            Date referralDate = new SimpleDateFormat("yyyy-MM-dd").parse(referralDateString);
    
            Patient patient = crmSystem.findPatientById(patientID);
            Doctor referringDoctor = crmSystem.findDoctorById(referringDoctorID);
            Doctor specialistDoctor = crmSystem.findDoctorById(specialistDoctorID);
    
            if (patient == null || referringDoctor == null || specialistDoctor == null) {
                JOptionPane.showMessageDialog(frame, "Patient or Doctor not found!");
                return;
            }
    
            Referral referral = new Referral(referralID, patient, referringDoctor, specialistDoctor, reason, referralDate);
            crmSystem.addReferral(referral);
    
            JOptionPane.showMessageDialog(frame, "Referral added successfully!");
        } catch (NumberFormatException | ParseException ex) {
            JOptionPane.showMessageDialog(frame, "Invalid input.");
        }
    }
    
    private void viewReferrals() {
        try {
            int patientID = Integer.parseInt(JOptionPane.showInputDialog("Enter Patient ID:"));
            List<Referral> referrals = crmSystem.getReferralsByPatient(patientID);
    
            if (referrals.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "No referrals found for this patient.");
                return;
            }
    
            displayArea.setText("Referrals for Patient ID " + patientID + ":\n");
            for (Referral referral : referrals) {
                displayArea.append(referral.toString() + "\n");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Invalid Patient ID.");
        }
    }
    private void addStaffMember() {
        try {
            int id = Integer.parseInt(JOptionPane.showInputDialog("Enter Staff Member ID:"));
            String name = JOptionPane.showInputDialog("Enter Name:");
            String email = JOptionPane.showInputDialog("Enter Email:");
            String phone = JOptionPane.showInputDialog("Enter Phone:");
            String role = JOptionPane.showInputDialog("Enter Role (e.g., Nurse, Receptionist):");
            String department = JOptionPane.showInputDialog("Enter Department:");
            String shift = JOptionPane.showInputDialog("Enter Shift (e.g., Day, Night):");
    
            if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || role.isEmpty() || department.isEmpty() || shift.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please fill all fields.");
                return;
            }
    
            StaffMember staffMember = new StaffMember(id, name, email, phone, role, department, shift);
            crmSystem.addStaffMember(staffMember);
    
            JOptionPane.showMessageDialog(frame, "Staff member added successfully!");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Invalid input. Please enter numeric values where required.");
        }
    }
    
    private void listStaffMembers() {
        List<StaffMember> staffMembers = crmSystem.getAllStaffMembers();
        displayArea.setText("");
        if (staffMembers.isEmpty()) {
            displayArea.setText("No staff members available.");
        } else {
            for (StaffMember staffMember : staffMembers) {
                displayArea.append(staffMember.toString() + "\n");
            }
        }
    }
    private void addTreatmentPlan() {
        try {
            int planID = Integer.parseInt(JOptionPane.showInputDialog("Enter Treatment Plan ID:"));
            int patientID = Integer.parseInt(JOptionPane.showInputDialog("Enter Patient ID:"));
            String diagnosis = JOptionPane.showInputDialog("Enter Diagnosis:");
            String startDateString = JOptionPane.showInputDialog("Enter Start Date (yyyy-MM-dd):");
            String endDateString = JOptionPane.showInputDialog("Enter End Date (yyyy-MM-dd):");
    
            Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse(startDateString);
            Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(endDateString);
    
            Patient patient = crmSystem.findPatientById(patientID);
            if (patient == null) {
                JOptionPane.showMessageDialog(frame, "Patient not found!");
                return;
            }
    
            TreatmentPlan treatmentPlan = new TreatmentPlan(planID, patient, diagnosis, startDate, endDate);
    
            // Optionally add procedures and medications
            int addProcedures = JOptionPane.showConfirmDialog(frame, "Add Procedures?", "Procedures", JOptionPane.YES_NO_OPTION);
            if (addProcedures == JOptionPane.YES_OPTION) {
                String procedure;
                do {
                    procedure = JOptionPane.showInputDialog("Enter Procedure (Leave empty to stop):");
                    if (procedure != null && !procedure.isEmpty()) {
                        treatmentPlan.addProcedure(procedure);
                    }
                } while (procedure != null && !procedure.isEmpty());
            }
    
            int addMedications = JOptionPane.showConfirmDialog(frame, "Add Medications?", "Medications", JOptionPane.YES_NO_OPTION);
            if (addMedications == JOptionPane.YES_OPTION) {
                String medication;
                do {
                    medication = JOptionPane.showInputDialog("Enter Medication (Leave empty to stop):");
                    if (medication != null && !medication.isEmpty()) {
                        treatmentPlan.addMedication(medication);
                    }
                } while (medication != null && !medication.isEmpty());
            }
    
            crmSystem.addTreatmentPlan(treatmentPlan);
    
            JOptionPane.showMessageDialog(frame, "Treatment plan added successfully!");
        } catch (NumberFormatException | ParseException ex) {
            JOptionPane.showMessageDialog(frame, "Invalid input.");
        }
    }
    
    private void viewTreatmentPlans() {
        try {
            int patientID = Integer.parseInt(JOptionPane.showInputDialog("Enter Patient ID:"));
            List<TreatmentPlan> plans = crmSystem.getTreatmentPlansByPatient(patientID);
    
            if (plans.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "No treatment plans found for this patient.");
                return;
            }
    
            displayArea.setText("Treatment Plans for Patient ID " + patientID + ":\n");
            for (TreatmentPlan plan : plans) {
                displayArea.append(plan.toString() + "\n\n");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Invalid Patient ID.");
        }
    }
    private void sendNotification() {
        try {
            int notificationID = Integer.parseInt(JOptionPane.showInputDialog("Enter Notification ID:"));
            String message = JOptionPane.showInputDialog("Enter Message:");
            String recipientType = JOptionPane.showInputDialog("Recipient Type (Patient/Doctor/Staff):");
            int recipientID = Integer.parseInt(JOptionPane.showInputDialog("Enter Recipient ID:"));
    
            Person recipient = null;
            if (recipientType.equalsIgnoreCase("Patient")) {
                recipient = crmSystem.findPatientById(recipientID);
            } else if (recipientType.equalsIgnoreCase("Doctor")) {
                recipient = crmSystem.findDoctorById(recipientID);
            } else if (recipientType.equalsIgnoreCase("Staff")) {
                recipient = crmSystem.findStaffMemberById(recipientID);
            }
    
            if (recipient == null) {
                JOptionPane.showMessageDialog(frame, "Recipient not found!");
                return;
            }
    
            Date timestamp = new Date();
    
            Notification notification = new Notification(notificationID, message, timestamp, recipient);
            crmSystem.addNotification(notification);
    
            JOptionPane.showMessageDialog(frame, "Notification sent successfully!");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Invalid input.");
        }
    }
    
    private void viewNotifications() {
        try {
            int recipientID = Integer.parseInt(JOptionPane.showInputDialog("Enter Recipient ID:"));
            List<Notification> notifications = crmSystem.getNotificationsByRecipient(recipientID);
    
            if (notifications.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "No notifications found for this recipient.");
                return;
            }
    
            displayArea.setText("Notifications for Recipient ID " + recipientID + ":\n");
            for (Notification notification : notifications) {
                displayArea.append(notification.toString() + "\n");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Invalid Recipient ID.");
        }
    }
    private void sendAppointmentReminder() {
    try {
        int notificationID = Integer.parseInt(JOptionPane.showInputDialog("Enter Notification ID:"));
        int patientID = Integer.parseInt(JOptionPane.showInputDialog("Enter Patient ID:"));
        int appointmentID = Integer.parseInt(JOptionPane.showInputDialog("Enter Appointment ID:"));

        Patient patient = crmSystem.findPatientById(patientID);
        if (patient == null) {
            JOptionPane.showMessageDialog(frame, "Patient not found!");
            return;
        }

        Appointment appointment = null;
        for (Appointment appt : crmSystem.getAllAppointments()) {
            if (appt.getAppointmentID() == appointmentID && appt.getPatient().getId() == patientID) {
                appointment = appt;
                break;
            }
        }

        if (appointment == null) {
            JOptionPane.showMessageDialog(frame, "Appointment not found!");
            return;
        }

        String message = "Reminder: You have an appointment on " + appointment.getAppointmentDate();

        Date timestamp = new Date();

        AppointmentReminder reminder = new AppointmentReminder(notificationID, message, timestamp, patient, appointment);
        crmSystem.addNotification(reminder);

        JOptionPane.showMessageDialog(frame, "Appointment reminder sent successfully!");
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(frame, "Invalid input.");
    }
}
private void addImmunization() {
    try {
        int immunizationID = Integer.parseInt(JOptionPane.showInputDialog("Enter Immunization ID:"));
        int patientID = Integer.parseInt(JOptionPane.showInputDialog("Enter Patient ID:"));
        String vaccineName = JOptionPane.showInputDialog("Enter Vaccine Name:");
        String administrationDateString = JOptionPane.showInputDialog("Enter Administration Date (yyyy-MM-dd):");
        String nextDoseDueString = JOptionPane.showInputDialog("Enter Next Dose Due Date (yyyy-MM-dd) or leave blank:");

        Date administrationDate = new SimpleDateFormat("yyyy-MM-dd").parse(administrationDateString);
        Date nextDoseDue = null;
        if (!nextDoseDueString.isEmpty()) {
            nextDoseDue = new SimpleDateFormat("yyyy-MM-dd").parse(nextDoseDueString);
        }

        Patient patient = crmSystem.findPatientById(patientID);
        if (patient == null) {
            JOptionPane.showMessageDialog(frame, "Patient not found!");
            return;
        }

        Immunization immunization = new Immunization(immunizationID, patient, vaccineName, administrationDate, nextDoseDue);
        crmSystem.addImmunization(immunization);

        JOptionPane.showMessageDialog(frame, "Immunization record added successfully!");
    } catch (NumberFormatException | ParseException ex) {
        JOptionPane.showMessageDialog(frame, "Invalid input.");
    }
}

private void viewImmunizations() {
    try {
        int patientID = Integer.parseInt(JOptionPane.showInputDialog("Enter Patient ID:"));
        List<Immunization> immunizations = crmSystem.getImmunizationsByPatient(patientID);

        if (immunizations.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "No immunizations found for this patient.");
            return;
        }

        displayArea.setText("Immunizations for Patient ID " + patientID + ":\n");
        for (Immunization immunization : immunizations) {
            displayArea.append(immunization.toString() + "\n");
        }
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(frame, "Invalid Patient ID.");
    }
}
private void addCarePlan() {
    try {
        int planID = Integer.parseInt(JOptionPane.showInputDialog("Enter Care Plan ID:"));
        String planName = JOptionPane.showInputDialog("Enter Care Plan Name:");
        String description = JOptionPane.showInputDialog("Enter Description:");
        double price = Double.parseDouble(JOptionPane.showInputDialog("Enter Price:"));

        if (planName.isEmpty() || description.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Please fill all fields.");
            return;
        }

        CarePlan carePlan = new CarePlan(planID, planName, description, price);
        crmSystem.addCarePlan(carePlan);

        JOptionPane.showMessageDialog(frame, "Care plan added successfully!");
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(frame, "Invalid input.");
    }
}

private void listCarePlans() {
    List<CarePlan> carePlans = crmSystem.getAllCarePlans();
    displayArea.setText("");
    if (carePlans.isEmpty()) {
        displayArea.setText("No care plans available.");
    } else {
        for (CarePlan plan : carePlans) {
            displayArea.append(plan.toString() + "\n");
        }
    }
}

private void purchaseCarePlan() {
    try {
        int planID = Integer.parseInt(JOptionPane.showInputDialog("Enter Care Plan ID to Purchase:"));
        int patientID = Integer.parseInt(JOptionPane.showInputDialog("Enter Patient ID:"));

        crmSystem.subscribePatientToCarePlan(planID, patientID);

        JOptionPane.showMessageDialog(frame, "Care plan purchased successfully!");
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(frame, "Invalid input.");
    }
}
private void addHealthRiskAssessment() {
    try {
        int assessmentID = Integer.parseInt(JOptionPane.showInputDialog("Enter Assessment ID:"));
        int patientID = Integer.parseInt(JOptionPane.showInputDialog("Enter Patient ID:"));
        String lifestyleFactors = JOptionPane.showInputDialog("Enter Lifestyle Factors (e.g., smoking, sedentary):");
        String medicalHistory = JOptionPane.showInputDialog("Enter Medical History:");

        Patient patient = crmSystem.findPatientById(patientID);
        if (patient == null) {
            JOptionPane.showMessageDialog(frame, "Patient not found!");
            return;
        }

        HealthRiskAssessment assessment = new HealthRiskAssessment(assessmentID, patient, lifestyleFactors, medicalHistory);
        crmSystem.addHealthRiskAssessment(assessment);

        JOptionPane.showMessageDialog(frame, "Health risk assessment added successfully!");
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(frame, "Invalid input.");
    }
}

private void viewHealthRiskAssessments() {
    try {
        int patientID = Integer.parseInt(JOptionPane.showInputDialog("Enter Patient ID:"));
        List<HealthRiskAssessment> assessments = crmSystem.getAssessmentsByPatient(patientID);

        if (assessments.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "No health risk assessments found for this patient.");
            return;
        }

        displayArea.setText("Health Risk Assessments for Patient ID " + patientID + ":\n");
        for (HealthRiskAssessment assessment : assessments) {
            displayArea.append(assessment.toString() + "\n");
        }
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(frame, "Invalid Patient ID.");
    }
}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CRMApp::new);
    }
}
