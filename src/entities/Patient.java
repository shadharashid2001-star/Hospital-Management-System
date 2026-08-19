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
}
