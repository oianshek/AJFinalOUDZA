package kz.edu.astanait.controllers.interfaces;

import kz.edu.astanait.models.User;

import java.sql.SQLException;

public interface IUserController extends IController<User>{
    User check(String email, String password) throws SQLException;
}
