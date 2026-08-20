package main;

import entities.Patient;
import entities.Doctor;
import entities.Surgeon;
import entities.Nurse;
import entities.Appointment;
import entities.MedicalRecord;

import services.PatientService;
import services.DoctorService;
import services.NurseService;
import services.AppointmentService;
import services.RecordService;

import utils.InputHandler;

import java.util.ArrayList;

public class HospitalApp {

    private InputHandler input =
            new InputHandler();

    private PatientService patientService =
            new PatientService();

    private DoctorService doctorService =
            new DoctorService();

    private NurseService nurseService =
            new NurseService();

    private AppointmentService appointmentService =
            new AppointmentService();

    private RecordService recordService =
            new RecordService();


    public static void main(String[] args) {

        HospitalApp app =
                new HospitalApp();

        app.start();
    }


    public void start() {

        boolean running = true;

        while (running) {

            showMainMenu();

            int choice = input.readInt(
                    "Choose an option",
                    1,
                    7
            );

            if (choice == 1) {

                patientMenu();

            } else if (choice == 2) {

                doctorMenu();

            } else if (choice == 3) {

                nurseMenu();

            } else if (choice == 4) {

                appointmentMenu();

            } else if (choice == 5) {

                recordMenu();

            } else if (choice == 6) {

                reportsMenu();

            } else if (choice == 7) {

                System.out.println(
                        "Exiting Hospital Management System."
                );

                running = false;
            }
        }
    }


    public void showMainMenu() {

        System.out.println();
        System.out.println(
                "===== Hospital Management System ====="
        );

        System.out.println("1. Patients");
        System.out.println("2. Doctors");
        System.out.println("3. Nurses");
        System.out.println("4. Appointments");
        System.out.println("5. Medical Records");
        System.out.println("6. Reports");
        System.out.println("7. Exit");
    }


    public void patientMenu() {

        System.out.println("Patient menu already added.");
    }


    public void doctorMenu() {

        System.out.println("Doctor menu already added.");
    }


    public void nurseMenu() {

        boolean back = false;

        while (!back) {

            System.out.println();
            System.out.println(
                    "===== Nurse Menu ====="
            );

            System.out.println("1. Add Nurse");
            System.out.println("2. View All Nurses");
            System.out.println("3. Search Nurse");
            System.out.println("4. Remove Nurse");
            System.out.println("5. List By Shift");
            System.out.println("6. Reassign Patient");
            System.out.println("7. Back");

            int choice =
                    input.readInt(
                            "Choose an option",
                            1,
                            7
                    );

            if (choice == 1) {

                addNurseHandler();

            } else if (choice == 2) {

                viewNursesHandler();

            } else if (choice == 3) {

                searchNurseHandler();

            } else if (choice == 4) {

                removeNurseHandler();

            } else if (choice == 5) {

                listNursesByShiftHandler();

            } else if (choice == 6) {

                reassignNurseHandler();

            } else if (choice == 7) {

                back = true;
            }
        }
    }


    public void addNurseHandler() {

        String id =
                input.readText("Nurse ID");

        String firstName =
                input.readText("First Name");

        String lastName =
                input.readText("Last Name");

        String dateOfBirth =
                input.readText("Date of Birth");

        String gender =
                input.readText("Gender");

        String phone =
                input.readText("Phone");

        String email =
                input.readText("Email");

        String address =
                input.readText("Address");

        String nationalId =
                input.readText("National ID");

        int age =
                input.readInt("Age", 0, 120);

        String departmentId =
                input.readText("Department ID");

        String[] shifts = {
                "Morning",
                "Evening",
                "Night"
        };

        String shift =
                input.readOneOf(
                        "Shift",
                        shifts
                );

        int yearsOfService =
                input.readInt(
                        "Years of Service"
                );

        Nurse nurse = new Nurse(
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
                true,
                departmentId,
                shift,
                yearsOfService
        );

        nurseService.add(nurse);

        System.out.println(
                "Nurse added successfully."
        );
    }


    public void viewNursesHandler() {

        Object[] nurses =
                nurseService.getAll();

        if (nurses.length == 0) {

            System.out.println(
                    "No nurses found."
            );

            return;
        }

        for (int i = 0; i < nurses.length; i++) {

            Nurse nurse =
                    (Nurse) nurses[i];

            nurse.displayInfo();
        }
    }


    public void searchNurseHandler() {

        String keyword =
                input.readText("Search keyword");

        Object[] results =
                nurseService.search(keyword);

        if (results.length == 0) {

            System.out.println(
                    "No nurses found."
            );

            return;
        }

        for (int i = 0; i < results.length; i++) {

            Nurse nurse =
                    (Nurse) results[i];

            nurse.displayInfo();
        }
    }


    public void removeNurseHandler() {

        String id =
                input.readText("Nurse ID");

        boolean removed =
                nurseService.removeById(id);

        if (removed) {

            System.out.println(
                    "Nurse removed."
            );

        } else {

            System.out.println(
                    "Nurse not found."
            );
        }
    }


