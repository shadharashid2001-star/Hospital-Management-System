package services;

import entities.Patient;
import entities.InPatient;
import interfaces.Manageable;
import interfaces.Searchable;

public class PatientService implements Manageable, Searchable {

    private Patient[] patients = new Patient[100];
    private int count = 0;


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

        if (count >= patients.length) {
            return false;
        }

        patients[count] = (Patient) entity;
        count++;

        return true;
    }


    @Override
    public boolean removeById(String id) {

        for (int i = 0; i < count; i++) {

            if (patients[i].getId().equals(id)) {

                for (int j = i; j < count - 1; j++) {
                    patients[j] = patients[j + 1];
                }

                patients[count - 1] = null;
                count--;

                return true;
            }
        }

        return false;
    }


    @Override
    public Object[] getAll() {

        Patient[] result = new Patient[count];

        for (int i = 0; i < count; i++) {
            result[i] = patients[i];
        }

        return result;
    }


    @Override
    public Object[] search(String keyword) {

        Patient[] temp = new Patient[count];
        int found = 0;

        for (int i = 0; i < count; i++) {

            if (patients[i]
                    .getFullName()
                    .toLowerCase()
                    .contains(keyword.toLowerCase())) {

                temp[found] = patients[i];
                found++;
            }
        }

        Patient[] result = new Patient[found];

        for (int i = 0; i < found; i++) {
            result[i] = temp[i];
        }

        return result;
    }


    @Override
    public Object searchById(String id) {

        for (int i = 0; i < count; i++) {

            if (patients[i].getId().equals(id)) {
                return patients[i];
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


    public InPatient[] listInPatients() {

        InPatient[] temp = new InPatient[count];
        int found = 0;

        for (int i = 0; i < count; i++) {

            if (patients[i] instanceof InPatient) {

                temp[found] = (InPatient) patients[i];
                found++;
            }
        }

        InPatient[] result = new InPatient[found];

        for (int i = 0; i < found; i++) {
            result[i] = temp[i];
        }

        return result;
    }


    public double totalOutstanding() {

        double total = 0.0;

        for (int i = 0; i < count; i++) {

            total += patients[i].getOutstandingBalance();
        }

        return total;
    }
}