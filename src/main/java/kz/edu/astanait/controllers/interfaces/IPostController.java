package kz.edu.astanait.controllers.interfaces;

import javax.ws.rs.BadRequestException;

public interface IPostController<T> extends IController<T>{
    void add(T entity) throws BadRequestException;
    void update(T entity) throws BadRequestException;
    void delete(int entity) throws BadRequestException;
}
