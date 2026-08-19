package entities;

public class Appointment {
   private String appointmentId;
   private String patientId;
   private String doctorId;
   private String  appointmentDate;
   private String appointmentTime;
   private String status;
   private String reason;
   private boolean isFollowUp;

   public Appointment
       ( String appointmentId,
         String patientId,
         String doctorId,
         String  appointmentDate,
         String appointmentTime,
         String status,
         String reason,
         boolean isFollowUp
               ){

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
        this.appointmentId = appointmentId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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
    public String displayInfo() {
        return "Appointment{" +
                "appointmentId='" + appointmentId + '\'' +
                ", patientId='" + patientId + '\'' +
                ", doctorId='" + doctorId + '\'' +
                ", appointmentDate='" + appointmentDate + '\'' +
                ", appointmentTime='" + appointmentTime + '\'' +
                ", status='" + status + '\'' +
                ", reason='" + reason + '\'' +
                ", isFollowUp=" + isFollowUp +
                '}';
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
}
