package entities;

import java.util.ArrayList;

public class Doctor extends Person {

    private String specialization;
    private Integer experienceYears;
    private double consultationFee;

    private ArrayList<String> availableSlots = new ArrayList<>();
    private ArrayList<String> assignedPatientIds = new ArrayList<>();

    private boolean onCall;


    public Doctor(
            String id,
            String firstName,
            String lastName,
            String dateOfBirth,
            String gender,
            String phoneNumber,
            String email,
            String address,
            String nationalId,
            Integer age,
            boolean active,
            String specialization,
            Integer experienceYears,
            double consultationFee,
            boolean onCall) {

        super(
                id,
                firstName,
                lastName,
                dateOfBirth,
                gender,
                phoneNumber,
                email,
                address,
                age,
                active
        );

        setSpecialization(specialization);
        setExperienceYears(experienceYears);
        setConsultationFee(consultationFee);
        setOnCall(onCall);
    }


    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {

        if (specialization == null
                || specialization.trim().isEmpty()) {

            System.out.println("Specialization cannot be empty.");
            return;
        }

        this.specialization = specialization;
    }


    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {

        if (experienceYears < 0) {
            System.out.println("Experience years cannot be negative.");
            return;
        }

        this.experienceYears = experienceYears;
    }


    public double getConsultationFee() {
        return consultationFee;
    }

    public void setConsultationFee(double consultationFee) {

        if (consultationFee < 0) {
            System.out.println("Consultation fee cannot be negative.");
            return;
        }

        this.consultationFee = consultationFee;
    }


    public boolean isOnCall() {
        return onCall;
    }

    public void setOnCall(boolean onCall) {
        this.onCall = onCall;
    }


    @Override
    public void displayInfo() {

        super.displayInfo();

        System.out.println("Specialization: " + specialization);
        System.out.println("Experience Years: " + experienceYears);
        System.out.println("Consultation Fee: " + consultationFee);
        System.out.println("Available Slots: " + availableSlots);
        System.out.println("Assigned Patients: " + assignedPatientIds.size());
        System.out.println("On Call: " + onCall);
    }


    public void addSlot(String slot) {

        if (slot == null || slot.trim().isEmpty()) {
            System.out.println("Slot cannot be empty.");
            return;
        }

        availableSlots.add(slot);
    }


    public boolean hasSlot(String slot) {

        for (String availableSlot : availableSlots) {

            if (availableSlot.equalsIgnoreCase(slot)) {
                return true;
            }
        }

        return false;
    }


    public void removeSlot(String slot) {

        for (int i = 0; i < availableSlots.size(); i++) {

            if (availableSlots.get(i).equalsIgnoreCase(slot)) {

                availableSlots.remove(i);

                return;
            }
        }

        System.out.println("Slot not found.");
    }


    public void assignPatient(String patientId) {

        if (patientId == null || patientId.trim().isEmpty()) {
            System.out.println("Patient ID cannot be empty.");
            return;
        }

        assignedPatientIds.add(patientId);
    }


    public int getPatientLoad() {

        return assignedPatientIds.size();
    }


    public void raiseFee(double amount) {

        if (amount <= 0) {
            System.out.println("Fee increase must be greater than zero.");
            return;
        }

        consultationFee += amount;
    }
}