package kz.edu.astanait.controllers.interfaces;

import javax.ws.rs.BadRequestException;
import java.util.List;

public interface IController <T>{
    void add(T entity) throws BadRequestException;
    void update(T entity) throws BadRequestException;
    void delete(String id) throws BadRequestException;
    List<T> getAll() throws BadRequestException;
}
