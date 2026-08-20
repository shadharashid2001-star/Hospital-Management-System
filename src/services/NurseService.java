package services;

import entities.Nurse;
import interfaces.Manageable;
import interfaces.Searchable;

import java.util.ArrayList;

public class NurseService implements Manageable, Searchable {

    private ArrayList nurses = new ArrayList();


    @Override
    public boolean add(Object entity) {

        if (!(entity instanceof Nurse)) {
            return false;
        }

        nurses.add(entity);

        return true;
    }


    @Override
    public boolean removeById(String id) {

        if (id == null || id.trim().isEmpty()) {
            return false;
        }

        for (int i = 0; i < nurses.size(); i++) {

            Nurse nurse =
                    (Nurse) nurses.get(i);

            if (nurse.getId().equals(id)) {

                nurses.remove(i);

                return true;
            }
        }

        return false;
    }


    @Override
    public Object[] getAll() {

        return nurses.toArray();
    }


    @Override
    public Object[] search(String keyword) {

        ArrayList results = new ArrayList();

        if (keyword == null
                || keyword.trim().isEmpty()) {

            return results.toArray();
        }

        for (int i = 0; i < nurses.size(); i++) {

            Nurse nurse =
                    (Nurse) nurses.get(i);

            if (nurse.getFullName()
                    .toLowerCase()
                    .contains(keyword.toLowerCase())) {

                results.add(nurse);
            }
        }

        return results.toArray();
    }


    @Override
    public Object searchById(String id) {

        if (id == null || id.trim().isEmpty()) {
            return null;
        }

        for (int i = 0; i < nurses.size(); i++) {

            Nurse nurse =
                    (Nurse) nurses.get(i);

            if (nurse.getId().equals(id)) {

                return nurse;
            }
        }

        return null;
    }


    public ArrayList listByShift(String shift) {

        ArrayList results = new ArrayList();

        if (shift == null || shift.trim().isEmpty()) {
            return results;
        }

        for (int i = 0; i < nurses.size(); i++) {

            Nurse nurse =
                    (Nurse) nurses.get(i);

            if (nurse.getShift()
                    .equalsIgnoreCase(shift)) {

                results.add(nurse);
            }
        }

        return results;
    }


    public boolean reassign(
            String nurseId,
            String oldPatientId,
            String newPatientId) {

        Nurse nurse =
                (Nurse) searchById(nurseId);

        if (nurse == null) {
            return false;
        }

        nurse.unassignPatient(oldPatientId);
        nurse.assignPatient(newPatientId);

        return true;
    }
}