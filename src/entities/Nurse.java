package entities;

import java.util.ArrayList;

public class Nurse extends Person {
 private String departmentId;
 private  String  shift;
 private ArrayList<String> assignedPatientIds= new ArrayList<>();
 private Integer yearsOfService;


    public Nurse(String id,
                 String firstName,
                 String dateOfBirth,
                 String gender,
                 String phoneNumber,
                 String email,
                 String address,
                 String nationalId,
                 Integer age,
                 boolean active) {
        super(id,
                firstName,
                dateOfBirth,
                gender,
                phoneNumber,
                email,
                address,
                nationalId,
                age,
                active);
        setDepartmentId(departmentId);
        setShift(shift);
        setYearsOfService(yearsOfService);
    }


    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public ArrayList<String> getAssignedPatientIds() {
        return assignedPatientIds;
    }

    public void setAssignedPatientIds(ArrayList<String> assignedPatientIds) {
        this.assignedPatientIds = assignedPatientIds;
    }

    public Integer getYearsOfService() {
        return yearsOfService;
    }

    public void setYearsOfService(Integer yearsOfService) {
        this.yearsOfService = yearsOfService;
    }
    @Override
    public void displayInfo() {

        super.displayInfo();

        System.out.println("Department ID: " + departmentId);
        System.out.println("Shift: " + shift);
        System.out.println("Assigned Patients: " + assignedPatientIds);
        System.out.println("Years of Service: " + yearsOfService);
    }
    public void assignPatient(String patientId) {

        if (patientId == null || patientId.trim().isEmpty()) {
            System.out.println("Patient ID cannot be empty.");
            return;
        }

        if (assignedPatientIds.contains(patientId)) {
            System.out.println("Patient already assigned.");
            return;
        }

        assignedPatientIds.add(patientId);
    }
    public void unassignPatient(String patientId) {

        if (assignedPatientIds.remove(patientId)) {
            System.out.println("Patient unassigned.");
        } else {
            System.out.println("Patient not found.");
        }

    }
    public Integer getPatientLoad() {
        return assignedPatientIds.size();
    }
    public boolean isNightShift() {
        return shift != null && shift.equalsIgnoreCase("Night");
    }
}
