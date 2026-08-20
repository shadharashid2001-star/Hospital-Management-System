package main;

import utils.InputHandler;

public class HospitalApp {

    private InputHandler input = new InputHandler();


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

      
        System.out.println("Patient menu.");
    }


    public void doctorMenu() {


        System.out.println("Doctor menu.");
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