    public void listNursesByShiftHandler() {

        String[] shifts = {
                "Morning",
                "Evening",
                "Night"
        };

        String shift =
                input.readOneOf(
                        "Shift",
                        shifts
                );

        ArrayList results =
                nurseService.listByShift(shift);

        if (results.isEmpty()) {

            System.out.println(
                    "No nurses found for this shift."
            );

            return;
        }

        for (int i = 0; i < results.size(); i++) {

            Nurse nurse =
                    (Nurse) results.get(i);

            nurse.displayInfo();
        }
    }


    public void reassignNurseHandler() {

        String nurseId =
                input.readText("Nurse ID");

        String oldPatientId =
                input.readText("Old Patient ID");

        String newPatientId =
                input.readText("New Patient ID");

        boolean success =
                nurseService.reassign(
                        nurseId,
                        oldPatientId,
                        newPatientId
                );

        if (success) {

            System.out.println(
                    "Patient reassigned successfully."
            );

        } else {

            System.out.println(
                    "Nurse not found."
            );
        }
    }


    public void appointmentMenu() {

        boolean back = false;

        while (!back) {

            System.out.println();
            System.out.println(
                    "===== Appointment Menu ====="
            );

            System.out.println("1. Schedule Appointment");
            System.out.println("2. View All");
            System.out.println("3. Search");
            System.out.println("4. Cancel");
            System.out.println("5. Complete");
            System.out.println("6. Reschedule");
            System.out.println("7. Remove");
            System.out.println("8. List By Status");
            System.out.println("9. List By Patient");
            System.out.println("10. Back");

            int choice =
                    input.readInt(
                            "Choose an option",
                            1,
                            10
                    );

            if (choice == 1) {

                scheduleAppointmentHandler();

            } else if (choice == 2) {

                viewAppointmentsHandler();

            } else if (choice == 3) {

                searchAppointmentHandler();

            } else if (choice == 4) {

                cancelAppointmentHandler();

            } else if (choice == 5) {

                completeAppointmentHandler();

            } else if (choice == 6) {

                rescheduleAppointmentHandler();

            } else if (choice == 7) {

                removeAppointmentHandler();

            } else if (choice == 8) {

                listAppointmentsByStatusHandler();

            } else if (choice == 9) {

                listAppointmentsByPatientHandler();

            } else if (choice == 10) {

                back = true;
            }
        }
    }


    public void scheduleAppointmentHandler() {

        String appointmentId =
                input.readText(
                        "Appointment ID"
                );

        String patientId =
                input.readText(
                        "Patient ID"
                );

        String doctorId =
                input.readText(
                        "Doctor ID"
                );

        String date =
                input.readText(
                        "Appointment Date"
                );

        String time =
                input.readText(
                        "Appointment Time"
                );

        appointmentService.schedule(
                appointmentId,
                patientId,
                doctorId,
                date,
                time
        );

        System.out.println(
                "Appointment scheduled."
        );
    }


    public void viewAppointmentsHandler() {

        Object[] appointments =
                appointmentService.getAll();

        if (appointments.length == 0) {

            System.out.println(
                    "No appointments found."
            );

            return;
        }

        for (int i = 0;
             i < appointments.length;
             i++) {

            Appointment appointment =
                    (Appointment) appointments[i];

            appointment.displayInfo();
        }
    }


    public void searchAppointmentHandler() {

        String keyword =
                input.readText(
                        "Search keyword"
                );

        Object[] results =
                appointmentService.search(
                        keyword
                );

        if (results.length == 0) {

            System.out.println(
                    "No appointments found."
            );

            return;
        }

        for (int i = 0;
             i < results.length;
             i++) {

            Appointment appointment =
                    (Appointment) results[i];

            appointment.displayInfo();
        }
    }


    public void cancelAppointmentHandler() {

        String id =
                input.readText(
                        "Appointment ID"
                );

        boolean success =
                appointmentService.cancel(id);

        if (success) {

            System.out.println(
                    "Appointment cancelled."
            );

        } else {

            System.out.println(
                    "Appointment not found."
            );
        }
    }


    public void completeAppointmentHandler() {

        String id =
                input.readText(
                        "Appointment ID"
                );

        boolean success =
                appointmentService.complete(id);

        if (success) {

            System.out.println(
                    "Appointment completed."
            );

        } else {

            System.out.println(
                    "Appointment not found."
            );
        }
    }


    public void rescheduleAppointmentHandler() {

        String id =
                input.readText(
                        "Appointment ID"
                );

        String newDate =
                input.readText(
                        "New Date"
                );

        String newTime =
                input.readText(
                        "New Time"
                );

        boolean success =
                appointmentService.reschedule(
                        id,
                        newDate,
                        newTime
                );

        if (success) {

            System.out.println(
                    "Appointment rescheduled."
            );

        } else {

            System.out.println(
                    "Appointment not found."
            );
        }
    }


    public void removeAppointmentHandler() {

        String id =
                input.readText(
                        "Appointment ID"
                );

        boolean removed =
                appointmentService.removeById(id);

        if (removed) {

            System.out.println(
                    "Appointment removed."
            );

        } else {

            System.out.println(
                    "Appointment not found."
            );
        }
    }


