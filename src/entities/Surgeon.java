package entities;

import java.util.ArrayList;

public class Surgeon extends Doctor {

    private Integer surgeriesPerformed;
    private boolean operationTheatreAccess;
    private ArrayList<String> upcomingSurgeryDates = new ArrayList<>();


    public Surgeon(
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
            boolean onCall,
            Integer surgeriesPerformed,
            boolean operationTheatreAccess) {

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
                active,
                specialization,
                experienceYears,
                consultationFee,
                onCall
        );

        setSurgeriesPerformed(surgeriesPerformed);
        setOperationTheatreAccess(operationTheatreAccess);
    }


    public Integer getSurgeriesPerformed() {
        return surgeriesPerformed;
    }

    public void setSurgeriesPerformed(Integer surgeriesPerformed) {

        if (surgeriesPerformed == null || surgeriesPerformed < 0) {
            System.out.println("Surgeries performed cannot be negative.");
            return;
        }

        this.surgeriesPerformed = surgeriesPerformed;
    }


    public boolean isOperationTheatreAccess() {
        return operationTheatreAccess;
    }

    public void setOperationTheatreAccess(boolean operationTheatreAccess) {
        this.operationTheatreAccess = operationTheatreAccess;
    }


    public ArrayList<String> getUpcomingSurgeryDates() {
        return upcomingSurgeryDates;
    }


    @Override
    public void displayInfo() {

        super.displayInfo();

        System.out.println("Surgeries Performed: " + surgeriesPerformed);
        System.out.println("Operation Theatre Access: " + operationTheatreAccess);
        System.out.println("Upcoming Surgery Dates: " + upcomingSurgeryDates);
    }


    public void performSurgery() {
        surgeriesPerformed++;
    }


    public void scheduleSurgery(String date) {

        if (date == null || date.trim().isEmpty()) {
            System.out.println("Surgery date cannot be empty.");
            return;
        }

        upcomingSurgeryDates.add(date);
    }


    public Integer getUpcomingCount() {
        return upcomingSurgeryDates.size();
    }
}