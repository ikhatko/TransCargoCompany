package model.DAO.Interfaces;

import model.Entities.User;

public interface UserDAO {
    UserDAO getUserById(int userId);
    void createUser(User user);
    void updateUser(User user);
    void deleteUserById(int userId);
}
