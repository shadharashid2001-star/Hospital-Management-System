package services;

import entities.Appointment;
import entities.Patient;
import entities.Doctor;
import interfaces.Manageable;
import interfaces.Searchable;

import java.util.ArrayList;

public class AppointmentService implements Manageable, Searchable {

    private ArrayList<Appointment> appointments = new ArrayList<>();


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
                "",
                false
        );

        appointments.add(appointment);

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
                "",
                false
        );

        appointments.add(appointment);

        return appointment;
    }


    public Appointment schedule(
            String appointmentId,
            Patient patient,
            Doctor doctor,
            String date,
            String time,
            String reason) {

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

        appointments.add(appointment);

        return appointment;
    }


    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }

    @Override
    public boolean removeById(String id) {
        return false;
    }

    @Override
    public Object[] search(String keyword) {
        return new Object[0];
    }

    @Override
    public Object searchById(String id) {
        return null;
    }
}