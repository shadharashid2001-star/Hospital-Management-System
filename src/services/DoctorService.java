package services;

import entities.Doctor;
import entities.Surgeon;
import interfaces.Manageable;
import interfaces.Searchable;
import java.util.ArrayList;

public class DoctorService implements Manageable, Searchable {

    private ArrayList<Doctor> doctors = new ArrayList<>();


    @Override
    public boolean add(Object entity) {

        if (!(entity instanceof Doctor)) {
            return false;
        }

        doctors.add((Doctor) entity);

        return true;
    }


    public Doctor addDoctor(Doctor doctor) {

        add(doctor);

        return doctor;
    }


    public Surgeon addSurgeon(Surgeon surgeon) {

        add(surgeon);

        return surgeon;
    }


    @Override
    public boolean removeById(String id) {

        for (int i = 0; i < doctors.size(); i++) {

            if (doctors.get(i).getId().equals(id)) {

                doctors.remove(i);

                return true;
            }
        }

        return false;
    }


    @Override
    public Object[] getAll() {

        return doctors.toArray();
    }


    @Override
    public Object[] search(String keyword) {

        ArrayList<Doctor> results = new ArrayList<>();

        for (Doctor doctor : doctors) {

            if (doctor.getFullName()
                    .toLowerCase()
                    .contains(keyword.toLowerCase())

                    || doctor.getSpecialization()
                    .toLowerCase()
                    .contains(keyword.toLowerCase())) {

                results.add(doctor);
            }
        }

        return results.toArray();
    }


    @Override
    public Object searchById(String id) {

        for (Doctor doctor : doctors) {

            if (doctor.getId().equals(id)) {
                return doctor;
            }
        }

        return null;
    }


    public boolean assignPatient(
            String doctorId,
            String patientId) {

        Doctor doctor =
                (Doctor) searchById(doctorId);

        if (doctor == null) {
            return false;
        }

        doctor.assignPatient(patientId);

        return true;
    }


    public ArrayList<Doctor> listBySpecialization(
            String specialization) {

        ArrayList<Doctor> results = new ArrayList<>();

        for (Doctor doctor : doctors) {

            if (doctor.getSpecialization()
                    .equalsIgnoreCase(specialization)) {

                results.add(doctor);
            }
        }

        return results;
    }


    public ArrayList<Doctor> availableDoctors() {

        ArrayList<Doctor> results = new ArrayList<>();

        for (Doctor doctor : doctors) {

            if (doctor.isOnCall()) {
                results.add(doctor);
            }
        }

        return results;
    }
}