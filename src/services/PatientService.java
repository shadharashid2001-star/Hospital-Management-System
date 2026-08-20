package services;

import entities.Patient;
import interfaces.Manageable;
import interfaces.Searchable;

import java.util.ArrayList;

public class PatientService implements Manageable, Searchable {

    private ArrayList<Patient> patients = new ArrayList<>();



    public Patient addPatient(
            String id,
            String firstName,
            String lastName) {

        Patient patient = new Patient(
                id,
                firstName,
                lastName,
                "2001-01-29",
                "Unknown",
                "00000000",
                "",
                "",
                id,
                0,
                true,
                "Unknown",
                "",
                "2026-01-01",
                0,
                false
        );

        patients.add(patient);

        return patient;
    }

    public Patient addPatient(
            String id,
            String firstName,
            String lastName,
            String bloodGroup) {

        Patient patient = new Patient(
                id,
                firstName,
                lastName,
                "2000-01-01",
                "Unknown",
                "00000000",
                "",
                "",
                id,
                0,
                true,
                bloodGroup,
                "",
                "2026-01-01",
                0,
                false
        );

        patients.add(patient);

        return patient;
    }


    public Patient addPatient(Patient patient) {

        patients.add(patient);

        return patient;
    }


    public ArrayList<Patient> getPatients() {
        return patients;
    }
}