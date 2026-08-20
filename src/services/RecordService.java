package services;

import entities.MedicalRecord;
import interfaces.Manageable;
import interfaces.Searchable;

import java.util.ArrayList;

public class RecordService implements Manageable, Searchable {

    private ArrayList records = new ArrayList();


    @Override
    public boolean add(Object entity) {

        if (!(entity instanceof MedicalRecord)) {
            return false;
        }

        records.add(entity);

        return true;
    }


    @Override
    public boolean removeById(String id) {

        if (id == null || id.trim().isEmpty()) {
            return false;
        }

        for (int i = 0; i < records.size(); i++) {

            MedicalRecord record =
                    (MedicalRecord) records.get(i);

            if (record.getRecordId().equals(id)) {

                records.remove(i);

                return true;
            }
        }

        return false;
    }


    @Override
    public Object[] getAll() {

        return records.toArray();
    }


    @Override
    public Object[] search(String keyword) {

        ArrayList results = new ArrayList();

        if (keyword == null || keyword.trim().isEmpty()) {
            return results.toArray();
        }

        for (int i = 0; i < records.size(); i++) {

            MedicalRecord record =
                    (MedicalRecord) records.get(i);

            if ((record.getDiagnosis() != null
                    && record.getDiagnosis()
                    .toLowerCase()
                    .contains(keyword.toLowerCase()))

                    || (record.getNotes() != null
                    && record.getNotes()
                    .toLowerCase()
                    .contains(keyword.toLowerCase()))) {

                results.add(record);
            }
        }

        return results.toArray();
    }


    @Override
    public Object searchById(String id) {

        if (id == null || id.trim().isEmpty()) {
            return null;
        }

        for (int i = 0; i < records.size(); i++) {

            MedicalRecord record =
                    (MedicalRecord) records.get(i);

            if (record.getRecordId().equals(id)) {

                return record;
            }
        }

        return null;
    }


    public ArrayList listByPatient(String patientId) {

        ArrayList results = new ArrayList();

        if (patientId == null || patientId.trim().isEmpty()) {
            return results;
        }

        for (int i = 0; i < records.size(); i++) {

            MedicalRecord record =
                    (MedicalRecord) records.get(i);

            if (record.getPatientId().equals(patientId)) {

                results.add(record);
            }
        }

        return results;
    }


    public Integer countConfidential() {

        Integer count = 0;

        for (int i = 0; i < records.size(); i++) {

            MedicalRecord record =
                    (MedicalRecord) records.get(i);

            if (record.isConfidential()) {
                count++;
            }
        }

        return count;
    }
}