package entities;

public class InPatient extends Patient {

    private String admissionDate;
    private String roomNumber;
    private double dailyCharges;
    private Integer daysAdmitted;
    private boolean admitted;


    public InPatient(
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
            boolean insured,
            String admissionDate,
            String roomNumber,
            double dailyCharges,
            Integer daysAdmitted) {

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
                active,
                bloodGroup,
                emergencyContact,
                registrationDate,
                outstandingBalance,
                insured
        );

        setAdmissionDate(admissionDate);
        setRoomNumber(roomNumber);
        setDailyCharges(dailyCharges);
        setDaysAdmitted(daysAdmitted);

        admitted = true;
    }


    public String getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(String admissionDate) {

        if (admissionDate == null || admissionDate.trim().isEmpty()) {
            System.out.println("Admission date cannot be empty.");
            return;
        }

        this.admissionDate = admissionDate;
    }


    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {

        if (roomNumber == null || roomNumber.trim().isEmpty()) {
            System.out.println("Room number cannot be empty.");
            return;
        }

        this.roomNumber = roomNumber;
    }


    public double getDailyCharges() {
        return dailyCharges;
    }

    public void setDailyCharges(double dailyCharges) {

        if (dailyCharges < 0) {
            System.out.println("Daily charges cannot be negative.");
            return;
        }

        this.dailyCharges = dailyCharges;
    }


    public Integer getDaysAdmitted() {
        return daysAdmitted;
    }

    public void setDaysAdmitted(Integer daysAdmitted) {

        if (daysAdmitted == null || daysAdmitted < 0) {
            System.out.println("Days admitted cannot be negative.");
            return;
        }

        this.daysAdmitted = daysAdmitted;
    }


    public boolean isAdmitted() {
        return admitted;
    }


    @Override
    public void displayInfo() {

        super.displayInfo();

        System.out.println("Admission Date: " + admissionDate);
        System.out.println("Room Number: " + roomNumber);
        System.out.println("Daily Charges: " + dailyCharges);
        System.out.println("Days Admitted: " + daysAdmitted);
        System.out.println("Admitted: " + admitted);
        System.out.println("Total Room Cost: " + totalRoomCost());
    }


    public void admit(
            String admissionDate,
            String roomNumber,
            Integer daysAdmitted) {

        setAdmissionDate(admissionDate);
        setRoomNumber(roomNumber);
        setDaysAdmitted(daysAdmitted);

        admitted = true;
    }


    public void discharge() {

        admitted = false;
        admissionDate = null;
        roomNumber = null;
        daysAdmitted = 0;
    }


    public double totalRoomCost() {

        return dailyCharges * daysAdmitted;
    }
}