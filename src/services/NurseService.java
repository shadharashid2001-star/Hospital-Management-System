package services;

import interfaces.Manageable;
import interfaces.Searchable;

public class NurseService implements Manageable, Searchable {

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