    public void listAppointmentsByStatusHandler() {

        String status =
                input.readText(
                        "Status"
                );

        ArrayList results =
                appointmentService
                        .listByStatus(status);

        if (results.isEmpty()) {

            System.out.println(
                    "No appointments found."
            );

            return;
        }

        for (int i = 0;
             i < results.size();
             i++) {

            Appointment appointment =
                    (Appointment) results.get(i);

            appointment.displayInfo();
        }
    }


    public void listAppointmentsByPatientHandler() {

        String patientId =
                input.readText(
                        "Patient ID"
                );

        ArrayList results =
                appointmentService
                        .listByPatient(patientId);

        if (results.isEmpty()) {

            System.out.println(
                    "No appointments found."
            );

            return;
        }

        for (int i = 0;
             i < results.size();
             i++) {

            Appointment appointment =
                    (Appointment) results.get(i);

            appointment.displayInfo();
        }
    }


    public void recordMenu() {

        boolean back = false;

        while (!back) {

            System.out.println();
            System.out.println(
                    "===== Medical Record Menu ====="
            );

            System.out.println("1. Add Record");
            System.out.println("2. View All");
            System.out.println("3. Search");
            System.out.println("4. Update Notes");
            System.out.println("5. Remove");
            System.out.println("6. List By Patient");
            System.out.println("7. Count Confidential");
            System.out.println("8. Back");

            int choice =
                    input.readInt(
                            "Choose an option",
                            1,
                            8
                    );

            if (choice == 1) {

                addRecordHandler();

            } else if (choice == 2) {

                viewRecordsHandler();

            } else if (choice == 3) {

                searchRecordHandler();

            } else if (choice == 4) {

                updateRecordHandler();

            } else if (choice == 5) {

                removeRecordHandler();

            } else if (choice == 6) {

                listRecordsByPatientHandler();

            } else if (choice == 7) {

                countConfidentialHandler();

            } else if (choice == 8) {

                back = true;
            }
        }
    }


    public void addRecordHandler() {

        String recordId =
                input.readText(
                        "Record ID"
                );

        String patientId =
                input.readText(
                        "Patient ID"
                );

        String doctorId =
                input.readText(
                        "Doctor ID"
                );

        String visitDate =
                input.readText(
                        "Visit Date"
                );

        String diagnosis =
                input.readText(
                        "Diagnosis"
                );

        String prescription =
                input.readText(
                        "Prescription"
                );

        String notes =
                input.readText(
                        "Notes"
                );

        boolean confidential =
                input.readYesNo(
                        "Confidential"
                );

        MedicalRecord record =
                new MedicalRecord(
                        recordId,
                        patientId,
                        doctorId,
                        visitDate,
                        diagnosis,
                        prescription,
                        notes,
                        confidential
                );

        recordService.add(record);

        System.out.println(
                "Medical record added."
        );
    }


    public void viewRecordsHandler() {

        Object[] records =
                recordService.getAll();

        if (records.length == 0) {

            System.out.println(
                    "No medical records found."
            );

            return;
        }

        for (int i = 0;
             i < records.length;
             i++) {

            MedicalRecord record =
                    (MedicalRecord) records[i];

            record.displayInfo();
        }
    }


    public void searchRecordHandler() {

        String keyword =
                input.readText(
                        "Search keyword"
                );

        Object[] results =
                recordService.search(
                        keyword
                );

        if (results.length == 0) {

            System.out.println(
                    "No medical records found."
            );

            return;
        }

        for (int i = 0;
             i < results.length;
             i++) {

            MedicalRecord record =
                    (MedicalRecord) results[i];

            record.displayInfo();
        }
    }


    public void updateRecordHandler() {

        String id =
                input.readText(
                        "Record ID"
                );

        MedicalRecord record =
                (MedicalRecord)
                        recordService.searchById(id);

        if (record == null) {

            System.out.println(
                    "Record not found."
            );

            return;
        }

        String notes =
                input.readText(
                        "New Notes"
                );

        record.setNotes(notes);

        System.out.println(
                "Record updated."
        );
    }


    public void removeRecordHandler() {

        String id =
                input.readText(
                        "Record ID"
                );

        boolean removed =
                recordService.removeById(id);

        if (removed) {

            System.out.println(
                    "Record removed."
            );

        } else {

            System.out.println(
                    "Record not found."
            );
        }
    }


    public void listRecordsByPatientHandler() {

        String patientId =
                input.readText(
                        "Patient ID"
                );

        ArrayList results =
                recordService
                        .listByPatient(patientId);

        if (results.isEmpty()) {

            System.out.println(
                    "No medical records found."
            );

            return;
        }

        for (int i = 0;
             i < results.size();
             i++) {

            MedicalRecord record =
                    (MedicalRecord) results.get(i);

            record.displayInfo();
        }
    }


    public void countConfidentialHandler() {

        System.out.println(
                "Confidential Records: "
                        + recordService
                        .countConfidential()
        );
    }


    public void reportsMenu() {

        System.out.println(
                "Reports will be added in the next commit."
        );
    }

}
