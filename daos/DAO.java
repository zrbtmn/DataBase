package daos;


import java.util.List;

public interface DAO<T> {
    void add(T object);
    List <T> getAll();
    T get(T obj);
    void update(T object);
    void remove(T object);

}
