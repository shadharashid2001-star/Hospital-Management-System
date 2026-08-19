package entities;

public class Patient extends Person {
    private String bloodGroup;
    private String emergencyContact;
    private String registrationDate;

    private String[] allergies = new String[50];
    private int allergyCount;

    private String[] recordIds = new String[100];
    private int recordCount;

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
            int age,
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
                active);
        this.bloodGroup = bloodGroup;
        this.emergencyContact = emergencyContact;
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

    public String[] getAllergies() {
        return allergies;
    }

    public void setAllergies(String[] allergies) {
        this.allergies = allergies;
    }

    public int getAllergyCount() {
        return allergyCount;
    }

    public void setAllergyCount(int allergyCount) {
        this.allergyCount = allergyCount;
    }

    public String[] getRecordIds() {
        return recordIds;
    }

    public void setRecordIds(String[] recordIds) {
        this.recordIds = recordIds;
    }

    public int getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(int recordCount) {
        this.recordCount = recordCount;
    }

    public double getOutstandingBalance() {
        return outstandingBalance;
    }

    public void setOutstandingBalance(double outstandingBalance) {
        this.outstandingBalance = outstandingBalance;
    }

    public boolean isInsured() {
        return insured;
    }

    public void setInsured(boolean insured) {
        this.insured = insured;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println(
                "Blood Group: " + bloodGroup);

        System.out.println(
                "Emergency Contact: "
                        + emergencyContact);

        System.out.println(
                "Registration Date: "
                        + registrationDate);

        System.out.println(
                "Outstanding Balance: "
                        + outstandingBalance);

        System.out.println(
                "Insured: " + insured);
    }
    }
}
