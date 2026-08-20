package services;

import entities.Patient;
import entities.InPatient;
import interfaces.Manageable;
import interfaces.Searchable;

import java.util.ArrayList;

public class PatientService implements Manageable, Searchable {

    private ArrayList patients = new ArrayList();


    public Patient addPatient(
            String id,
            String firstName,
            String lastName) {

        Patient patient = new Patient(
                id,
                firstName,
                lastName,
                "01-01-2000",
                "Unknown",
                "00000000",
                "unknown@email.com",
                "Unknown",
                "N/A",
                20,
                true,
                "Unknown",
                "Unknown",
                "01-01-2026",
                0.0,
                false
        );

        add(patient);

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
                "01-01-2000",
                "Unknown",
                "00000000",
                "unknown@email.com",
                "Unknown",
                "N/A",
                20,
                true,
                bloodGroup,
                "Unknown",
                "01-01-2026",
                0.0,
                false
        );

        add(patient);

        return patient;
    }


    public Patient addPatient(Patient patient) {

        add(patient);

        return patient;
    }


    @Override
    public boolean add(Object entity) {

        if (!(entity instanceof Patient)) {
            return false;
        }

        patients.add(entity);

        return true;
    }


    @Override
    public boolean removeById(String id) {

        if (id == null || id.trim().isEmpty()) {
            return false;
        }

        for (int i = 0; i < patients.size(); i++) {

            Patient patient =
                    (Patient) patients.get(i);

            if (patient.getId().equals(id)) {

                patients.remove(i);

                return true;
            }
        }

        return false;
    }


    @Override
    public Object[] getAll() {

        return patients.toArray();
    }


    @Override
    public Object[] search(String keyword) {

        ArrayList results = new ArrayList();

        if (keyword == null
                || keyword.trim().isEmpty()) {

            return results.toArray();
        }

        for (int i = 0; i < patients.size(); i++) {

            Patient patient =
                    (Patient) patients.get(i);

            if (patient.getFullName()
                    .toLowerCase()
                    .contains(keyword.toLowerCase())) {

                results.add(patient);
            }
        }

        return results.toArray();
    }


    @Override
    public Object searchById(String id) {

        if (id == null || id.trim().isEmpty()) {
            return null;
        }

        for (int i = 0; i < patients.size(); i++) {

            Patient patient =
                    (Patient) patients.get(i);

            if (patient.getId().equals(id)) {

                return patient;
            }
        }

        return null;
    }


    public boolean updateContact(
            String patientId,
            String phone) {

        Patient patient =
                (Patient) searchById(patientId);

        if (patient == null) {
            return false;
        }

        patient.updateContact(phone);

        return true;
    }


    public boolean updateContact(
            String patientId,
            String phone,
            String email) {

        Patient patient =
                (Patient) searchById(patientId);

        if (patient == null) {
            return false;
        }

        patient.updateContact(phone, email);

        return true;
    }


    public ArrayList listInPatients() {

        ArrayList results = new ArrayList();

        for (int i = 0; i < patients.size(); i++) {

            Patient patient =
                    (Patient) patients.get(i);

            if (patient instanceof InPatient) {

                results.add(patient);
            }
        }

        return results;
    }


    public double totalOutstanding() {

        double total = 0.0;

        for (int i = 0; i < patients.size(); i++) {

            Patient patient =
                    (Patient) patients.get(i);

            total += patient.getOutstandingBalance();
        }

        return total;
    }
}