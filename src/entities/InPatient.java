package entities;

public class InPatient extends Patient {
  private String admissionDate;
  private Integer  roomNumber;
  private double dailyCharges;
  private Integer daysAdmitted;


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

        setAdmissionDate(admissionDate)
        setAdmissionDate(admissionDate);
        setDailyCharges(dailyCharges);
        setDaysAdmitted(daysAdmitted);
    }


    public String getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(String admissionDate) {
        this.admissionDate = admissionDate;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public double getDailyCharges() {
        return dailyCharges;
    }

    public void setDailyCharges(double dailyCharges) {
        this.dailyCharges = dailyCharges;
    }

    public Integer getDaysAdmitted() {
        return daysAdmitted;
    }

    public void setDaysAdmitted(Integer daysAdmitted) {
        this.daysAdmitted = daysAdmitted;
    }

}
