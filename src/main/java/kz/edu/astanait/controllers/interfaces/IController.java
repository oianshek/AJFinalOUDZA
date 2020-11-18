package kz.edu.astanait.controllers.interfaces;

import javax.ws.rs.BadRequestException;
import java.util.List;

public interface IController<T> {
    List<T> getAll() throws BadRequestException;
}
