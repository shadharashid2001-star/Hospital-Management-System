package main;

import entities.Patient;
import entities.Doctor;
import entities.Surgeon;
import services.PatientService;
import services.DoctorService;
import utils.InputHandler;
import java.util.ArrayList;

public class HospitalApp {

    private InputHandler input = new InputHandler();

    private PatientService patientService =
            new PatientService();

    private DoctorService doctorService =
            new DoctorService();


    public static void main(String[] args) {

        HospitalApp app = new HospitalApp();

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

        boolean back = false;

        while (!back) {

            System.out.println();
            System.out.println(
                    "===== Patient Menu ====="
            );

            System.out.println("1. Add Patient");
            System.out.println("2. View All Patients");
            System.out.println("3. Search Patient");
            System.out.println("4. Update Contact");
            System.out.println("5. Remove Patient");
            System.out.println("6. List InPatients");
            System.out.println("7. Total Outstanding");
            System.out.println("8. Back");

            int choice = input.readInt(
                    "Choose an option",
                    1,
                    8
            );

            if (choice == 1) {

                addPatientHandler();

            } else if (choice == 2) {

                viewPatientsHandler();

            } else if (choice == 3) {

                searchPatientHandler();

            } else if (choice == 4) {

                updatePatientHandler();

            } else if (choice == 5) {

                removePatientHandler();

            } else if (choice == 6) {

                listInPatientsHandler();

            } else if (choice == 7) {

                showOutstandingHandler();

            } else if (choice == 8) {

                back = true;
            }
        }
    }


    public void addPatientHandler() {

        String id =
                input.readText("Patient ID");

        String firstName =
                input.readText("First Name");

        String lastName =
                input.readText("Last Name");

        String bloodGroup =
                input.readText("Blood Group");

        patientService.addPatient(
                id,
                firstName,
                lastName,
                bloodGroup
        );

        System.out.println(
                "Patient added successfully."
        );
    }


    public void viewPatientsHandler() {

        Object[] patients =
                patientService.getAll();

        if (patients.length == 0) {

            System.out.println("No patients found.");
            return;
        }

        for (int i = 0; i < patients.length; i++) {

            Patient patient = (Patient) patients[i];

            patient.displaySummary();
        }
    }


    public void searchPatientHandler() {

        String keyword = input.readText("Search keyword");

        Object[] results = patientService.search(keyword);

        if (results.length == 0) {

            System.out.println("No patients found.");
            return;
        }

        for (int i = 0; i < results.length; i++) {

            Patient patient = (Patient) results[i];

            patient.displayInfo();
        }
    }


    public void updatePatientHandler() {

        String id = input.readText("Patient ID");

        String phone = input.readText("New Phone");

        String email = input.readText("New Email");

        boolean updated =
                patientService.updateContact(
                        id,
                        phone,
                        email
                );

        if (updated) {

            System.out.println("Patient contact updated."
            );

        } else {

            System.out.println("Patient not found."
            );
        }
    }


    public void removePatientHandler() {

        String id =
                input.readText("Patient ID");

        boolean removed =
                patientService.removeById(id);

        if (removed) {

            System.out.println("Patient removed."
            );

        } else {

            System.out.println("Patient not found."
            );
        }
    }


    public void listInPatientsHandler() {

        ArrayList results =
                patientService.listInPatients();

        if (results.isEmpty()) {

            System.out.println("No InPatients found."
            );

            return;
        }

        for (int i = 0; i < results.size(); i++) {

            Patient patient = (Patient) results.get(i);

            patient.displayInfo();
        }
    }


    public void showOutstandingHandler() {

        double total = patientService.totalOutstanding();

        System.out.println(
                "Total Outstanding: " + total
        );
    }


    public void doctorMenu() {

        boolean back = false;

        while (!back) {

            System.out.println();
            System.out.println(
                    "===== Doctor Menu ====="
            );

            System.out.println("1. Add Doctor");
            System.out.println("2. View All Doctors");
            System.out.println("3. Search Doctor");
            System.out.println("4. Update Fee");
            System.out.println("5. Remove Doctor");
            System.out.println("6. Add Surgeon");
            System.out.println("7. Assign Patient");
            System.out.println("8. List By Specialization");
            System.out.println("9. Available Doctors");
            System.out.println("10. Back");

            int choice = input.readInt(
                    "Choose an option",
                    1,
                    10
            );

            if (choice == 1) {

                addDoctorHandler();

            } else if (choice == 2) {

                viewDoctorsHandler();

            } else if (choice == 3) {

                searchDoctorHandler();

            } else if (choice == 4) {

                updateDoctorFeeHandler();

            } else if (choice == 5) {

                removeDoctorHandler();

            } else if (choice == 6) {

                addSurgeonHandler();

            } else if (choice == 7) {

                assignPatientHandler();

            } else if (choice == 8) {

                listDoctorsBySpecializationHandler();

            } else if (choice == 9) {

                availableDoctorsHandler();

            } else if (choice == 10) {

                back = true;
            }
        }
    }


