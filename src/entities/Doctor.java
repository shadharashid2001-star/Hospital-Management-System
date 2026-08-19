package entities;

import java.util.Arrays;

public class Doctor extends Person{
   private String specialization;
   private Integer experienceYears;
   private double consultationFee;
   private  String availableslots= new String[100];
   private Integer slotcount;
    private Integer patientCount;
    private boolean onCall;


    public Doctor(String id,
                  String firstName,
                  String dateOfBirth,
                  String gender,
                  String phoneNumber,
                  String email,
                  String address,
                  String nationalId,
                  Integer age,
                  boolean active
                  String specialization,
                  int experienceYears,
                  double consultationFee,
                  boolean onCall)
    {
        super(id,
                firstName,
                dateOfBirth,
                gender,
                phoneNumber,
                email,
                address,
                nationalId,
                age,
                active);

        this.specialization  =  specialization;
        this.experienceYears = experienceYears;
        setSpecialization(specialization);
        setExperienceYears(experienceYears);
        setConsultationFee(consultationFee);
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public Integer getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(Integer experienceYears) {
        if (experienceYears<0 ){
            System.out.println("cannot be negative");
        }
        this.experienceYears = experienceYears;
    }


    public double getConsultationFee() {
        return consultationFee;
    }

    public void setConsultationFee(double consultationFee) {
        if (consultationFee<0){
            System.out.println(" must be +");
        }
        this.consultationFee = consultationFee;
    }

    public String getAvailableslots() {
        return availableslots;
    }

    public void setAvailableslots(String availableslots) {
        this.availableslots = availableslots;
    }

    public Integer getSlotcount() {
        return slotcount;
    }

    public void setSlotcount(Integer slotcount) {
        this.slotcount = slotcount;
    }

    public Integer getPatientCount() {
        return patientCount;
    }

    public void setPatientCount(Integer patientCount) {
        this.patientCount = patientCount;
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
        System.out.println("specialization:"+specialization);
        System.out.println("experienceYears"+experienceYears);
        System.out.println("consultationFee"+consultationFee);
        System.out.println(" available time-slots"+availableslots);
    }
    public void addSlot(String slot){
        if(slot==null || slot.trim().isEmpty()){
            System.out.println("cannot be empty");
            return;
        }
        if (slot >= availableslots.length()){
            System.out.println("no slot space");
            return;
        }
        availableslots[slotcount]=slot;
        slotcount++;
    }
public boolean hasSlot(String slot){
    for (int i = 0; i < slotcount; i++) {
        if (availableslots[i].eqalsIgnoreCase(slot)){
            return true;
        }

    }
    return false;
}
    public void removeSlot(String slot) {

        for (int i = 0; i < slotcount; i++) {

            if (availableslots[i].equalsIgnoreCase(slot)) {

                for (int j = i; j <  slotcount- 1; j++) {

                    availableslots[j] =
                            availableslots[j + 1];
                }

                availableslots[slotcount - 1] = null;

                slotcount--;

                return;
            }
        }
        System.out.println("Slot not found.");
    }
}
