package entities;

public class Doctor extends Person {

    private String specialization;
    private int experienceYears;
    private double consultationFee;

    private String[] availableSlots = new String[100];
    private int slotCount = 0;

    private String[] assignedPatientIds = new String[50];
    private int patientCount = 0;

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
            int age,
            boolean active,
            String specialization,
            int experienceYears,
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
                nationalId,
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
        System.out.println("Available Slots: " + slotCount);
        System.out.println("Assigned Patients: " + patientCount);
        System.out.println("On Call: " + onCall);
    }


    public void addSlot(String slot) {

        if (slot == null || slot.trim().isEmpty()) {
            System.out.println("Slot cannot be empty.");
            return;
        }

        if (slotCount >= availableSlots.length) {
            System.out.println("No space for more slots.");
            return;
        }

        availableSlots[slotCount] = slot;
        slotCount++;
    }


    public boolean hasSlot(String slot) {

        for (int i = 0; i < slotCount; i++) {

            if (availableSlots[i].equalsIgnoreCase(slot)) {
                return true;
            }
        }

        return false;
    }


    public void removeSlot(String slot) {

        for (int i = 0; i < slotCount; i++) {

            if (availableSlots[i].equalsIgnoreCase(slot)) {

                for (int j = i; j < slotCount - 1; j++) {
                    availableSlots[j] = availableSlots[j + 1];
                }

                availableSlots[slotCount - 1] = null;
                slotCount--;

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

        if (patientCount >= assignedPatientIds.length) {
            System.out.println("Cannot assign more patients.");
            return;
        }

        assignedPatientIds[patientCount] = patientId;
        patientCount++;
    }


    public int getPatientLoad() {
        return patientCount;
    }


    public void raiseFee(double amount) {

        if (amount <= 0) {
            System.out.println("Fee increase must be greater than zero.");
            return;
        }

        consultationFee += amount;
    }
}