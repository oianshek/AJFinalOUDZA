package kz.edu.astanait.controllers.interfaces;

import kz.edu.astanait.models.User;

import javax.ws.rs.BadRequestException;
import java.sql.SQLException;
import java.util.List;

public interface IController<T>{
    void add(T entity) throws BadRequestException;
    void update(T entity) throws BadRequestException;
    void delete(String id) throws BadRequestException;
    List<T> getAll() throws BadRequestException;
    T check(String email, String password) throws SQLException;
}
