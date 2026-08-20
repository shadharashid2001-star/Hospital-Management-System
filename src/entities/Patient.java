package entities;

import java.util.ArrayList;
import utils.HelperUtils;

public class Patient extends Person {

    private String bloodGroup;
    private String emergencyContact;
    private String registrationDate;

    private ArrayList allergies = new ArrayList();
    private ArrayList recordIds = new ArrayList();

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
                nationalId,
                age,
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

        if (!HelperUtils.isValidText(bloodGroup)) {
            System.out.println("Blood group cannot be empty.");
            return;
        }

        this.bloodGroup = bloodGroup;
    }


    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {

        if (!HelperUtils.isValidText(emergencyContact)) {
            System.out.println("Emergency contact cannot be empty.");
            return;
        }

        this.emergencyContact = emergencyContact;
    }


    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {

        if (!HelperUtils.isValidText(registrationDate)) {
            System.out.println("Registration date cannot be empty.");
            return;
        }

        this.registrationDate = registrationDate;
    }


    public ArrayList getAllergies() {
        return allergies;
    }


    public ArrayList getRecordIds() {
        return recordIds;
    }


    public double getOutstandingBalance() {
        return outstandingBalance;
    }

    public void setOutstandingBalance(double outstandingBalance) {

        if (!HelperUtils.isPositive(outstandingBalance)) {
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

        if (!HelperUtils.isValidText(allergy)) {
            System.out.println("Allergy cannot be empty.");
            return;
        }

        allergies.add(allergy);
    }


    public boolean hasAllergy(String allergy) {

        for (Object item : allergies) {

            String storedAllergy = (String) item;

            if (storedAllergy.equalsIgnoreCase(allergy)) {
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

        for (Object item : allergies) {

            String allergy = (String) item;

            System.out.println(allergy);
        }
    }


    public void addRecordId(String recordId) {

        if (!HelperUtils.isValidText(recordId)) {
            System.out.println("Record ID cannot be empty.");
            return;
        }

        recordIds.add(recordId);
    }


    public Integer getRecordCount() {
        return recordIds.size();
    }


    public void addToBalance(double amount) {

        if (!HelperUtils.isPositive(amount)) {
            System.out.println("Amount cannot be negative.");
            return;
        }

        outstandingBalance += amount;
    }


    public void clearBalance() {
        outstandingBalance = 0;
    }


    public void updateContact(String phone) {

        setPhoneNumber(phone);
    }


    public void updateContact(
            String phone,
            String email) {

        setPhoneNumber(phone);
        setEmail(email);
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
        System.out.println("Insured: " + insured);
    }
}