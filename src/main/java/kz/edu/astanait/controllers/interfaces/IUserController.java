package kz.edu.astanait.controllers.interfaces;

import kz.edu.astanait.models.User;

import javax.ws.rs.BadRequestException;
import java.sql.SQLException;
import java.util.List;

public interface IUserController<T> {
    public User check(String email, String password) throws SQLException;
    List<T> getAll() throws BadRequestException;
    public User getById(int id);
    List<T> getByGroup(String g) throws BadRequestException;
    List<T> getByCourse(int c) throws BadRequestException;
    List<T> getByMajor(String m) throws BadRequestException;
    List<T> getByName(String m) throws BadRequestException;
}
