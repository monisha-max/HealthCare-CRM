// CRMSystem.java
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CRMSystem {
    private List<Patient> patientList;
    private List<Doctor> doctorList;
    private List<Appointment> appointmentList;
    private List<MedicalRecord> medicalRecordList;
    private List<LabTest> labTestList;
    private List<Billing> billingList;
    private List<InsuranceClaim> claimList;
    private List<Feedback> feedbackList;
    private List<Referral> referralList;
    private List<StaffMember> staffList;
    private List<TreatmentPlan> treatmentPlanList;
    private List<Notification> notificationList;
    private List<Immunization> immunizationList;
    private List<CarePlan> carePlanList;
    private List<HealthRiskAssessment> assessmentList;

    private final String PATIENT_FILE = "patients.txt";
    private final String DOCTOR_FILE = "doctors.txt";
    private final String APPOINTMENT_FILE = "appointments.txt";
    private final String MEDICAL_RECORD_FILE = "medical_records.txt";
    private final String INSURANCE_FILE = "insurance_info.txt";
    private final String LABTEST_FILE = "lab_tests.txt";
    private final String BILLING_FILE = "billing.txt";
    private final String CLAIM_FILE = "claims.txt";
    private final String FEEDBACK_FILE = "feedback.txt";
    private final String REFERRAL_FILE = "referrals.txt";
    private final String STAFF_FILE = "staff_members.txt";
    private final String TREATMENT_PLAN_FILE = "treatment_plans.txt";
    private final String NOTIFICATION_FILE = "notifications.txt";
    private final String IMMUNIZATION_FILE = "immunizations.txt";
    private final String CARE_PLAN_FILE = "care_plans.txt";
    private final String ASSESSMENT_FILE = "health_risk_assessments.txt";



    public CRMSystem() {
        patientList = new ArrayList<>();
        doctorList = new ArrayList<>();
        appointmentList = new ArrayList<>();
        medicalRecordList = new ArrayList<>();
        labTestList = new ArrayList<>();
        billingList = new ArrayList<>();
        claimList = new ArrayList<>();
        feedbackList = new ArrayList<>();
        referralList = new ArrayList<>();
        staffList = new ArrayList<>();
        treatmentPlanList = new ArrayList<>();
        notificationList = new ArrayList<>();
        immunizationList = new ArrayList<>();
        carePlanList = new ArrayList<>();
        assessmentList = new ArrayList<>();
        loadPatients();
        loadDoctors();
        loadAppointments();
        loadMedicalRecords();
        loadInsuranceInfo();
        loadLabTests();
        loadBillingData();
        loadClaims();
        loadFeedback();
        loadReferrals();
        loadStaffMembers();
        loadTreatmentPlans();
        loadNotifications();
        loadImmunizations();
        loadCarePlans();
        loadAssessments();
    }

    // Patient Management
    public void addPatient(Patient patient) {
        patientList.add(patient);
        MedicalRecord medicalRecord = new MedicalRecord(patient.getId(), patient);
        medicalRecordList.add(medicalRecord);
        patient.setMedicalRecord(medicalRecord);
        savePatientToFile(patient);
        saveAllMedicalRecordsToFile();
    }

    public Patient findPatientById(int id) {
        for (Patient patient : patientList) {
            if (patient.getId() == id) {
                return patient;
            }
        }
        return null;
    }

    public List<Patient> getAllPatients() {
        return patientList;
    }

    // Doctor Management
    public void addDoctor(Doctor doctor) {
        doctorList.add(doctor);
        saveDoctorToFile(doctor);
    }

    public Doctor findDoctorById(int id) {
        for (Doctor doctor : doctorList) {
            if (doctor.getId() == id) {
                return doctor;
            }
        }
        return null;
    }

    public List<Doctor> getAllDoctors() {
        return doctorList;
    }

    // Appointment Management
    public void addAppointment(Appointment appointment) {
        appointmentList.add(appointment);
        appointment.getPatient().addAppointment(appointment);
        appointment.getDoctor().addAppointment(appointment);
        saveAppointmentToFile(appointment);
    }

    public List<Appointment> getAllAppointments() {
        return appointmentList;
    }

    // LabTest Management
    public void addLabTest(LabTest labTest) {
        labTestList.add(labTest);
        saveLabTestToFile(labTest);
    }

    public List<LabTest> getLabTestsByPatient(int patientID) {
        List<LabTest> tests = new ArrayList<>();
        for (LabTest test : labTestList) {
            if (test.getPatient().getId() == patientID) {
                tests.add(test);
            }
        }
        return tests;
    }

    // InsuranceInfo Management
    public void saveInsuranceInfo(InsuranceInfo insuranceInfo, int patientID) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(INSURANCE_FILE, true))) {
            bw.write(insuranceInfo.toFileString(patientID));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Loading Data
    private void loadPatients() {
        try (BufferedReader br = new BufferedReader(new FileReader(PATIENT_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                Patient patient = new Patient(id, data[1], data[2], data[3], data[4]);
                patientList.add(patient);
            }
        } catch (IOException e) {
            System.out.println("No existing patient file found.");
        }
    }

    private void loadDoctors() {
        try (BufferedReader br = new BufferedReader(new FileReader(DOCTOR_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                Doctor doctor = new Doctor(id, data[1], data[2], data[3], data[4], data[5]);
                doctorList.add(doctor);
            }
        } catch (IOException e) {
            System.out.println("No existing doctor file found.");
        }
    }

    private void loadAppointments() {
        try (BufferedReader br = new BufferedReader(new FileReader(APPOINTMENT_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int appointmentID = Integer.parseInt(data[0]);
                Date appointmentDate = new Date(Long.parseLong(data[1]));
                String status = data[2];
                int patientId = Integer.parseInt(data[3]);
                int doctorId = Integer.parseInt(data[4]);

                Patient patient = findPatientById(patientId);
                Doctor doctor = findDoctorById(doctorId);

                if (patient != null && doctor != null) {
                    Appointment appointment = new Appointment(appointmentID, appointmentDate, status, patient, doctor);
                    appointmentList.add(appointment);
                    patient.addAppointment(appointment);
                    doctor.addAppointment(appointment);
                }
            }
        } catch (IOException e) {
            System.out.println("No existing appointment file found.");
        }
    }

    private void loadMedicalRecords() {
        try (BufferedReader br = new BufferedReader(new FileReader(MEDICAL_RECORD_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Format: recordID,patientID,diagnosis1;diagnosis2;...,prescription1;prescription2;...
                String[] data = line.split(",", 4);
                int recordID = Integer.parseInt(data[0]);
                int patientID = Integer.parseInt(data[1]);
                String diagnosesStr = data[2];
                String prescriptionsStr = data.length > 3 ? data[3] : "";

                Patient patient = findPatientById(patientID);
                if (patient != null) {
                    MedicalRecord medicalRecord = new MedicalRecord(recordID, patient);

                    if (!diagnosesStr.isEmpty()) {
                        String[] diagnoses = diagnosesStr.split(";");
                        for (String diagnosis : diagnoses) {
                            medicalRecord.addDiagnosis(diagnosis);
                        }
                    }

                    if (!prescriptionsStr.isEmpty()) {
                        String[] prescriptions = prescriptionsStr.split(";");
                        for (String prescriptionData : prescriptions) {
                            // Each prescriptionData is in format: prescriptionID:medicationName:dosage:instructions
                            String[] pData = prescriptionData.split(":");
                            int prescriptionID = Integer.parseInt(pData[0]);
                            String medicationName = pData[1];
                            String dosage = pData[2];
                            String instructions = pData[3];
                            Prescription prescription = new Prescription(prescriptionID, medicationName, dosage, instructions);
                            medicalRecord.addPrescription(prescription);
                        }
                    }

                    medicalRecordList.add(medicalRecord);
                    patient.setMedicalRecord(medicalRecord);
                }
            }
        } catch (IOException e) {
            System.out.println("No existing medical record file found.");
        }
    }

    private void loadInsuranceInfo() {
        try (BufferedReader br = new BufferedReader(new FileReader(INSURANCE_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",", 5);
                int patientID = Integer.parseInt(data[0]);
                int insuranceID = Integer.parseInt(data[1]);
                String providerName = data[2];
                String policyNumber = data[3];
                Date expirationDate = new Date(Long.parseLong(data[4]));

                Patient patient = findPatientById(patientID);
                if (patient != null) {
                    InsuranceInfo insuranceInfo = new InsuranceInfo(insuranceID, providerName, policyNumber, expirationDate);
                    patient.setInsuranceInfo(insuranceInfo);
                }
            }
        } catch (IOException e) {
            System.out.println("No existing insurance info file found.");
        }
    }

    private void loadLabTests() {
        try (BufferedReader br = new BufferedReader(new FileReader(LABTEST_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",", 5);
                int testID = Integer.parseInt(data[0]);
                String testName = data[1];
                Date testDate = new Date(Long.parseLong(data[2]));
                String result = data[3];
                int patientID = Integer.parseInt(data[4]);

                Patient patient = findPatientById(patientID);
                if (patient != null) {
                    LabTest labTest = new LabTest(testID, testName, testDate, result, patient);
                    labTestList.add(labTest);
                }
            }
        } catch (IOException e) {
            System.out.println("No existing lab tests file found.");
        }
    }

    // Saving Data
    private void savePatientToFile(Patient patient) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(PATIENT_FILE, true))) {
            bw.write(patient.toFileString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveDoctorToFile(Doctor doctor) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(DOCTOR_FILE, true))) {
            bw.write(doctor.toFileString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveAppointmentToFile(Appointment appointment) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(APPOINTMENT_FILE, true))) {
            bw.write(appointment.toFileString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveLabTestToFile(LabTest labTest) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(LABTEST_FILE, true))) {
            bw.write(labTest.toFileString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveAllMedicalRecordsToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(MEDICAL_RECORD_FILE))) {
            for (MedicalRecord medicalRecord : medicalRecordList) {
                bw.write(medicalRecord.toFileString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void addBilling(Billing billing) {
        billingList.add(billing);
        saveBillingToFile(billing);
    }
    
    // Method to get billing records by patient
    public List<Billing> getBillingByPatient(int patientID) {
        List<Billing> bills = new ArrayList<>();
        for (Billing bill : billingList) {
            if (bill.getPatient().getId() == patientID) {
                bills.add(bill);
            }
        }
        return bills;
    }private void loadBillingData() {
        try (BufferedReader br = new BufferedReader(new FileReader(BILLING_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",", 5);
                int billingID = Integer.parseInt(data[0]);
                int patientID = Integer.parseInt(data[1]);
                double amountDue = Double.parseDouble(data[2]);
                Date dueDate = new Date(Long.parseLong(data[3]));
                boolean isPaid = Boolean.parseBoolean(data[4]);
    
                Patient patient = findPatientById(patientID);
                if (patient != null) {
                    Billing billing = new Billing(billingID, patient, amountDue, dueDate);
                    billing.setPaid(isPaid);
                    billingList.add(billing);
                }
            }
        } catch (IOException e) {
            System.out.println("No existing billing data file found.");
        }
    }
    private void saveBillingToFile(Billing billing) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(BILLING_FILE, true))) {
            bw.write(billing.toFileString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void addInsuranceClaim(InsuranceClaim claim) {
        claimList.add(claim);
        saveClaimToFile(claim);
    }
    
    // Method to get claims by patient
    public List<InsuranceClaim> getClaimsByPatient(int patientID) {
        List<InsuranceClaim> claims = new ArrayList<>();
        for (InsuranceClaim claim : claimList) {
            if (claim.getPatient().getId() == patientID) {
                claims.add(claim);
            }
        }
        return claims;
    }
    private void loadClaims() {
        try (BufferedReader br = new BufferedReader(new FileReader(CLAIM_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",", 5);
                int claimID = Integer.parseInt(data[0]);
                int patientID = Integer.parseInt(data[1]);
                double claimAmount = Double.parseDouble(data[2]);
                Date claimDate = new Date(Long.parseLong(data[3]));
                String status = data[4];
    
                Patient patient = findPatientById(patientID);
                if (patient != null) {
                    InsuranceClaim claim = new InsuranceClaim(claimID, patient, claimAmount, claimDate, status);
                    claimList.add(claim);
                }
            }
        } catch (IOException e) {
            System.out.println("No existing claims file found.");
        }
    }
    
    // Method to save a claim to file
    private void saveClaimToFile(InsuranceClaim claim) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(CLAIM_FILE, true))) {
            bw.write(claim.toFileString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void addFeedback(Feedback feedback) {
        feedbackList.add(feedback);
        saveFeedbackToFile(feedback);
    }
    
    // Method to get feedback by doctor
    public List<Feedback> getFeedbackByDoctor(int doctorID) {
        List<Feedback> feedbacks = new ArrayList<>();
        for (Feedback feedback : feedbackList) {
            if (feedback.getDoctor().getId() == doctorID) {
                feedbacks.add(feedback);
            }
        }
        return feedbacks;
    }
    
    // Method to load feedback from file
    private void loadFeedback() {
        try (BufferedReader br = new BufferedReader(new FileReader(FEEDBACK_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",", 5);
                int feedbackID = Integer.parseInt(data[0]);
                int patientID = Integer.parseInt(data[1]);
                int doctorID = Integer.parseInt(data[2]);
                int rating = Integer.parseInt(data[3]);
                String comments = data[4];
    
                Patient patient = findPatientById(patientID);
                Doctor doctor = findDoctorById(doctorID);
    
                if (patient != null && doctor != null) {
                    Feedback feedback = new Feedback(feedbackID, patient, doctor, comments, rating);
                    feedbackList.add(feedback);
                }
            }
        } catch (IOException e) {
            System.out.println("No existing feedback file found.");
        }
    }
    
    // Method to save feedback to file
    private void saveFeedbackToFile(Feedback feedback) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FEEDBACK_FILE, true))) {
            bw.write(feedback.toFileString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void addReferral(Referral referral) {
        referralList.add(referral);
        saveReferralToFile(referral);
    }
    
    // Method to get referrals by patient
    public List<Referral> getReferralsByPatient(int patientID) {
        List<Referral> referrals = new ArrayList<>();
        for (Referral referral : referralList) {
            if (referral.getPatient().getId() == patientID) {
                referrals.add(referral);
            }
        }
        return referrals;
    }
    
    // Method to load referrals from file
    private void loadReferrals() {
        try (BufferedReader br = new BufferedReader(new FileReader(REFERRAL_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",", 6);
                int referralID = Integer.parseInt(data[0]);
                int patientID = Integer.parseInt(data[1]);
                int referringDoctorID = Integer.parseInt(data[2]);
                int specialistDoctorID = Integer.parseInt(data[3]);
                String reason = data[4];
                Date referralDate = new Date(Long.parseLong(data[5]));
    
                Patient patient = findPatientById(patientID);
                Doctor referringDoctor = findDoctorById(referringDoctorID);
                Doctor specialistDoctor = findDoctorById(specialistDoctorID);
    
                if (patient != null && referringDoctor != null && specialistDoctor != null) {
                    Referral referral = new Referral(referralID, patient, referringDoctor, specialistDoctor, reason, referralDate);
                    referralList.add(referral);
                }
            }
        } catch (IOException e) {
            System.out.println("No existing referrals file found.");
        }
    }
    
    // Method to save a referral to file
    private void saveReferralToFile(Referral referral) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(REFERRAL_FILE, true))) {
            bw.write(referral.toFileString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void addStaffMember(StaffMember staffMember) {
        staffList.add(staffMember);
        saveStaffMemberToFile(staffMember);
    }
    
    // Method to find a staff member by ID
    public StaffMember findStaffMemberById(int id) {
        for (StaffMember staffMember : staffList) {
            if (staffMember.getId() == id) {
                return staffMember;
            }
        }
        return null;
    }
    
    // Method to get all staff members
    public List<StaffMember> getAllStaffMembers() {
        return staffList;
    }
    
    // Load staff members from file
    private void loadStaffMembers() {
        try (BufferedReader br = new BufferedReader(new FileReader(STAFF_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",", 7);
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                String email = data[2];
                String phone = data[3];
                String role = data[4];
                String department = data[5];
                String shift = data[6];
    
                StaffMember staffMember = new StaffMember(id, name, email, phone, role, department, shift);
                staffList.add(staffMember);
            }
        } catch (IOException e) {
            System.out.println("No existing staff members file found.");
        }
    }
    
    // Save staff member to file
    private void saveStaffMemberToFile(StaffMember staffMember) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(STAFF_FILE, true))) {
            bw.write(staffMember.toFileString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void addTreatmentPlan(TreatmentPlan treatmentPlan) {
        treatmentPlanList.add(treatmentPlan);
        saveTreatmentPlanToFile(treatmentPlan);
    }
    
    // Method to get treatment plans by patient
    public List<TreatmentPlan> getTreatmentPlansByPatient(int patientID) {
        List<TreatmentPlan> plans = new ArrayList<>();
        for (TreatmentPlan plan : treatmentPlanList) {
            if (plan.getPatient().getId() == patientID) {
                plans.add(plan);
            }
        }
        return plans;
    }
    
    // Method to load treatment plans from file
    private void loadTreatmentPlans() {
        try (BufferedReader br = new BufferedReader(new FileReader(TREATMENT_PLAN_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",", 7);
                int planID = Integer.parseInt(data[0]);
                int patientID = Integer.parseInt(data[1]);
                String diagnosis = data[2];
                String proceduresStr = data[3];
                String medicationsStr = data[4];
                Date startDate = new Date(Long.parseLong(data[5]));
                Date endDate = new Date(Long.parseLong(data[6]));
    
                Patient patient = findPatientById(patientID);
                if (patient != null) {
                    TreatmentPlan plan = new TreatmentPlan(planID, patient, diagnosis, startDate, endDate);
    
                    if (!proceduresStr.isEmpty()) {
                        String[] procedures = proceduresStr.split(";");
                        for (String procedure : procedures) {
                            plan.addProcedure(procedure);
                        }
                    }
    
                    if (!medicationsStr.isEmpty()) {
                        String[] medications = medicationsStr.split(";");
                        for (String medication : medications) {
                            plan.addMedication(medication);
                        }
                    }
    
                    treatmentPlanList.add(plan);
                }
            }
        } catch (IOException e) {
            System.out.println("No existing treatment plans file found.");
        }
    }
    
    // Method to save treatment plan to file
    private void saveTreatmentPlanToFile(TreatmentPlan treatmentPlan) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(TREATMENT_PLAN_FILE, true))) {
            bw.write(treatmentPlan.toFileString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void addNotification(Notification notification) {
        notificationList.add(notification);
        saveNotificationToFile(notification);
    }
    
    // Method to get notifications by recipient ID
    public List<Notification> getNotificationsByRecipient(int recipientID) {
        List<Notification> notifications = new ArrayList<>();
        for (Notification notification : notificationList) {
            if (notification.getRecipient().getId() == recipientID) {
                notifications.add(notification);
            }
        }
        return notifications;
    }
    
    // Method to load notifications from file
    private void loadNotifications() {
        try (BufferedReader br = new BufferedReader(new FileReader(NOTIFICATION_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",", 4);
                int notificationID = Integer.parseInt(data[0]);
                String message = data[1];
                Date timestamp = new Date(Long.parseLong(data[2]));
                int recipientID = Integer.parseInt(data[3]);
    
                // Assuming recipients can be patients or staff members
                Person recipient = findPatientById(recipientID);
                if (recipient == null) {
                    recipient = findDoctorById(recipientID);
                }
                if (recipient == null) {
                    recipient = findStaffMemberById(recipientID);
                }
    
                if (recipient != null) {
                    Notification notification = new Notification(notificationID, message, timestamp, recipient);
                    notificationList.add(notification);
                }
            }
        } catch (IOException e) {
            System.out.println("No existing notifications file found.");
        }
    }
    
    // Method to save notification to file
    private void saveNotificationToFile(Notification notification) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(NOTIFICATION_FILE, true))) {
            bw.write(notification.toFileString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void addImmunization(Immunization immunization) {
        immunizationList.add(immunization);
        saveImmunizationToFile(immunization);
    }
    
    // Method to get immunizations by patient
    public List<Immunization> getImmunizationsByPatient(int patientID) {
        List<Immunization> immunizations = new ArrayList<>();
        for (Immunization immunization : immunizationList) {
            if (immunization.getPatient().getId() == patientID) {
                immunizations.add(immunization);
            }
        }
        return immunizations;
    }
    
    // Method to load immunizations from file
    private void loadImmunizations() {
        try (BufferedReader br = new BufferedReader(new FileReader(IMMUNIZATION_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",", 5);
                int immunizationID = Integer.parseInt(data[0]);
                int patientID = Integer.parseInt(data[1]);
                String vaccineName = data[2];
                Date administrationDate = new Date(Long.parseLong(data[3]));
                Date nextDoseDue = data[4].equals("null") ? null : new Date(Long.parseLong(data[4]));
    
                Patient patient = findPatientById(patientID);
                if (patient != null) {
                    Immunization immunization = new Immunization(immunizationID, patient, vaccineName, administrationDate, nextDoseDue);
                    immunizationList.add(immunization);
                }
            }
        } catch (IOException e) {
            System.out.println("No existing immunizations file found.");
        }
    }
    
    // Method to save immunization to file
    private void saveImmunizationToFile(Immunization immunization) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(IMMUNIZATION_FILE, true))) {
            bw.write(immunization.toFileString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void addCarePlan(CarePlan carePlan) {
        carePlanList.add(carePlan);
        saveCarePlanToFile(carePlan);
    }
    
    // Method to get all care plans
    public List<CarePlan> getAllCarePlans() {
        return carePlanList;
    }
    
    // Method to subscribe a patient to a care plan
    public void subscribePatientToCarePlan(int planID, int patientID) {
        CarePlan plan = findCarePlanById(planID);
        Patient patient = findPatientById(patientID);
        if (plan != null && patient != null) {
            plan.addSubscriber(patient);
            saveAllCarePlansToFile();
        }
    }
    
    // Method to find a care plan by ID
    public CarePlan findCarePlanById(int planID) {
        for (CarePlan plan : carePlanList) {
            if (plan.getPlanID() == planID) {
                return plan;
            }
        }
        return null;
    }
    
    // Method to load care plans from file
    private void loadCarePlans() {
        try (BufferedReader br = new BufferedReader(new FileReader(CARE_PLAN_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",", 5);
                int planID = Integer.parseInt(data[0]);
                String planName = data[1];
                String description = data[2];
                double price = Double.parseDouble(data[3]);
                String subscribersStr = data.length > 4 ? data[4] : "";
    
                CarePlan plan = new CarePlan(planID, planName, description, price);
    
                if (!subscribersStr.isEmpty()) {
                    String[] subscriberIDs = subscribersStr.split(";");
                    for (String idStr : subscriberIDs) {
                        int patientID = Integer.parseInt(idStr);
                        Patient patient = findPatientById(patientID);
                        if (patient != null) {
                            plan.addSubscriber(patient);
                        }
                    }
                }
    
                carePlanList.add(plan);
            }
        } catch (IOException e) {
            System.out.println("No existing care plans file found.");
        }
    }
    
    // Method to save a care plan to file
    private void saveCarePlanToFile(CarePlan carePlan) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(CARE_PLAN_FILE, true))) {
            bw.write(carePlan.toFileString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // Method to save all care plans to file
    private void saveAllCarePlansToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(CARE_PLAN_FILE))) {
            for (CarePlan plan : carePlanList) {
                bw.write(plan.toFileString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void addHealthRiskAssessment(HealthRiskAssessment assessment) {
        assessmentList.add(assessment);
        saveAssessmentToFile(assessment);
    }
    
    // Method to get assessments by patient
    public List<HealthRiskAssessment> getAssessmentsByPatient(int patientID) {
        List<HealthRiskAssessment> assessments = new ArrayList<>();
        for (HealthRiskAssessment assessment : assessmentList) {
            if (assessment.getPatient().getId() == patientID) {
                assessments.add(assessment);
            }
        }
        return assessments;
    }
    
    // Method to load assessments from file
    private void loadAssessments() {
        try (BufferedReader br = new BufferedReader(new FileReader(ASSESSMENT_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",", 6);
                int assessmentID = Integer.parseInt(data[0]);
                int patientID = Integer.parseInt(data[1]);
                String lifestyleFactors = data[2];
                String medicalHistory = data[3];
                String riskLevel = data[4];
                String recommendations = data[5];
    
                Patient patient = findPatientById(patientID);
                if (patient != null) {
                    HealthRiskAssessment assessment = new HealthRiskAssessment(assessmentID, patient, lifestyleFactors, medicalHistory);
                    // Manually set risk level and recommendations to match saved data
                    // CRMSystem.java

                    assessment.setRiskLevel(riskLevel);
                    assessment.setRecommendations(recommendations);

                    assessmentList.add(assessment);
                }
            }
        } catch (IOException e) {
            System.out.println("No existing health risk assessments file found.");
        }
    }
    
    // Method to save an assessment to file
    private void saveAssessmentToFile(HealthRiskAssessment assessment) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ASSESSMENT_FILE, true))) {
            bw.write(assessment.toFileString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
