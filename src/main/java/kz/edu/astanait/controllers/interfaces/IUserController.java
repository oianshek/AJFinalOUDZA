package kz.edu.astanait.controllers.interfaces;

import kz.edu.astanait.models.User;

import javax.ws.rs.BadRequestException;
import java.sql.SQLException;
import java.util.List;

public interface IUserController extends IController<User> {
    public User check(String email, String password) throws SQLException;
    public User getById(int id);
    List<User> getByGroup(String g) throws BadRequestException;
    List<User> getByCourse(int c) throws BadRequestException;
    List<User> getByMajor(String m) throws BadRequestException;
    List<User> getByName(String m) throws BadRequestException;
}