    public void addDoctorHandler() {

        String id = input.readText("Doctor ID");

        String firstName = input.readText("First Name");

        String lastName = input.readText("Last Name");

        String dateOfBirth = input.readText("Date of Birth");

        String gender = input.readText("Gender");

        String phone = input.readText("Phone");

        String email = input.readText("Email");

        String address = input.readText("Address");

        String nationalId = input.readText("National ID");

        int age = input.readInt("Age", 0, 120);

        String specialization = input.readText("Specialization");

        int experience = input.readInt("Experience Years");

        double fee = input.readDouble("Consultation Fee");

        boolean onCall = input.readYesNo("Is doctor on call");

        Doctor doctor = new Doctor(
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
                specialization,
                experience,
                fee,
                onCall
        );

        doctorService.addDoctor(doctor);

        System.out.println(
                "Doctor added successfully."
        );
    }


    public void viewDoctorsHandler() {

        Object[] doctors =
                doctorService.getAll();

        if (doctors.length == 0) {

            System.out.println(
                    "No doctors found."
            );

            return;
        }

        for (int i = 0; i < doctors.length; i++) {

            Doctor doctor =
                    (Doctor) doctors[i];

            doctor.displaySummary();
        }
    }


    public void searchDoctorHandler() {

        String keyword =
                input.readText("Search keyword");

        Object[] results =
                doctorService.search(keyword);

        if (results.length == 0) {

            System.out.println(
                    "No doctors found."
            );

            return;
        }

        for (int i = 0; i < results.length; i++) {

            Doctor doctor =
                    (Doctor) results[i];

            doctor.displayInfo();
        }
    }


    public void updateDoctorFeeHandler() {

        String id =
                input.readText("Doctor ID");

        Doctor doctor =
                (Doctor) doctorService.searchById(id);

        if (doctor == null) {

            System.out.println(
                    "Doctor not found."
            );

            return;
        }

        double fee =
                input.readDouble("New Fee");

        String reason =
                input.readText("Reason");

        doctor.updateFee(
                fee,
                reason
        );

        System.out.println(
                "Doctor fee updated."
        );
    }


    public void removeDoctorHandler() {

        String id =
                input.readText("Doctor ID");

        boolean removed =
                doctorService.removeById(id);

        if (removed) {

            System.out.println(
                    "Doctor removed."
            );

        } else {

            System.out.println(
                    "Doctor not found."
            );
        }
    }


    public void addSurgeonHandler() {

        String id =
                input.readText("Surgeon ID");

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

        String specialization =
                input.readText("Specialization");

        int experience =
                input.readInt("Experience Years");

        double fee =
                input.readDouble("Consultation Fee");

        boolean onCall =
                input.readYesNo("Is surgeon on call");

        int surgeries =
                input.readInt("Surgeries Performed");

        boolean theatreAccess =
                input.readYesNo(
                        "Operation Theatre Access"
                );

        Surgeon surgeon = new Surgeon(
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
                specialization,
                experience,
                fee,
                onCall,
                surgeries,
                theatreAccess
        );

        doctorService.addSurgeon(surgeon);

        System.out.println(
                "Surgeon added successfully."
        );
    }


    public void assignPatientHandler() {

        String doctorId =
                input.readText("Doctor ID");

        String patientId =
                input.readText("Patient ID");

        boolean success =
                doctorService.assignPatient(
                        doctorId,
                        patientId
                );

        if (success) {

            System.out.println(
                    "Patient assigned."
            );

        } else {

            System.out.println(
                    "Doctor not found."
            );
        }
    }


    public void listDoctorsBySpecializationHandler() {

        String specialization =
                input.readText("Specialization");

        ArrayList results =
                doctorService.listBySpecialization(
                        specialization
                );

        if (results.isEmpty()) {

            System.out.println(
                    "No doctors found."
            );

            return;
        }

        for (int i = 0; i < results.size(); i++) {

            Doctor doctor =
                    (Doctor) results.get(i);

            doctor.displayInfo();
        }
    }


    public void availableDoctorsHandler() {

        ArrayList results =
                doctorService.availableDoctors();

        if (results.isEmpty()) {

            System.out.println(
                    "No available doctors."
            );

            return;
        }

        for (int i = 0; i < results.size(); i++) {

            Doctor doctor =
                    (Doctor) results.get(i);

            doctor.displayInfo();
        }
    }


    public void nurseMenu() {


        System.out.println("Nurse menu.");
    }


    public void appointmentMenu() {


        System.out.println("Appointment menu.");
    }


    public void recordMenu() {


        System.out.println("Medical Record menu.");
    }


    public void reportsMenu() {


        System.out.println("Reports menu.");
    }
}