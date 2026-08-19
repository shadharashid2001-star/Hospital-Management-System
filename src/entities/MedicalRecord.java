package entities;

public class MedicalRecord {

    private String recordId;
    private String patientId;
    private String doctorId;
    private String visitDate;
    private String diagnosis;
    private String prescription;
    private String notes;
    private boolean isConfidential;


    public MedicalRecord(
            String recordId,
            String patientId,
            String doctorId,
            String visitDate,
            String diagnosis,
            String prescription,
            String notes,
            boolean isConfidential) {

        setRecordId(recordId);
        setPatientId(patientId);
        setDoctorId(doctorId);
        setVisitDate(visitDate);
        setDiagnosis(diagnosis);
        setPrescription(prescription);
        setNotes(notes);
        setConfidential(isConfidential);
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        if (recordId == null || recordId.trim().isEmpty()) {
            System.out.println("Record ID cannot be empty.");
            return;
        }

        this.recordId = recordId;
    }
    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        if (patientId == null || patientId.trim().isEmpty()) {
            System.out.println("Patient ID cannot be empty.");
            return;
        }

        this.patientId = patientId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        if (doctorId == null || doctorId.trim().isEmpty()) {
        System.out.println("Doctor ID cannot be empty.");
        return;
    }

        this.doctorId = doctorId;
}

    public String getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(String visitDate) {

        if (visitDate == null || visitDate.trim().isEmpty()) {
            System.out.println("Visit date cannot be empty.");
            return;
        }

        this.visitDate = visitDate;
    }
    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public boolean isConfidential() {
        return isConfidential;
    }

    public void setConfidential(boolean confidential) {
        isConfidential = confidential;
    }
    
}
