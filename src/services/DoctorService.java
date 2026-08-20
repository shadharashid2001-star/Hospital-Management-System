package services;

import entities.Doctor;
import entities.Surgeon;
import interfaces.Manageable;
import interfaces.Searchable;

import java.util.ArrayList;

public class DoctorService implements Manageable, Searchable {

    private ArrayList doctors = new ArrayList();


    @Override
    public boolean add(Object entity) {

        if (!(entity instanceof Doctor)) {
            return false;
        }

        doctors.add(entity);

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

            Doctor doctor =
                    (Doctor) doctors.get(i);

            if (doctor.getId().equals(id)) {

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

        ArrayList results = new ArrayList();

        for (int i = 0; i < doctors.size(); i++) {

            Doctor doctor =
                    (Doctor) doctors.get(i);

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

        for (int i = 0; i < doctors.size(); i++) {

            Doctor doctor =
                    (Doctor) doctors.get(i);

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

            System.out.println(
                    "Doctor not found."
            );

            return false;
        }

        doctor.assignPatient(patientId);

        return true;
    }


    public ArrayList listBySpecialization(
            String specialization) {

        ArrayList results = new ArrayList();

        for (int i = 0; i < doctors.size(); i++) {

            Doctor doctor =
                    (Doctor) doctors.get(i);

            if (doctor.getSpecialization()
                    .equalsIgnoreCase(specialization)) {

                results.add(doctor);
            }
        }

        return results;
    }


    public ArrayList availableDoctors() {

        ArrayList results = new ArrayList();

        for (int i = 0; i < doctors.size(); i++) {

            Doctor doctor =
                    (Doctor) doctors.get(i);

            if (doctor.isOnCall()) {

                results.add(doctor);
            }
        }

        return results;
    }
}