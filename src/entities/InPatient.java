package entities;

public class InPatient extends Patient {

    public InPatient(String id,
                     String firstName,
                     String lastName,
                     String dateOfBirth,
                     String gender,
                     String phone,
                     String email, String address
                     , String nationalId,
                     int age,
                     boolean active,
                     String bloodGroup,
                     String emergencyContact,
                     String registrationDate,
                     double outstandingBalance,
                     boolean insured) {
        super(id,
                firstName,
                lastName,
                dateOfBirth,
                gender,
                phone,
                email,
                address,
                nationalId,
                age, active, bloodGroup, emergencyContact, registrationDate, outstandingBalance, insured);
    }
}
