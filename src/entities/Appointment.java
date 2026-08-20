package entities;

import interfaces.Displayable;

public class Appointment implements Displayable {

    private String appointmentId;
    private String patientId;
    private String doctorId;
    private String appointmentDate;
    private String appointmentTime;
    private String status;
    private String reason;
    private boolean isFollowUp;


    public Appointment(
            String appointmentId,
            String patientId,
            String doctorId,
            String appointmentDate,
            String appointmentTime,
            String status,
            String reason,
            boolean isFollowUp) {

        setAppointmentId(appointmentId);
        setPatientId(patientId);
        setDoctorId(doctorId);
        setAppointmentDate(appointmentDate);
        setAppointmentTime(appointmentTime);
        setStatus(status);
        setReason(reason);
        setFollowUp(isFollowUp);
    }


    public String getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(String appointmentId) {

        if (appointmentId == null || appointmentId.trim().isEmpty()) {
            System.out.println("Appointment ID cannot be empty.");
            return;
        }

        this.appointmentId = appointmentId;
    }


    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {

        if (patientId == null || patientId.trim().isEmpty()) {
            System.out.println("Patient ID cannot be empty.");
            return;
        }

        this.patientId = patientId;
    }


    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {

        if (doctorId == null || doctorId.trim().isEmpty()) {
            System.out.println("Doctor ID cannot be empty.");
            return;
        }

        this.doctorId = doctorId;
    }


    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {

        if (appointmentDate == null || appointmentDate.trim().isEmpty()) {
            System.out.println("Appointment date cannot be empty.");
            return;
        }

        this.appointmentDate = appointmentDate;
    }


    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {

        if (appointmentTime == null || appointmentTime.trim().isEmpty()) {
            System.out.println("Appointment time cannot be empty.");
            return;
        }

        this.appointmentTime = appointmentTime;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {

        if (status == null || status.trim().isEmpty()) {
            System.out.println("Status cannot be empty.");
            return;
        }

        if (!status.equalsIgnoreCase("Scheduled")
                && !status.equalsIgnoreCase("Cancelled")
                && !status.equalsIgnoreCase("Completed")
                && !status.equalsIgnoreCase("Rescheduled")) {

            System.out.println("Invalid appointment status.");
            return;
        }

        this.status = status;
    }


    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }


    public boolean isFollowUp() {
        return isFollowUp;
    }

    public void setFollowUp(boolean followUp) {
        isFollowUp = followUp;
    }


    @Override
    public void displayInfo() {

        System.out.println("Appointment ID: " + appointmentId);
        System.out.println("Patient ID: " + patientId);
        System.out.println("Doctor ID: " + doctorId);
        System.out.println("Appointment Date: " + appointmentDate);
        System.out.println("Appointment Time: " + appointmentTime);
        System.out.println("Status: " + status);
        System.out.println("Reason: " + reason);
        System.out.println("Follow Up: " + isFollowUp);
    }


    @Override
    public void displaySummary() {

        System.out.println(
                "Appointment: " + appointmentId
                        + " - " + appointmentDate
                        + " " + appointmentTime
        );
    }


    public void cancel() {
        setStatus("Cancelled");
    }


    public void complete() {
        setStatus("Completed");
    }


    public void reschedule(String newDate, String newTime) {

        setAppointmentDate(newDate);
        setAppointmentTime(newTime);
        setStatus("Rescheduled");
    }


    public boolean isPast(String givenDate) {

        return appointmentDate.compareTo(givenDate) < 0;
    }
}