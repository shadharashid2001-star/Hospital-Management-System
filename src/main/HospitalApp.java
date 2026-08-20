import entities.Person;
import entities.Patient;
import entities.Doctor;
import entities.Nurse;
import entities.InPatient;
import entities.Surgeon;

import java.util.ArrayList;

public class HospitalApp {

    public void countByType(ArrayList<Person> people) {

        Integer patientCount = 0;
        Integer doctorCount = 0;
        Integer nurseCount = 0;
        Integer inPatientCount = 0;
        Integer surgeonCount = 0;

        for (Person person : people) {

            if (person instanceof InPatient) {

                inPatientCount++;
                patientCount++;

            } else if (person instanceof Surgeon) {

                surgeonCount++;
                doctorCount++;

            } else if (person instanceof Patient) {

                patientCount++;

            } else if (person instanceof Doctor) {

                doctorCount++;

            } else if (person instanceof Nurse) {

                nurseCount++;
            }
        }

        System.out.println("Patients: " + patientCount);
        System.out.println("InPatients: " + inPatientCount);
        System.out.println("Doctors: " + doctorCount);
        System.out.println("Surgeons: " + surgeonCount);
        System.out.println("Nurses: " + nurseCount);
    }


    public Person findOldest(ArrayList<Person> people) {

        Person oldest = null;

        for (Person person : people) {

            if (oldest == null
                    || person.getAge() > oldest.getAge()) {

                oldest = person;
            }
        }

        return oldest;
    }


    public static void main(String[] args) {

        HospitalApp app = new HospitalApp();

        ArrayList<Person> people = new ArrayList<>();


        app.countByType(people);

        Person oldest = app.findOldest(people);

        if (oldest != null) {

            System.out.println(
                    "Oldest Person: "
                            + oldest.getFullName()
                            + " - "
                            + oldest.getAge()
            );
        }
    }
}