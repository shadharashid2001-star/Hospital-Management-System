

package services;

import entities.Doctor;
import entities.Surgeon;

import java.util.ArrayList;

public class DoctorService {

    private ArrayList<Doctor> doctors = new ArrayList<>();


    public Doctor addDoctor(Doctor doctor) {

        doctors.add(doctor);

        return doctor;
    }


    public Surgeon addSurgeon(Surgeon surgeon) {

        doctors.add(surgeon);

        return surgeon;
    }


    public boolean removeById(String id) {

        for (int i = 0; i < doctors.size(); i++) {

            if (doctors.get(i).getId().equals(id)) {

                doctors.remove(i);

                return true;
            }
        }

        return false;
    }


    public ArrayList<Doctor> getAll() {

        return doctors;
    }


    public ArrayList<Doctor> search(String keyword) {

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

        return results;
    }


    public Doctor searchById(String id) {

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

        Doctor doctor = searchById(doctorId);

        if (doctor == null) {

            System.out.println("Doctor not found.");

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


    public boolean updateFee(
            String doctorId,
            double fee) {

        Doctor doctor = searchById(doctorId);

        if (doctor == null) {

            System.out.println("Doctor not found.");

            return false;
        }

        doctor.updateFee(fee);

        return true;
    }


    public boolean updateFee(
            String doctorId,
            double fee,
            String reason) {

        Doctor doctor = searchById(doctorId);

        if (doctor == null) {

            System.out.println("Doctor not found.");

            return false;
        }

        doctor.updateFee(fee, reason);

        return true;
    }
}