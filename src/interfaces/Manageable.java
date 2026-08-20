package interfaces;

public interface Manageable {
    boolean removeById(String id);

    Object[] search(String keyword);

    Object searchById(String id);
}
