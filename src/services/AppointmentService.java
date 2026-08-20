package services;

import entities.Appointment;
import entities.Patient;
import entities.Doctor;
import interfaces.Manageable;
import interfaces.Searchable;

import java.util.ArrayList;

public class AppointmentService implements Manageable, Searchable {

    private ArrayList appointments = new ArrayList();


    public Appointment schedule(
            String appointmentId,
            String patientId,
            String doctorId,
            String date) {

        Appointment appointment = new Appointment(
                appointmentId,
                patientId,
                doctorId,
                date,
                "09:00",
                "Scheduled",
                "General",
                false
        );

        add(appointment);

        return appointment;
    }


    public Appointment schedule(
            String appointmentId,
            String patientId,
            String doctorId,
            String date,
            String time) {

        Appointment appointment = new Appointment(
                appointmentId,
                patientId,
                doctorId,
                date,
                time,
                "Scheduled",
                "General",
                false
        );

        add(appointment);

        return appointment;
    }


    public Appointment schedule(
            String appointmentId,
            Patient patient,
            Doctor doctor,
            String date,
            String time,
            String reason) {

        if (patient == null || doctor == null) {
            return null;
        }

        Appointment appointment = new Appointment(
                appointmentId,
                patient.getId(),
                doctor.getId(),
                date,
                time,
                "Scheduled",
                reason,
                false
        );

        add(appointment);

        return appointment;
    }


    @Override
    public boolean add(Object entity) {

        if (!(entity instanceof Appointment)) {
            return false;
        }

        appointments.add(entity);

        return true;
    }


    @Override
    public boolean removeById(String id) {

        if (id == null || id.trim().isEmpty()) {
            return false;
        }

        for (int i = 0; i < appointments.size(); i++) {

            Appointment appointment =
                    (Appointment) appointments.get(i);

            if (appointment.getAppointmentId().equals(id)) {

                appointments.remove(i);

                return true;
            }
        }

        return false;
    }


    @Override
    public Object[] getAll() {

        return appointments.toArray();
    }


    @Override
    public Object[] search(String keyword) {

        ArrayList results = new ArrayList();

        if (keyword == null || keyword.trim().isEmpty()) {
            return results.toArray();
        }

        for (int i = 0; i < appointments.size(); i++) {

            Appointment appointment =
                    (Appointment) appointments.get(i);

            if (appointment.getReason() != null
                    && appointment.getReason()
                    .toLowerCase()
                    .contains(keyword.toLowerCase())) {

                results.add(appointment);
            }
        }

        return results.toArray();
    }


    @Override
    public Object searchById(String id) {

        if (id == null || id.trim().isEmpty()) {
            return null;
        }

        for (int i = 0; i < appointments.size(); i++) {

            Appointment appointment =
                    (Appointment) appointments.get(i);

            if (appointment.getAppointmentId().equals(id)) {

                return appointment;
            }
        }

        return null;
    }


    public boolean cancel(String appointmentId) {

        Appointment appointment =
                (Appointment) searchById(appointmentId);

        if (appointment == null) {
            return false;
        }

        appointment.cancel();

        return true;
    }


    public boolean complete(String appointmentId) {

        Appointment appointment =
                (Appointment) searchById(appointmentId);

        if (appointment == null) {
            return false;
        }

        appointment.complete();

        return true;
    }


    public boolean reschedule(
            String appointmentId,
            String newDate,
            String newTime) {

        Appointment appointment =
                (Appointment) searchById(appointmentId);

        if (appointment == null) {
            return false;
        }

        appointment.reschedule(
                newDate,
                newTime
        );

        return true;
    }


    public ArrayList listByStatus(String status) {

        ArrayList results = new ArrayList();

        if (status == null || status.trim().isEmpty()) {
            return results;
        }

        for (int i = 0; i < appointments.size(); i++) {

            Appointment appointment =
                    (Appointment) appointments.get(i);

            if (appointment.getStatus()
                    .equalsIgnoreCase(status)) {

                results.add(appointment);
            }
        }

        return results;
    }


    public ArrayList listByPatient(String patientId) {

        ArrayList results = new ArrayList();

        if (patientId == null || patientId.trim().isEmpty()) {
            return results;
        }

        for (int i = 0; i < appointments.size(); i++) {

            Appointment appointment =
                    (Appointment) appointments.get(i);

            if (appointment.getPatientId()
                    .equals(patientId)) {

                results.add(appointment);
            }
        }

        return results;
    }
}