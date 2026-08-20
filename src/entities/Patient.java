package entities;

import java.util.ArrayList;

public class Patient extends Person {

    private String bloodGroup;
    private String emergencyContact;
    private String registrationDate;

    private ArrayList<String> allergies = new ArrayList<>();
    private ArrayList<String> recordIds = new ArrayList<>();

    private double outstandingBalance;
    private boolean insured;


    public Patient(
            String id,
            String firstName,
            String lastName,
            String dateOfBirth,
            String gender,
            String phone,
            String email,
            String address,
            String nationalId,
            Integer age,
            boolean active,
            String bloodGroup,
            String emergencyContact,
            String registrationDate,
            double outstandingBalance,
            boolean insured) {

        super(
                id,
                firstName,
                lastName,
                dateOfBirth,
                gender,
                phone,
                email,
                address,
                nationalId, age,
                active
        );

        setBloodGroup(bloodGroup);
        setEmergencyContact(emergencyContact);
        setRegistrationDate(registrationDate);
        setOutstandingBalance(outstandingBalance);
        setInsured(insured);
    }


    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }


    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }


    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }


    public ArrayList<String> getAllergies() {
        return allergies;
    }

    public void setAllergies(ArrayList<String> allergies) {
        this.allergies = allergies;
    }


    public ArrayList<String> getRecordIds() {
        return recordIds;
    }

    public void setRecordIds(ArrayList<String> recordIds) {
        if (recordIds==null || recordIds.isEmpty()){
            System.out.println("recorded must not empty");
        }
        this.recordIds = recordIds;
    }


    public double getOutstandingBalance() {
        return outstandingBalance;
    }

    public void setOutstandingBalance(double outstandingBalance) {

        if (outstandingBalance < 0) {
            System.out.println("Balance cannot be negative.");
            return;
        }

        this.outstandingBalance = outstandingBalance;
    }


    public boolean isInsured() {
        return insured;
    }

    public void setInsured(boolean insured) {
        this.insured = insured;
    }


    public void addAllergy(String allergy) {

        if (allergy == null || allergy.trim().isEmpty()) {
            System.out.println("Allergy cannot be empty.");
            return;
        }

        allergies.add(allergy);
    }


    public boolean hasAllergy(String allergy) {

        for (String item : allergies) {

            if (item.equalsIgnoreCase(allergy)) {
                return true;
            }
        }

        return false;
    }


    public void listAllergies() {

        if (allergies.isEmpty()) {
            System.out.println("No allergies.");
            return;
        }

        for (String allergy : allergies) {
            System.out.println(allergy);
        }
    }


    public void addRecordId(String recordId) {

        if (recordId == null || recordId.trim().isEmpty()) {
            System.out.println("Record ID cannot be empty.");
            return;
        }

        recordIds.add(recordId);
    }


    public Integer getRecordCount() {
        return recordIds.size();
    }


    public void addToBalance(double amount) {

        if (amount < 0) {
            System.out.println("Amount cannot be negative.");
            return;
        }

        outstandingBalance += amount;
    }


    public void clearBalance() {
        outstandingBalance = 0;
    }


    @Override
    public void displayInfo() {

        super.displayInfo();

        System.out.println("Blood Group: " + bloodGroup);
        System.out.println("Emergency Contact: " + emergencyContact);
        System.out.println("Registration Date: " + registrationDate);
        System.out.println("Allergies: " + allergies);
        System.out.println("Record Count: " + recordIds.size());
        System.out.println("Outstanding Balance: " + outstandingBalance);
        System.out.println("Insured:; " + insured);
    }
}