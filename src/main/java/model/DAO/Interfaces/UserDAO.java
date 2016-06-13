package model.DAO.Interfaces;

import model.Entities.User;
import org.hibernate.Session;

public interface UserDAO {
    User checkUser(String email, String password, Session session);
}
