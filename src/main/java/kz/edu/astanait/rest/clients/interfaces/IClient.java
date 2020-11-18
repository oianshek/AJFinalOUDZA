package kz.edu.astanait.rest.clients.interfaces;

import java.util.List;

public interface IClient<T> {
    void add(T entity);
    void update(T entity);
    void delete(int entity);
    List<T> getAll();
}
