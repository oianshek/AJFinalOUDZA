package kz.edu.astanait.controllers.interfaces;

import javax.ws.rs.BadRequestException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public interface IController<T>{
    void add(T entity) throws BadRequestException;
    void update(T entity) throws BadRequestException;
    void delete(int entity) throws BadRequestException;
    List<T> getAll() throws BadRequestException;
}
